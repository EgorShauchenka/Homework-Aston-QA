package lesson4;

import java.util.Arrays;

public class Result {
    public static void main(String[] args) {
        printThreeWords();
        chekSumSign();
        printColor();
        compareNumbers();
        System.out.println(checkSum(5, 8));
        checkNumberIsPositiveOrNegative(17);
        System.out.println(checkPositiveOrNegative(-109));
        printRepeatString("QA", 3);
        System.out.println(checkLeapYear(2024));
        swapZeroToOne();
        fillTo100();
        numbersLessThan6MultipliedBy2();
        diagonally();
        int[] result = arrays(3, 67);
        System.out.println(Arrays.toString(result));
    }

    private static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    private static void chekSumSign() {
        int a = 5;
        int b = 10;
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    private static void printColor() {
        int value = 115;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    private static void compareNumbers() {
        int a = 21;
        int b = 20;

        if (a >= b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }
    }

    private static boolean checkSum(int a, int b) {
        int check = a + b;
        return check >= 10 && check <= 20;
    }

    private static void checkNumberIsPositiveOrNegative(int number) {
        if (number >= 0) {
            System.out.println("Число " + number + " положительное");
        } else {
            System.out.println("Число " + number + " отрицательное");
        }
    }

    private static boolean checkPositiveOrNegative(int number) {
        if (number > 0) {
            return false;
        } else {
            return true;
        }
    }

    private static void printRepeatString(String word, int number) {
        for (int i = 0; i < number; i++) {
            System.out.println(word);
        }
    }

    private static boolean checkLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        } else
            return false;
    }

    private static void swapZeroToOne() {
        int[] numbers = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                numbers[i] = 1;
            } else if (numbers[i] == 1) {
                numbers[i] = 0;
            }
        }
        System.out.println(Arrays.toString(numbers));
    }

    private static void fillTo100() {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void numbersLessThan6MultipliedBy2() {
        int[] arrays = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] < 6) {
                arrays[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arrays));
    }

    private static void diagonally() {
        int[][] square = new int[5][5];

        for (int i = 0; i < 5; i++) {
            square[i][i] = 1;
        }
        for (int i = 0; i < 5; i++) {
            square[i][5 - 1 - i] = 1;
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(square[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[] arrays(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }
}










