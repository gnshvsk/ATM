package org;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Card card1 = new Card(0001, 1111, 5000);
        Card card2 = new Card(0002, 2222, 100);
        Card card3 = new Card(0003, 3333, 1000000);
        Card card4 = new Card(0004, 4444, 4500);
        Card card5 = new Card(0005, 5555, 348);
        Card card6 = new Card(0006, 6666, 666);

        Set<Card> cashCards = new HashSet<Card>();
        cashCards.add(card1);
        cashCards.add(card2);
        cashCards.add(card3);
        cashCards.add(card4);
        cashCards.add(card5);
        cashCards.add(card6);

        new ATM(cashCards).run();
    }
}
