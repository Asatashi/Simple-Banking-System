package banking;

import java.util.Random;
import java.util.Scanner;
import java.sql.*;

public class Main {

    static boolean checkLuhn(String cardNo)
    {
        int nDigits = cardNo.length();

        int nSum = 0;
        boolean isSecond = false;
        for (int i = nDigits - 1; i >= 0; i--)
        {

            int d = cardNo.charAt(i) - '0';

            if (isSecond)
                d = d * 2;

            nSum += d / 10;
            nSum += d % 10;

            isSecond = !isSecond;
        }
        return (nSum % 10 == 0);
    }

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
    protected static void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean isTrue = false;
        long wholeAccNum = 0L;
        int Pin = 0;
        while (!isTrue) {
            System.out.println("1. Create an account");
            System.out.println("2. Log into account");
            System.out.println("0. Exit");
            int menuSwitch = scanner.nextInt();
            switch (menuSwitch) {
                case 1:
                    Random random = new Random();
                    long max = 9_999_999_999L;
                    long min = 1_000_000_000L;
                    int maxPin = 9999;
                    int minPin = 1_000;
                    boolean isLuhn = false;
                    while (!isLuhn) {
                        long randomAccNum = random.nextInt((int) (max - min)) + min;
                        Pin = random.nextInt((maxPin - minPin)) + minPin;
                        wholeAccNum = 4_000_000_000_000_000L + randomAccNum;
                        String cardNo = Long.toString(wholeAccNum);
                        if (checkLuhn(cardNo)) {
                            isLuhn = true;
                            createAcc(wholeAccNum, Pin);
                        }
                    }
                    break;
                case 2:
                    if (wholeAccNum == 0 && Pin == 0) {
                        System.out.println("Create an account before logging in");
                    } else {
                        logAcc(wholeAccNum, Pin);
                    }
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
        InsertApp app = new InsertApp();
        menu();
    }
}//C:\Users\Bobek\sqlite\db\DataBase.db