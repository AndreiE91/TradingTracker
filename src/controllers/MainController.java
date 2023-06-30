package controllers;

import models.*;
import models.exceptions.NoOpenPositionException;
import views.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class MainController {
    DecimalFormat decimalFormat = new DecimalFormat("#.00");
    public MainController(ViewMain view, Account account) {

        view.getLabelBalanceValue().setText(String.valueOf(account.getBalance()) + " USDT");

        view.addEditBalanceListener(e -> {
            view.setVisibleEditBalance(true);
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

        view.addBuyListener(e -> {
            try {
                double entryPrice = Double.parseDouble(view.getTextFieldEntryPrice().getText());
                double sizeInUsdt = Double.parseDouble(view.getTextFieldOpenAmount().getText());
                double leverage = sizeInUsdt / account.getBalance();
                double liqPriceInUsdt = entryPrice - 0.85 * (entryPrice * (1 / leverage));
                double orderFeePercentage = Double.parseDouble(view.getTextFieldOrderFee().getText());
                Trade trade = new Trade(entryPrice, sizeInUsdt, leverage, liqPriceInUsdt, Side.LONG);
                account.setTrade(trade);
                account.setBalance(account.getBalance() - sizeInUsdt * orderFeePercentage);
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
                double entryPrice = Double.parseDouble(view.getTextFieldEntryPrice().getText());
                double sizeInUsdt = Double.parseDouble(view.getTextFieldOpenAmount().getText());
                double leverage = sizeInUsdt / account.getBalance();
                double liqPriceInUsdt = entryPrice + 0.85 * (entryPrice * (1 / leverage));
                Trade trade = new Trade(entryPrice, sizeInUsdt, leverage, liqPriceInUsdt, Side.LONG);
                account.setTrade(trade);
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

                if(view.getLabelSide().getText().equals("Long")) {
                    pnl = (closePrice - entryPrice) * (sizeInUsdt / entryPrice); // Long(profit from higher close price)
                } else if(view.getLabelSide().getText().equals("Short")){
                    pnl = (entryPrice - closePrice) * (sizeInUsdt / entryPrice); // Short(profit from lower close price)
                } else {
                    throw new NoOpenPositionException("There is no open position!");
                }
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