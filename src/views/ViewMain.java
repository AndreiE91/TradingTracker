package views;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class ViewMain extends JFrame {

    JButton buttonSetBalance = new JButton("Set balance");
    JTextField textFieldSetBalance = new JTextField();

    JButton buttonSetOrderFee = new JButton("Set order fee");
    JTextField textFieldSetOrderFee = new JTextField();
    JLabel labelOrderFee = new JLabel("Order fee");
    JLabel labelOrderFeeValue = new JLabel("0.0750%");

    JLabel labelEntryPrice = new JLabel("Entry price:");
    JTextField textFieldEntryPrice = new JTextField();
    JLabel labelOpenAmount = new JLabel("Amount(USDT):");
    JTextField textFieldOpenAmount = new JTextField();
    JButton buttonBuy = new JButton("Buy/Long");
    JButton buttonSell = new JButton("Sell/Short");

    JLabel labelBalance = new JLabel("Balance");
    JLabel labelBalanceValue = new JLabel("0.00 USDT");
    JLabel labelAvgPrice = new JLabel("Avg. Price");
    JLabel labelAvgPriceValue = new JLabel("0.00 USDT");
    JLabel labelLiqPrice = new JLabel("Liq price");
    JLabel labelLiqPriceValue = new JLabel("0.00 USDT");
    JLabel labelSize = new JLabel("Size(USDT)");
    JLabel labelSizeValue = new JLabel("0.00 USDT");
    JLabel labelPositionTitle = new JLabel("BTC USDT Perpetual");
    JLabel labelLeverage = new JLabel("0.00x");
    JLabel labelSide = new JLabel("Neutral");

    JLabel labelClosePrice = new JLabel("Close price:");
    JTextField textFieldClosePrice = new JTextField();
    JButton buttonClose = new JButton("Close");
    JButton buttonEditBalance = new JButton("Edit balance...");
    JButton buttonEditOrderFee = new JButton("Edit fees...");


    public ViewMain() {
        setTitle("Trading Tracker");
        setBounds(100, 100, 900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        getContentPane().add(buttonSetBalance);
        getContentPane().add(textFieldSetBalance);
        getContentPane().add(labelEntryPrice);
        getContentPane().add(textFieldEntryPrice);
        getContentPane().add(labelOpenAmount);
        getContentPane().add(textFieldOpenAmount);
        getContentPane().add(labelBalance);
        getContentPane().add(labelBalanceValue);
        getContentPane().add(labelAvgPrice);
        getContentPane().add(labelAvgPriceValue);
        getContentPane().add(labelLiqPrice);
        getContentPane().add(labelLiqPriceValue);
        getContentPane().add(labelSize);
        getContentPane().add(labelSizeValue);
        getContentPane().add(labelPositionTitle);
        getContentPane().add(labelLeverage);
        getContentPane().add(buttonBuy);
        getContentPane().add(buttonSell);
        getContentPane().add(labelClosePrice);
        getContentPane().add(textFieldClosePrice);
        getContentPane().add(buttonClose);
        getContentPane().add(buttonEditBalance);
        getContentPane().add(labelSide);
        getContentPane().add(buttonSetOrderFee);
        getContentPane().add(buttonEditOrderFee);
        getContentPane().add(textFieldSetOrderFee);
        getContentPane().add(labelOrderFee);
        getContentPane().add(labelOrderFeeValue);
        getContentPane().setBackground(new Color(107, 159, 255));


        labelEntryPrice.setBounds(25, 200, 128, 36);
        labelEntryPrice.setFont(new Font("Tahoma", Font.BOLD, 12));

        labelOpenAmount.setBounds(25, 240, 128, 36);
        labelOpenAmount.setFont(new Font("Tahoma", Font.BOLD, 12));

        labelBalance.setBounds(750, 25, 150, 20);
        labelBalance.setFont(new Font("Tahoma", Font.BOLD, 12));

        labelBalanceValue.setBounds(700, 45, 150, 20);
        labelBalanceValue.setHorizontalAlignment(SwingConstants.CENTER);
        labelBalanceValue.setFont(new Font("Tahoma", Font.BOLD, 12));

        labelOrderFee.setBounds(750, 80, 150, 20);
        labelOrderFee.setFont(new Font("Tahoma", Font.BOLD, 12));

        labelOrderFeeValue.setBounds(700, 85, 150, 50);
        labelOrderFeeValue.setHorizontalAlignment(SwingConstants.CENTER);
        labelOrderFeeValue.setFont(new Font("Tahoma", Font.BOLD, 12));

        labelAvgPrice.setBounds(125, 70, 75, 20);
        labelAvgPrice.setFont(new Font("Tahoma", Font.BOLD, 12));

        labelAvgPriceValue.setBounds(125, 90, 100, 20);
        labelAvgPriceValue.setFont(new Font("Tahoma", Font.BOLD, 12));

        labelLiqPrice.setBounds(25, 70, 75, 20);
        labelLiqPrice.setFont(new Font("Tahoma", Font.BOLD, 12));

        labelLiqPriceValue.setBounds(25, 90, 100, 20);
        labelLiqPriceValue.setFont(new Font("Tahoma", Font.BOLD, 12));
        labelLiqPriceValue.setForeground(new Color(255, 50, 56));

        labelSize.setBounds(225, 70, 100, 20);
        labelSize.setFont(new Font("Tahoma", Font.BOLD, 12));

        labelSizeValue.setBounds(225, 90, 100, 20);
        labelSizeValue.setFont(new Font("Tahoma", Font.BOLD, 12));

        labelPositionTitle.setBounds(25, 25, 250, 40);
        labelPositionTitle.setFont(new Font("Tahoma", Font.BOLD, 20));

        labelLeverage.setBounds(325, 26, 100, 40);
        labelLeverage.setFont(new Font("Tahoma", Font.BOLD, 16));
        labelLeverage.setForeground(Color.darkGray);

        labelSide.setBounds(250, 26, 70, 40);
        labelSide.setFont(new Font("Tahoma", Font.BOLD, 16));
        labelSide.setHorizontalAlignment(SwingConstants.RIGHT);
        labelSide.setForeground(Color.darkGray);

        labelClosePrice.setBounds(25, 360, 72, 36);
        labelClosePrice.setFont(new Font("Tahoma", Font.BOLD, 12));

        textFieldSetBalance.setBounds(780, 370, 95, 27);
        textFieldSetBalance.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textFieldSetOrderFee.setBounds(670, 370, 95, 27);
        textFieldSetOrderFee.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textFieldClosePrice.setBounds(100, 368, 95, 25);
        textFieldClosePrice.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textFieldEntryPrice.setBounds(135, 205, 128, 25);
        textFieldEntryPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textFieldOpenAmount.setBounds(135, 245, 128, 25);
        textFieldOpenAmount.setFont(new Font("Tahoma", Font.PLAIN, 20));

        buttonSetBalance.setFont(new Font("Tahoma", Font.BOLD, 9));
        buttonSetBalance.setBounds(780, 400, 95, 27);
        buttonSetBalance.setBackground(new Color(154, 204, 100));

        buttonSetOrderFee.setFont(new Font("Tahoma", Font.BOLD, 8));
        buttonSetOrderFee.setBounds(670, 400, 95, 27);
        buttonSetOrderFee.setBackground(new Color(154, 204, 100));

        buttonBuy.setFont(new Font("Tahoma", Font.BOLD, 15));
        buttonBuy.setBounds(25, 300, 128, 36);
        buttonBuy.setBackground(Color.GREEN);

        buttonSell.setFont(new Font("Tahoma", Font.BOLD, 15));
        buttonSell.setBounds(165, 300, 128, 36);
        buttonSell.setBackground(Color.RED);

        buttonClose.setFont(new Font("Tahoma", Font.BOLD, 15));
        buttonClose.setBounds(25, 400, 168, 36);
        buttonClose.setBackground(new Color(43, 160, 255));

        buttonEditBalance.setFont(new Font("Tahoma", Font.BOLD, 9));
        buttonEditBalance.setBounds(770, 430, 110, 27);

        buttonEditOrderFee.setFont(new Font("Tahoma", Font.BOLD, 9));
        buttonEditOrderFee.setBounds(660, 430, 110, 27);

        textFieldSetBalance.setVisible(false);
        buttonSetBalance.setVisible(false);

        textFieldSetOrderFee.setVisible(false);
        buttonSetOrderFee.setVisible(false);

        this.setVisible(true);
    }

    public JButton getButtonSetOrderFee() {
        return buttonSetOrderFee;
    }

    public void setButtonSetOrderFee(JButton buttonSetOrderFee) {
        this.buttonSetOrderFee = buttonSetOrderFee;
    }

    public JTextField getTextFieldSetOrderFee() {
        return textFieldSetOrderFee;
    }

    public void setTextFieldSetOrderFee(JTextField textFieldSetOrderFee) {
        this.textFieldSetOrderFee = textFieldSetOrderFee;
    }

    public JLabel getLabelOrderFee() {
        return labelOrderFee;
    }

    public void setLabelOrderFee(JLabel labelOrderFee) {
        this.labelOrderFee = labelOrderFee;
    }

    public JLabel getLabelOrderFeeValue() {
        return labelOrderFeeValue;
    }

    public void setLabelOrderFeeValue(JLabel labelOrderFeeValue) {
        this.labelOrderFeeValue = labelOrderFeeValue;
    }

    public JButton getButtonEditOrderFee() {
        return buttonEditOrderFee;
    }

    public void setButtonEditOrderFee(JButton buttonEditOrderFee) {
        this.buttonEditOrderFee = buttonEditOrderFee;
    }

    public JButton getButtonSetBalance() {
        return buttonSetBalance;
    }

    public void setButtonSetBalance(JButton buttonSetBalance) {
        this.buttonSetBalance = buttonSetBalance;
    }

    public JTextField getTextFieldSetBalance() {
        return textFieldSetBalance;
    }

    public void setTextFieldSetBalance(JTextField textFieldSetBalance) {
        this.textFieldSetBalance = textFieldSetBalance;
    }

    public JLabel getLabelEntryPrice() {
        return labelEntryPrice;
    }

    public void setLabelEntryPrice(JLabel labelEntryPrice) {
        this.labelEntryPrice = labelEntryPrice;
    }

    public JTextField getTextFieldEntryPrice() {
        return textFieldEntryPrice;
    }

    public void setTextFieldEntryPrice(JTextField textFieldEntryPrice) {
        this.textFieldEntryPrice = textFieldEntryPrice;
    }

    public JLabel getLabelOpenAmount() {
        return labelOpenAmount;
    }

    public void setLabelOpenAmount(JLabel labelOpenAmount) {
        this.labelOpenAmount = labelOpenAmount;
    }

    public JTextField getTextFieldOpenAmount() {
        return textFieldOpenAmount;
    }

    public void setTextFieldOpenAmount(JTextField textFieldOpenAmount) {
        this.textFieldOpenAmount = textFieldOpenAmount;
    }

    public JButton getButtonBuy() {
        return buttonBuy;
    }

    public void setButtonBuy(JButton buttonBuy) {
        this.buttonBuy = buttonBuy;
    }

    public JButton getButtonSell() {
        return buttonSell;
    }

    public void setButtonSell(JButton buttonSell) {
        this.buttonSell = buttonSell;
    }

    public JLabel getLabelBalance() {
        return labelBalance;
    }

    public void setLabelBalance(JLabel labelBalance) {
        this.labelBalance = labelBalance;
    }

    public JLabel getLabelBalanceValue() {
        return labelBalanceValue;
    }

    public void setLabelBalanceValue(JLabel labelBalanceValue) {
        this.labelBalanceValue = labelBalanceValue;
    }

    public JLabel getLabelAvgPrice() {
        return labelAvgPrice;
    }

    public void setLabelAvgPrice(JLabel labelAvgPrice) {
        this.labelAvgPrice = labelAvgPrice;
    }

    public JLabel getLabelAvgPriceValue() {
        return labelAvgPriceValue;
    }

    public void setLabelAvgPriceValue(JLabel labelAvgPriceValue) {
        this.labelAvgPriceValue = labelAvgPriceValue;
    }

    public JLabel getLabelLiqPrice() {
        return labelLiqPrice;
    }

    public void setLabelLiqPrice(JLabel labelLiqPrice) {
        this.labelLiqPrice = labelLiqPrice;
    }

    public JLabel getLabelLiqPriceValue() {
        return labelLiqPriceValue;
    }

    public void setLabelLiqPriceValue(JLabel labelLiqPriceValue) {
        this.labelLiqPriceValue = labelLiqPriceValue;
    }

    public JLabel getLabelSize() {
        return labelSize;
    }

    public void setLabelSize(JLabel labelSize) {
        this.labelSize = labelSize;
    }

    public JLabel getLabelSizeValue() {
        return labelSizeValue;
    }

    public void setLabelSizeValue(JLabel labelSizeValue) {
        this.labelSizeValue = labelSizeValue;
    }

    public JLabel getLabelPositionTitle() {
        return labelPositionTitle;
    }

    public void setLabelPositionTitle(JLabel labelPositionTitle) {
        this.labelPositionTitle = labelPositionTitle;
    }

    public JLabel getLabelLeverage() {
        return labelLeverage;
    }

    public void setLabelLeverage(JLabel labelLeverage) {
        this.labelLeverage = labelLeverage;
    }

    public JLabel getLabelSide() {
        return labelSide;
    }

    public void setLabelSide(JLabel labelSide) {
        this.labelSide = labelSide;
    }

    public JLabel getLabelClosePrice() {
        return labelClosePrice;
    }

    public void setLabelClosePrice(JLabel labelClosePrice) {
        this.labelClosePrice = labelClosePrice;
    }

    public JTextField getTextFieldClosePrice() {
        return textFieldClosePrice;
    }

    public void setTextFieldClosePrice(JTextField textFieldClosePrice) {
        this.textFieldClosePrice = textFieldClosePrice;
    }

    public JButton getButtonClose() {
        return buttonClose;
    }

    public void setButtonClose(JButton buttonClose) {
        this.buttonClose = buttonClose;
    }

    public JButton getButtonEditBalance() {
        return buttonEditBalance;
    }

    public void setButtonEditBalance(JButton buttonEditBalance) {
        this.buttonEditBalance = buttonEditBalance;
    }

    public void addSetBalanceListener(ActionListener actionListener) {
        buttonSetBalance.addActionListener(actionListener);
    }

    public void addSetOrderFeeListener(ActionListener actionListener) {
        buttonSetOrderFee.addActionListener(actionListener);
    }

    public void addEditBalanceListener(ActionListener actionListener) {
        buttonEditBalance.addActionListener(actionListener);
    }

    public void addEditOrderFeeListener(ActionListener actionListener) {
        buttonEditOrderFee.addActionListener(actionListener);
    }

    public void addBuyListener(ActionListener actionListener) {
        buttonBuy.addActionListener(actionListener);
    }

    public void addSellListener(ActionListener actionListener) {
        buttonSell.addActionListener(actionListener);
    }

    public void addCloseListener(ActionListener actionListener) {
        buttonClose.addActionListener(actionListener);
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "",JOptionPane.INFORMATION_MESSAGE);
    }

    public void setVisibleEditBalance(boolean visible) {
        if(visible) {
            buttonSetBalance.setVisible(true);
            textFieldSetBalance.setVisible(true);
        } else {
            buttonSetBalance.setVisible(false);
            textFieldSetBalance.setVisible(false);
        }
    }

    public void setVisibleEditFees(boolean visible) {
        if(visible) {
            buttonSetOrderFee.setVisible(true);
            textFieldSetOrderFee.setVisible(true);
        } else {
            buttonSetOrderFee.setVisible(false);
            textFieldSetOrderFee.setVisible(false);
        }
    }
}