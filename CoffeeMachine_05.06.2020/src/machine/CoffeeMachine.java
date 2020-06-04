package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static int waterMl = 400;
    private static int moneyInDollars = 550;
    private static int milkMl = 540;
    private static int coffeeBeans = 120;
    private static int countCups = 9;

    public static void main(String[] args) {
        startCoffeeMachine();
    }

    public static void startCoffeeMachine() {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();

            switch (action) {
                case "buy":
                    buyCoffee();
                    break;
                case "fill":
                    fillMachine();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    getActualCountIngredients();
                    break;
                case "exit":
                    isExit = true;
                    break;
                default:
                    System.out.println("Unknown operation. Try again");
                    break;
            }
        }
        scanner.close();
    }

    public static void getActualCountIngredients() {
        System.out.println("The coffee machine has:");
        System.out.println(waterMl + " of water");
        System.out.println(milkMl + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(countCups + " of disposable cups");
        System.out.println(moneyInDollars + " of money");
        System.out.println();
    }

    public static void buyCoffee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String coffeeName = scanner.next();
        switch (coffeeName) {
            case "1":
                if (waterMl >= 150 && coffeeBeans >= 16 && countCups >= 1) {
                    waterMl -= 250;
                    coffeeBeans -= 16;
                    moneyInDollars += 4;
                    countCups--;
                    System.out.println("I have enough resources, making you a coffee!");
                } else {
                    checkResources(150, 0, 16, 1);
                    System.out.println();
                }
                break;
            case "2":
                if (waterMl >= 350 && milkMl >= 75 && coffeeBeans >= 20 && countCups >= 1) {
                    waterMl -= 350;
                    milkMl -= 75;
                    coffeeBeans -= 20;
                    moneyInDollars += 7;
                    countCups--;
                    System.out.println("I have enough resources, making you a coffee!");
                    System.out.println();
                } else {
                    checkResources(350, 75, 20, 1);
                }
                break;
            case "3":
                if (waterMl >= 200 && milkMl >= 100 && coffeeBeans >= 12 && countCups >= 1) {
                    waterMl -= 200;
                    milkMl -= 100;
                    coffeeBeans -= 12;
                    moneyInDollars += 6;
                    countCups--;
                    System.out.println("I have enough resources, making you a coffee!");
                    System.out.println();
                } else {
                    checkResources(200, 100, 12, 1);
                }
                break;
            case "back":
                break;
            default:
                System.out.println("Unknown variant. Try again");
                break;
        }
    }

    public static void fillMachine() {
        Scanner scanner = new Scanner(System.in);
        int add;
        System.out.println("Write how many ml of water do you want to add:");
        add = scanner.nextInt();
        waterMl += add;
        System.out.println("Write how many ml of milk do you want to add:");
        add = scanner.nextInt();
        milkMl += add;
        System.out.println("Write how many grams of coffee beans do you want to add:");
        add = scanner.nextInt();
        coffeeBeans += add;
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        add = scanner.nextInt();
        countCups += add;
    }

    public static void takeMoney() {
        System.out.println("I gave you $" + moneyInDollars);
        System.out.println();
        moneyInDollars = 0;
    }

    public static void checkResources(int water, int milk, int coffee, int cups) {
        if (waterMl - water < 0) {
            System.out.println("Sorry, not enough water!");
            System.out.println();
        }
        if (milkMl - milk < 0) {
            System.out.println("Sorry, not enough milk!");
            System.out.println();
        }
        if (coffeeBeans - coffee < 0) {
            System.out.println("Sorry, not enough coffee beans!");
            System.out.println();
        }
        if (countCups - cups < 0) {
            System.out.println("Sorry, not enough disposable cups!");
            System.out.println();
        }
    }
}