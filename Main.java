package banking;

import java.util.Scanner;
import java.util.Random;

public class Main {

    protected static void createAcc() {
        Random random = new Random();
        long max = 9999999999L;
        long min = 0_000_000_000L;
        int maxPin = 9999;
        int minPin = 0_000;
        long randomAccNum = random.nextInt((int) (max - min)) + min;
        int Pin = random.nextInt((maxPin - minPin)) + minPin;
        String wholeAccNum = "400000" + randomAccNum;
        System.out.println("Your card has been created");
        System.out.println("Your card number:");
        System.out.println("400000" + randomAccNum);
        System.out.println("Your card PIN:");
        System.out.println(Pin);
    }

    protected static void logAcc(String wholeAccNum, int Pin) {
        Scanner scanner = new Scanner(System.in);
        boolean isTrue = false;
        while (!isTrue) {
            System.out.println("Enter your card number:");
            String logAcc = scanner.nextLine();
            if (wholeAccNum.equals(logAcc)) {
                System.out.println("Enter your PIN:");
                int logPin = scanner.nextInt();
                if (logPin == Pin) {
                    System.out.println("You have successfully logged in!");
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
                break;
            case 0:
                System.out.println("Bye!");
                break;
            default:
                break;
        }

    }

    protected static void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit");
        int menuSwitch = scanner.nextInt();
        switch (menuSwitch) {
            case 1:
                createAcc();
                break;
            case 2:
                logAcc(wholeAccNum,Pin);
                break;
            case 0:
                System.out.println("Bye!");
                System.exit(0);
                break;
            default:
                System.out.println("Bad input");
                break;
        }
    }





    public static void main(String[] args) {
        menu();
    }
}