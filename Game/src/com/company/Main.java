package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList deckMaker(ArrayList<Integer> cardList) {

        ArrayList<Integer> properValueDeck = new ArrayList<Integer>();

        for (int i = 1; i <= 13; i++) {
            cardList.add(i);
            cardList.add(i);
            cardList.add(i);
            cardList.add(i);
        }

        java.util.Collections.shuffle(cardList);

        for (int i = 0; i <= 51; i++) {

            if (cardList.get(i) > 10) {

                cardList.add(52 + (i), 10);

            }else if(cardList.get(i) < 11) {

                cardList.add(52 + i, cardList.get(i));
            }
        }

        return cardList;
    }

    static ArrayList cardListNameConvert(ArrayList<Integer> currentList){

        ArrayList<String> convertedList = new ArrayList<String>(), cardNameList = new ArrayList<String>(),
                cardSpecificName = new ArrayList<String>();

        int currentNumber = 0;
        String currentString = "";

        cardNameList.add(0, "PH");
        cardNameList.add(1, "Ace of");
        cardNameList.add(2, "Two of");
        cardNameList.add(3, "Three of");
        cardNameList.add(4, "Four of");
        cardNameList.add(5, "Five of");
        cardNameList.add(6, "Six of");
        cardNameList.add(7, "Seven of");
        cardNameList.add(8, "Eight of");
        cardNameList.add(9, "Nine of");
        cardNameList.add(10, "Ten of");
        cardNameList.add(11, "Queen of");
        cardNameList.add(12, "King of");
        cardNameList.add(13, "Jack of");

        cardSpecificName.add(0, " Club");
        cardSpecificName.add(1, " Spades");
        cardSpecificName.add(2, " Diamonds");
        cardSpecificName.add(3, " Hearts");

        for (int i = 0; i <= 51; i++){
            cardSpecificName.add(cardSpecificName.get(i));
        }

        java.util.Collections.shuffle(cardSpecificName);

        for (int i = 0; i <= 51; i++) {
            currentNumber = currentList.get(i);
            currentString = cardNameList.get(currentNumber);
            currentString = currentString + cardSpecificName.get(currentNumber);
            convertedList.add(currentString);
        }

        return convertedList;

    }

    static ArrayList betPlacer(double betAmount, double balance) throws InterruptedException {

        ArrayList<Double> betBalanceReturned = new ArrayList<Double>();

        int balanceWrongVar = 1;
        Scanner input = new Scanner(System.in);
        String betConfirmation = "";

        System.out.println("\n====================");
        System.out.println("$$$ Time to bet! $$$");
        System.out.println("====================");

        System.out.println("\nYour current balance is: $" + balance);

        System.out.print("\nEnter how much would you like to bet: ");
        betAmount = input.nextInt();

        System.out.print("\nDid you want to bet: $" + betAmount + "? ");
        betConfirmation = input.next();

        if(betAmount > balance || betConfirmation.equalsIgnoreCase("N")){

            while (balanceWrongVar != 0) {

                if (betAmount >= balance && balance == 0){

                    System.out.println("\nInsufficient Funds");
                    System.out.println("Adding $50 to your balance now...");

                    balance += 50;
                    Thread.sleep(1000);

                    System.out.print("\nEnter how much would you like to bet: ");
                    betAmount = input.nextInt();

                    System.out.print("\nDid you want to bet: $" + betAmount + "? ");
                    betConfirmation = input.next();

                    continue;

                }else if(betAmount > balance){

                    System.out.println("\nBet Amount too high! Choose another amount to bet!");

                    System.out.print("\nEnter how much would you like to bet: ");
                    betAmount = input.nextInt();

                    System.out.print("\nDid you want to bet: $" + betAmount + "? ");
                    betConfirmation = input.next();

                    continue;

                }else if(betAmount <= balance && betConfirmation.equalsIgnoreCase("N")) {

                    System.out.print("\nEnter how much would you like to bet: ");
                    betAmount = input.nextInt();

                    System.out.print("\nDid you want to bet: $" + betAmount + "? ");
                    betConfirmation = input.next();

                    continue;

                }else if(betAmount <= balance && betConfirmation.equalsIgnoreCase("Y")) {
                    break;

                }
            }
        }





        balance -= betAmount;
        System.out.println("Your balance is now: $" + balance);
        Thread.sleep(1000);
        System.out.println("We are placing your bet...");
        Thread.sleep(2500);

        System.out.println("\n=================");
        System.out.println("Betting Complete!");
        System.out.println("=================");

        betBalanceReturned.add(betAmount);
        betBalanceReturned.add(balance);
        return betBalanceReturned;
    }

    static void dealerWait() throws InterruptedException {

        int totalSleepTime = 3200;
        int sleepTime = totalSleepTime / 7;

        System.out.println("");

        for (int i = 1; i <= 3; i++) {
            for(int j = 1; j <= i; j++){
                System.out.print('.');
                Thread.sleep(sleepTime);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Scanner input = new Scanner(System.in);

        ArrayList<Integer> cardList = new ArrayList<Integer>(), playerDeck = new ArrayList<Integer>(), playerDeckValue = new ArrayList<Integer>(), computerDeckValue = new ArrayList<Integer>(), computerDeck = new ArrayList<Integer>();
        ArrayList<String> cardListNames = new ArrayList<String>(), playerDeckCardNames = new ArrayList<String>(), computerDeckCardNames = new ArrayList<String>();
        ArrayList<Double> betBalanceReturned = new ArrayList<Double>();

        int playerTotal, computerTotal, computerKnownTotal = 0;

        double betAmount, balance = 500, startingBalance = 0;

        String playerChoice = "", blackJackWinner = "", replayChoice = "", menuTab = "";

        boolean blackJackCheck = false;

        while (blackJackCheck != true) {

            while (menuTab.equalsIgnoreCase("a") == false){

                System.out.println("\n~Main Menu~");
                System.out.println("\n(a) Play: ");
                System.out.println("(b) Options: ");
                System.out.print(">");
                menuTab = input.next();

                switch(menuTab){
                    case "b":
                        System.out.println("\n~Options Menu~");
                        System.out.println("\n(ba)Card Decks: ");
                        System.out.println("(bb)Blackjack Target: ");
                        System.out.println("(bc)Starting Balance: ");
                        System.out.println("(bd) to return to main menu");
                        System.out.print("> ");
                        menuTab = input.next();
                        continue;

                        case "bc":

                    case "bd":
                        continue;
                }
            }





            cardList.clear();
            cardListNames.clear();

            playerDeck.clear();
            playerDeckValue.clear();
            playerDeckCardNames.clear();

            computerDeck.clear();
            computerDeckValue.clear();
            computerDeckCardNames.clear();

            betAmount = 0;
            playerTotal = 0;
            computerTotal = 0;

            cardList = deckMaker(cardList);

            cardListNames = cardListNameConvert(cardList);

            for (int i = 0, j = 52, k = 0; k < 2; k++){

                computerDeck.add(cardList.get(i));
                computerDeckValue.add(cardList.get(j));
                computerDeckCardNames.add(cardListNames.get(i));

                cardList.remove(i);
                cardList.add(51, 404);
                cardList.remove(j);
                cardListNames.remove(i);

                playerDeck.add(cardList.get(i));
                playerDeckValue.add(cardList.get(j));
                playerDeckCardNames.add(cardListNames.get(i));

                cardList.remove(i);
                cardList.add(51, 404);
                cardList.remove(j);
                cardListNames.remove(i);

            }


            //System.out.println(cardList);
            //System.out.println(cardListNames);

            //System.out.println(computerDeck);
            //System.out.println(computerDeckValue);
            //System.out.println(computerDeckCardNames);

            //System.out.println(playerDeck);
            //System.out.println(playerDeckValue);
            //System.out.println(playerDeckCardNames);

            System.out.println("\nLet's Play Black Jack!");

            betBalanceReturned = betPlacer(betAmount, balance);

            betAmount = betBalanceReturned.get(0);
            balance = betBalanceReturned.get(1);

            for (int i = 0; i < playerDeckValue.size(); i += 1) {

                playerTotal += playerDeckValue.get(i);

            }

            for (int i = 0; i < computerDeckValue.size(); i++) {

                computerTotal += computerDeckValue.get(i);

            }

            computerKnownTotal = computerTotal - computerDeckValue.get(0);

            System.out.println("\nThe dealer's known total is: " + computerDeckValue.get(1));
            System.out.println("\nYour current cards are: " + playerDeckCardNames);
            System.out.println("Your current cards value is: " + playerDeckValue);
            System.out.println("With your cards dealt, your total is: " + playerTotal);

            System.out.print("\nWould you like to (HIT / STAND)(H / S): ");
            playerChoice = input.next();

            while (blackJackCheck != true) {

                if (playerTotal > 21) {
                    System.out.println("You have busted!");
                    blackJackWinner = "Dealer";
                    blackJackCheck = true;
                    break;
                } else if (playerTotal == 21) {
                    System.out.println("You have drawn a 21! Black Jack!");
                    blackJackWinner = "Player";
                    blackJackCheck = true;
                    break;
                }

                if (playerChoice.equalsIgnoreCase("hit") || playerChoice.equalsIgnoreCase("H")) {

                    playerDeck.add(cardList.get(0));
                    playerDeckValue.add(cardList.get(52));
                    playerDeckCardNames.add(cardListNames.get(0));

                    cardList.remove(0);
                    cardList.add(51, 404);
                    cardListNames.remove(0);

                    playerTotal += playerDeckValue.get(playerDeckValue.size() - 1);

                    if (playerTotal > 21) {
                        System.out.println("\nYou have drawn a " + playerDeckCardNames.get(playerDeckCardNames.size() - 1));
                        System.out.println("Your total is now: " + playerTotal);
                        System.out.println("Bust!");
                        blackJackWinner = "Dealer";
                        blackJackCheck = true;
                        break;
                    } else if (playerTotal == 21) {
                        System.out.println("\nYou have drawn a " + playerDeckCardNames.get(playerDeckCardNames.size() - 1));
                        System.out.println("Your total is now: " + playerTotal);
                        System.out.println("Blackjack!");
                        blackJackWinner = "Player";
                        blackJackCheck = true;
                        break;
                    } else ;
                    System.out.println("\nYour current cards are: " + playerDeckCardNames);
                    System.out.println("Your current total is: " + playerTotal);
                    System.out.print("\nWould you like to (HIT / STAND)(H / S): ");
                    playerChoice = input.next();
                    continue;

                }

                while (blackJackCheck != true) {

                    dealerWait();

                    if (playerTotal > 21) {
                        System.out.println("\nYou have busted!");
                        blackJackWinner = "Dealer";
                        blackJackCheck = true;
                        break;
                    } else if (playerTotal == 21) {
                        System.out.println("\nYou have drawn a 21! Black Jack!");
                        blackJackWinner = "Player";
                        blackJackCheck = true;
                        break;
                    }

                    if (playerChoice.equalsIgnoreCase("hit") || playerChoice.equalsIgnoreCase("H")) {

                        playerDeck.add(cardList.get(0));
                        playerDeckValue.add(cardList.get(52));
                        playerDeckCardNames.add(cardListNames.get(0));

                        cardList.remove(0);
                        cardList.add(51, 404);
                        cardListNames.remove(0);
                        playerTotal += playerDeckValue.get(playerDeckValue.size() - 1);

                        if (playerTotal > 21) {
                            System.out.println("\nYou have drawn a " + playerDeckCardNames.get(playerDeckCardNames.size() - 1));
                            System.out.println("Your total is now: " + playerTotal);
                            System.out.println("Bust!");
                            blackJackWinner = "Dealer";
                            blackJackCheck = true;
                            break;
                        } else if (playerTotal == 21) {
                            System.out.println("\nYou have drawn a " + playerDeckCardNames.get(playerDeckCardNames.size() - 1));
                            System.out.println("Your total is now: " + playerTotal);
                            System.out.println("Blackjack!");
                            blackJackWinner = "Player";
                            blackJackCheck = true;
                            break;
                        } else ;
                        System.out.print("\nYour current cards value is: " + playerDeckCardNames);
                        System.out.println("Your current total is: " + playerTotal);
                        System.out.print("\nWould you like to (HIT / STAND)(H / S): ");
                        playerChoice = input.next();
                        continue;

                    } else if (playerChoice.equalsIgnoreCase("stand") || playerChoice.equalsIgnoreCase("s")) {

                        if (computerKnownTotal >= 16 && computerKnownTotal <= 21) {
                            System.out.println("\nThe dealer stands on 16 or more");
                            System.out.println("The dealer reveals their full deck: " + computerDeckCardNames);
                            System.out.println("Their actual total is: " + computerTotal);
                            dealerWait();
                            if (computerTotal > playerTotal) {
                                dealerWait();
                                System.out.println("\nThe Dealer is closer to 21! Dealer Wins!");
                                blackJackWinner = "Dealer";
                                blackJackCheck = true;
                                break;
                            } else {
                                dealerWait();
                                System.out.println("\nThe Player is closer to 21! Player wins!");
                                blackJackWinner = "Player";
                                blackJackCheck = true;
                                break;
                            }
                        } else if (computerTotal == 21) {
                            System.out.println("\nThe dealer stands on 16 or more");
                            System.out.println("The dealer reveals their full deck: " + computerDeckCardNames);
                            System.out.println("Their actual total is: " + computerTotal);
                            dealerWait();
                            System.out.println("\nThe dealer gets a 21! The dealer has a Black Jack!");
                            blackJackWinner = "Dealer";
                            blackJackCheck = true;
                            break;
                        } else if (computerKnownTotal > 21) {
                            System.out.println("\nThe dealer stands on 16 or more");
                            System.out.println("The dealer reveals their full deck: " + computerDeckCardNames);
                            System.out.println("Their actual total is: " + computerTotal);
                            dealerWait();
                            System.out.println("The dealer is over 21! Bust!");
                            blackJackWinner = "Player";
                            blackJackCheck = true;
                            break;
                        } else {


                            computerDeck.add(cardList.get(0));
                            computerDeckValue.add(cardList.get(52));
                            computerDeckCardNames.add(cardListNames.get(0));

                            cardList.remove(0);
                            cardList.add(51, 404);
                            cardListNames.remove(0);

                            computerTotal += computerDeckValue.get(computerDeckValue.size() - 1);
                            computerKnownTotal += computerDeckValue.get(computerDeckValue.size() - 1);

                            System.out.println("\nThe dealer will draw one card");
                            System.out.println("The dealer has drawn a " + computerDeckCardNames.get(computerDeckCardNames.size() - 1));

                            System.out.print("\nThe dealers known cards are: ");

                            for (int i = 1; i < computerDeckCardNames.size(); i++){
                                System.out.print(computerDeckCardNames.get(i) + " | ");
                            }

                            System.out.println("The dealers known total is: " + computerKnownTotal);

                            dealerWait();

                            continue;
                        }
                    }
                }
            }
            System.out.println("\nThe winner is the " + blackJackWinner + "!");

            if (blackJackWinner.equalsIgnoreCase("Player")) {
                balance = balance + (betAmount * 1.5);
            }

            System.out.print("\nWould you like to play again (Y/N): ");
            replayChoice = input.next();

            if (replayChoice.equalsIgnoreCase("Y")) {
                blackJackCheck = false;
                continue;
            } else;
            break;

        }
    }
}