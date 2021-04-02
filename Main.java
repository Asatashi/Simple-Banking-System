package banking;

import java.util.Scanner;
import java.util.Random;

public class Main {

    protected static void createAcc(long wholeAccNum,int Pin) {
        System.out.println("Your card has been created");
        System.out.println("Your card number:");
        System.out.println(wholeAccNum);
        System.out.println("Your card PIN:");
        System.out.println(Pin);
    }

    protected static void logAcc(long wholeAccNum, int Pin) {
        Scanner scanner = new Scanner(System.in);
        boolean isTrue = false;
        while (!isTrue) {
            System.out.println("Enter your card number:");
            long logAcc = scanner.nextLong();
            if (logAcc == wholeAccNum) {
                System.out.println("Enter your PIN:");
                int logPin = scanner.nextInt();
                if (logPin == Pin) {
                    System.out.println("You have successfully logged in!");
                    account();
                    isTrue = true;
                } else {
                    System.out.println("Wrong card number or PIN!");
                }
            } else {
                System.out.println("Wrong card number or PIN!");
            }
        }
    }

    protected static void account() {
        Scanner scanner = new Scanner(System.in);
        boolean isTrue = false;
        while (!isTrue) {
            System.out.println("1. Balance");
            System.out.println("2. Log out");
            System.out.println("0. Exit");
            int menuSwitch = scanner.nextInt();
            switch (menuSwitch) {
                case 1:
                    System.out.println("Balance: 0");
                    break;
                case 2:
                    System.out.println("You have successfully logged out!");
                    isTrue = true;
                    break;
                case 0:
                    System.out.println("Bye!");
                    isTrue = true;
                    break;
                default:
                    break;
            }
        }
    }

    protected static void menu(long randomAccNum,int Pin,long wholeAccNum) {
        Scanner scanner = new Scanner(System.in);
        boolean isTrue = false;
        while (!isTrue) {
            System.out.println("1. Create an account");
            System.out.println("2. Log into account");
            System.out.println("0. Exit");
            int menuSwitch = scanner.nextInt();
            switch (menuSwitch) {
                case 1:
                    createAcc(wholeAccNum, Pin);
                    break;
                case 2:
                    logAcc(wholeAccNum, Pin);
                    break;
                case 0:
                    System.out.println("Bye!");
                    isTrue = true;
                    break;
                default:
                    System.out.println("Bad input");
                    break;
            }
        }
    }





    public static void main(String[] args) {
        Random random = new Random();       //TODO make program output not identical numbers and pin for card
        long max = 9999999999L;
        long min = 0_000_000_000L;
        int maxPin = 9999;
        int minPin = 0_000;
        long randomAccNum = random.nextInt((int) (max - min)) + min;
        int Pin = random.nextInt((maxPin - minPin)) + minPin;
        long wholeAccNum = 4000000000000000L + randomAccNum;
        menu(randomAccNum,Pin,wholeAccNum);
    }
}