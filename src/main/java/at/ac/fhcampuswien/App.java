package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void oneMonthCalendar(int dayQuantaty, int startDay) {

        for (int i = -startDay +2; i <= dayQuantaty;) {
            //Create the lines
            for (int k = 0; k < 7 && i <= dayQuantaty; k++ ,i++) {

                //Create entry
                if (i > 0) {
                    if (i >= 10) {
                        System.out.print(i);
                    }
                    else {
                        System.out.print(" " +i);
                    }
                }
                else {
                    System.out.print("  ");
                }

                //Space between entry
                System.out.print(" ");
            }

            System.out.println();
        }
    }
    public static long[] lcg(long seed) {
        int NUMBER = 10;
        long A = 1103515245;
        long C = 12345;
        long M = 2147483648L;
        long[] list = new long[NUMBER];

        list[0] = seed;
        for (int i = 1; i < NUMBER; i++) {
            list[i] = (A* (list[i -1]) + C) % M;
        }

        return list;
    }

    public static void guessingGame(int numberToGuess) {
        Scanner scanner = new Scanner(System.in);
        int input;

        for (int i = 1;; i++) {
            System.out.print("Guess number " + (i) + ": ");

            input = scanner.nextInt();

            if (input == numberToGuess) {
                System.out.println("You won wisenheimer!");
                return;
            }
            if (i >= 10) {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                return;
            }

            if (input < numberToGuess) {
                System.out.println("The number AI picked is higher than your guess.");
            }
            else {
                System.out.println("The number AI picked is lower than your guess.");
            }
        }
    }

    public static int  randomNumberBetweenOneAndHundred() {
        Random ran = new Random();
        return ran.nextInt(100) +1;
    }

    public static boolean swapArrays(int[] list1, int[] list2) {
        int helper;

        if (list1.length != list2.length) return false;

        for (int i = 0; i < list1.length; i++) {
            helper = list1[i];
            list1[i] = list2[i];
            list2[i] = helper;
        }
        return true;
    }



    public static String camelCase(String sentenz) {
        char[] list = sentenz.toCharArray();
        boolean spaceBefore = true;
        StringBuilder newString = new StringBuilder();

        for (int i = 0; i < list.length; i++) {

            if (list[i] >= 65 && list[i] <= 90) {
                if (!spaceBefore) {
                    newString.append((char)(list[i]  + 32));
                }
                else {
                    spaceBefore = false;
                    newString.append(list[i]);
                }
            }
            else if (list[i] >= 97 && list[i] <= 122) {
                if (spaceBefore) {
                    newString.append((char)(list[i] - 32));
                    spaceBefore = false;
                }
                else {
                    newString.append(list[i]);
                }
            }
            else if (list[i] == 32) {
                spaceBefore = true;
            }
        }
        return newString.toString();
    }

    public static int checkDigit(int[] numbers) {
        int sum = 0;
        int result;

        for (int i = 0;i < numbers.length;i++) {
            sum += numbers[i]*(i+2);
        }

        result = 11 - sum % 11;

        if (result == 11) return 5;
        if (result == 10) return 0;
        return result;
    }


    public static void main(String[] args) {
        App exercise3 = new App();

        oneMonthCalendar(30, 3);

        lcg(1);

        guessingGame(randomNumberBetweenOneAndHundred());

        swapArrays(new int[]{3, 9, 1, 5, 8}, new int[]{3, 9, 1, 5, 8});

        camelCase("Hallo23 jklsdf alskdfjJLKJ");

        checkDigit(new int[]{0, 0, 4, 4, 4, 8, 2, 9, 3});

    }
}