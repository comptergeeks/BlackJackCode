import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;


public class BlackJack {
    static int[] myArray = new int[12];
    static int[] playerCards = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 11 };
    static String[] playerCardsName = { "1","2","3","4","5", "6", "7", "8", "9", "Jack", "Queen", "King", "Ace"};
    static String[] suitsArr = {"Spades", "Clubs", "Hearts", "Diamonds"};
    static int playerCount = 0;
    static int cpuCount = 0;
    static boolean playerHit = false; 
    static boolean cpuHit = false; 
    static boolean playerPass = false; 
    static boolean cpuPass = false; 
    static String dealerName = "The Dealer"; 
    static boolean cpuTurn = false; 

    public static String randomCardsCPU() {
        Random r = new Random();
        int indexToPull1 = r.nextInt(playerCards.length);
        int suitToPull = r.nextInt(suitsArr.length);
        cpuCount += playerCards[indexToPull1]; 
        return " drew a " + playerCardsName[indexToPull1] + " of " + suitsArr[suitToPull]; 
    }


    public static String randomCardsPlayer() {
        Random r = new Random();
        int indexToPull1 = r.nextInt(playerCards.length);
        int suitToPull = r.nextInt(suitsArr.length);
        playerCount += playerCards[indexToPull1]; 
        return " drew a " + playerCardsName[indexToPull1] + " of " + suitsArr[suitToPull]; 
    }

    public static void main (String[] args ) {
        boolean gameRunning = true;
        Scanner userInput = new Scanner (System.in);
        System.out.println("Welcome to Black Jack, type q to quit at any time. Type c to continue");
        while (gameRunning) {

            String input = userInput.nextLine();

            if(input.equalsIgnoreCase("q")) {
                System.out.println("See you next time!");
                gameRunning = false; 
                break; 
            } 
            if(input.equalsIgnoreCase("c")) {
                System.out.println("Input player name");
                String name = userInput.nextLine();
                System.out.println("Hello" + " " + name + ",");
                System.out.println(name + randomCardsPlayer() + " and" + randomCardsPlayer());
                System.out.println(name + "'s" + " sum is " + playerCount);
                System.out.println("Would you like to hit or stand? (h/p)" );
                String hitOrPass = userInput.nextLine(); 
                if (hitOrPass.equalsIgnoreCase("h")) {
                    playerHit = true;
                    System.out.println(name + randomCardsPlayer());
                    System.out.println(name + "'s" + " sum is " + playerCount);
                    while (gameRunning) {
                        if (playerCount > 21) {
                            System.out.println("You busted. Good luck Next time!");
                            gameRunning = false; 
                            break; 
                        }
                    
                        System.out.println("Would you like to hit or stand? (h/p)" );
                        hitOrPass = userInput.nextLine(); 
                        if (hitOrPass.equalsIgnoreCase("h")) {
                            System.out.println(name + randomCardsPlayer());
                            System.out.println(name + "'s" + " sum is " + playerCount);
                        } else if (hitOrPass.equalsIgnoreCase("p")) {
                            playerHit = false; 
                            playerPass = true; 
                            System.out.println("Dealers Turn");
                            System.out.println(dealerName + randomCardsCPU() + " and" + randomCardsCPU());
                            System.out.println(dealerName + "'s" + " sum is: " + cpuCount); 
                            cpuTurn = true; 
                            while (cpuTurn) {
                                if (cpuCount > 21) {
                                    System.out.println("The Dealer busted. " + name + " won!");
                                    gameRunning = false; 
                                    break; 
                                }
                            if (cpuCount < 16) {
                                cpuHit = true; 
                                System.out.println(dealerName + randomCardsCPU());
                                System.out.println(dealerName + "'s" + " sum is " + cpuCount);
                            } else if (cpuCount > 16)  {
                                cpuHit = false;
                                cpuPass = true;
                                if (cpuPass && playerPass) {
                                    if (cpuCount > playerCount) {
                                        System.out.println("The Dealer won!");
                                        cpuTurn = false; 
                                        gameRunning = false; 
                                        break; 
                                    }
                                     else if (playerCount > cpuCount) {
                                        System.out.println( name + " won!");
                                        cpuTurn = false; 
                                        gameRunning = false; 
                                        break; 
                                    }
                                    else if (playerCount == cpuCount) {
                                        System.out.println( "The Dealer and " + name + " tied! Good luck next time");
                                        cpuTurn = false; 
                                        gameRunning = false; 
                                        break; 
                                    }
                                    cpuTurn = false; 
                                    break; 
                                    }
                            }
                                }
                            }
                             
                        }
                            
                        }
                        else if (hitOrPass.equalsIgnoreCase("p")) {
                            playerHit = false; 
                            playerPass = true; 
                            System.out.println("Dealers Turn");
                            System.out.println(dealerName + randomCardsCPU() + " and" + randomCardsCPU());
                            System.out.println(dealerName + "'s" + " sum is: " + cpuCount); 
                            cpuTurn = true; 
                            while (cpuTurn) {
                                if (cpuCount > 21) {
                                    System.out.println("The Dealer busted. " + name + " won!");
                                    gameRunning = false; 
                                    break; 
                                }
                            if (cpuCount < 16) {
                                cpuHit = true; 
                                System.out.println(dealerName + randomCardsCPU());
                                System.out.println(dealerName + "'s" + " sum is " + cpuCount);
                            } else if (cpuCount > 16)  {
                                cpuHit = false;
                                cpuPass = true;
                                if (cpuPass && playerPass) {
                                    if (cpuCount > playerCount) {
                                        System.out.println("The dealer won!");
                                        cpuTurn = false; 
                                        gameRunning = false; 
                                        break; 
                                    }
                                     else if (playerCount > cpuCount) {
                                        System.out.println( name + " won!");
                                        cpuTurn = false; 
                                        gameRunning = false; 
                                        break; 
                                    }
                                    else if (playerCount == cpuCount) {
                                        System.out.println( "The Dealer and " + name + " tied! Good luck next time");
                                        cpuTurn = false; 
                                        gameRunning = false; 
                                        break; 
                                    }
                                    cpuTurn = false; 
                                    gameRunning = false; 
                                    break;
                                    }
                        
                        }
                    
                    }
                }
    }
}

    }
    }