package models;

import java.util.ArrayList;
import java.util.List;

public class Account {
    double balance;
    Trade trade;

    public Account(double balance, Trade trade) {
        this.balance = balance;
        this.trade = trade;
    }

    public Account() {}

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Trade getTrade() {
        return trade;
    }

    public void setTrade(Trade trade) {
        this.trade = trade;
    }
}
