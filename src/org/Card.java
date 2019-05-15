package org;

public class Card {
    private int cardNumber;
    private int pinCode;
    private int balance;

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public int getBalance() {
        return balance;
    }

    public int takeMoney(int money) throws NotEnoughMoneyException {
        if (money > balance)
            throw new NotEnoughMoneyException();

        balance -= money;
        return money;
    }

    public int putMoney(int money) {
        balance += money;
        return money;
    }

    public Card(int cardNumber, int pinCode, int balance) {
        this.cardNumber = cardNumber;
        this.pinCode = pinCode;
        this.balance = balance;
    }

    public Card(int cardNumber, int pinCode) {
        this(cardNumber, pinCode, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass())
            return false;
        if (o == this)
            return true;
        Card that = (Card) o;
        return this.cardNumber == that.cardNumber && this.pinCode == that.pinCode;
    }

    @Override
    public int hashCode() {
        int result = 17;
        int prime = 31;

        result = result * prime + cardNumber;
        result = result * prime + pinCode;

        return result;
    }
}

