package controllers;

import models.*;
import models.exceptions.NoOpenPositionException;
import views.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class MainController {
    public MainController(ViewMain view, Account account) {

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(Locale.getDefault());
        symbols.setDecimalSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("0.00", symbols);

        DecimalFormat decimalFormatOrderFee = new DecimalFormat("0.0000", symbols);

        view.getLabelBalanceValue().setText(String.valueOf(account.getBalance()) + " USDT");

        view.addEditBalanceListener(e -> {
            view.setVisibleEditBalance(true);
        });

        view.addEditOrderFeeListener(e -> {
            view.setVisibleEditFees(true);
        });

        view.addSetBalanceListener(e -> {
            try {
                account.setBalance(Double.parseDouble(view.getTextFieldSetBalance().getText()));
                view.getLabelBalanceValue().setText(String.valueOf(decimalFormat.format(account.getBalance())) + " USDT");
                view.getTextFieldSetBalance().setText(null);
                view.setVisibleEditBalance(false);
            } catch (NumberFormatException ex) {
                view.showErrorMessage(ex.getMessage());
            }
        });

        view.addSetOrderFeeListener(e -> {
            try {
                view.getLabelOrderFeeValue().setText(String.valueOf(decimalFormatOrderFee.format(Double.parseDouble(view.getTextFieldSetOrderFee().getText()))) + "%");
                view.getTextFieldSetOrderFee().setText(null);
                view.setVisibleEditFees(false);
            } catch (NumberFormatException ex) {
                view.showErrorMessage(ex.getMessage());
            }
        });

        view.addBuyListener(e -> {
            try {
                double orderFeePercentage = Double.parseDouble(view.getLabelOrderFeeValue().getText().split("%")[0]) / 100;
                double sizeInUsdt = Double.parseDouble(view.getTextFieldOpenAmount().getText());
                account.setBalance(account.getBalance() - sizeInUsdt * orderFeePercentage);

                double entryPrice = Double.parseDouble(view.getTextFieldEntryPrice().getText());
                double leverage = sizeInUsdt / account.getBalance();
                double liqPriceInUsdt = entryPrice - 0.85 * (entryPrice * (1 / leverage));

                Trade trade = new Trade(entryPrice, sizeInUsdt, leverage, liqPriceInUsdt, Side.LONG);
                account.setTrade(trade);

                view.getLabelBalanceValue().setText(decimalFormat.format(account.getBalance()) + " USDT");
                view.getLabelSide().setText("Long");
                view.getLabelAvgPriceValue().setText(String.valueOf(decimalFormat.format(entryPrice)));
                view.getLabelSizeValue().setText(String.valueOf(decimalFormat.format(sizeInUsdt)));
                view.getLabelLeverage().setText(decimalFormat.format(leverage) + "x");
                view.getLabelLiqPriceValue().setText(String.valueOf(decimalFormat.format(liqPriceInUsdt)));
                view.getTextFieldEntryPrice().setText(null);
                view.getTextFieldOpenAmount().setText(null);
            } catch (NumberFormatException ex) {
                view.showErrorMessage(ex.getMessage());
            }

        });

        view.addSellListener(e -> {
            try {
                double orderFeePercentage = Double.parseDouble(view.getLabelOrderFeeValue().getText().split("%")[0]) / 100;
                double sizeInUsdt = Double.parseDouble(view.getTextFieldOpenAmount().getText());
                account.setBalance(account.getBalance() - sizeInUsdt * orderFeePercentage);

                double entryPrice = Double.parseDouble(view.getTextFieldEntryPrice().getText());
                double leverage = sizeInUsdt / account.getBalance();
                double liqPriceInUsdt = entryPrice + 0.85 * (entryPrice * (1 / leverage));

                Trade trade = new Trade(entryPrice, sizeInUsdt, leverage, liqPriceInUsdt, Side.LONG);
                account.setTrade(trade);

                view.getLabelBalanceValue().setText(decimalFormat.format(account.getBalance()) + " USDT");
                view.getLabelSide().setText("Short");
                view.getLabelAvgPriceValue().setText(String.valueOf(decimalFormat.format(entryPrice)));
                view.getLabelSizeValue().setText(String.valueOf(decimalFormat.format(sizeInUsdt)));
                view.getLabelLeverage().setText(decimalFormat.format(leverage) + "x");
                view.getLabelLiqPriceValue().setText(String.valueOf(decimalFormat.format(liqPriceInUsdt)));
                view.getTextFieldEntryPrice().setText(null);
                view.getTextFieldOpenAmount().setText(null);
            } catch (NumberFormatException ex) {
                view.showErrorMessage(ex.getMessage());
            }

        });

        view.addCloseListener(e -> {
            try {
                double pnl = 0;
                double sizeInUsdt = account.getTrade().getSizeInUsdt();
                double closePrice = Double.parseDouble(view.getTextFieldClosePrice().getText());
                double entryPrice = account.getTrade().getEntryPrice();
                double orderFeePercentage = Double.parseDouble(view.getLabelOrderFeeValue().getText().split("%")[0]) / 100;

                if(view.getLabelSide().getText().equals("Long")) {
                    pnl = (closePrice - entryPrice) * (sizeInUsdt / entryPrice); // Long(profit from higher close price)
                } else if(view.getLabelSide().getText().equals("Short")){
                    pnl = (entryPrice - closePrice) * (sizeInUsdt / entryPrice); // Short(profit from lower close price)
                } else {
                    throw new NoOpenPositionException("There is no open position!");
                }
                account.setBalance(account.getBalance() - sizeInUsdt * orderFeePercentage);
                account.setBalance(account.getBalance() + pnl);
                view.getLabelBalanceValue().setText(decimalFormat.format(account.getBalance()) + " USDT");
                view.getLabelAvgPriceValue().setText("0 USDT");
                view.getLabelSizeValue().setText("0 USDT");
                view.getLabelLeverage().setText("0x");
                view.getLabelLiqPriceValue().setText("0 USDT");
                view.getTextFieldClosePrice().setText(null);
                view.getLabelSide().setText("Neutral");
                account.setTrade(null);
            } catch (NumberFormatException | NoOpenPositionException ex) {
                view.showErrorMessage(ex.getMessage());
            }
        });
    }
}