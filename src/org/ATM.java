package org;

import java.util.Scanner;
import java.util.Set;
public class ATM {
    // делаем сет так как все карты разные
    private Set<Card> cashCards;

    public ATM(Set<Card> cashCards) {
        this.cashCards = cashCards;
    }

    public void setCashCards(Set<Card> cashCards) {
        this.cashCards = cashCards;
    }

    public void run() {
        do {

            System.out.println("Вставьте карту");
            Scanner inputCardScanner = new Scanner(System.in);
            String inputCard = inputCardScanner.nextLine(); //"вставляем" карту нажатием Enter

            System.out.println("Введите номер карты");
            int cardNumber = inputCardScanner.nextInt();

            System.out.println("Введите пинкод");
            int pinCode = inputCardScanner.nextInt();

            Card cashCardToCheck = new Card(cardNumber, pinCode, 0);

            if (!cashCards.contains(cashCardToCheck)) {
                System.out.println("Неправильно введен номер карты или пинкод!");


                continue;
            } else {

                do {

                    for (Card cashCard : cashCards) {
                        if (cashCard.equals(cashCardToCheck)) {
                            System.out.println("Ваш баланс: "
                                    + cashCard.getBalance());
                            break;
                        }
                    }
                    System.out.println("Введите сумму для снятия или 0 для выхода");
                    int moneyAmount = inputCardScanner.nextInt();
                    if (moneyAmount == 0)
                        break;
                    try {
                        for (Card cashCard : cashCards) {
                            if (cashCard.equals(cashCardToCheck)) {
                                System.out.println("С вашего счета было снято " +
                                        cashCard.takeMoney(moneyAmount));
                                break;
                            }
                        }
                    } catch (NotEnoughMoneyException e) {
                        System.out.println("На вашем счету недостаточно средств");
                    }

                } while (true);
            }
        } while (true);
    }
}
