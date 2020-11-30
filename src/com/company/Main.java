package com.company;

public class Main {

    public static void main(String[] args) {
        exercise1(10);
        exercise2(10);
        exercise3(10, 20);
        exercise3(20, 10);
        exercise4(10, 3);//30,12,21
        exercise5(109);//1+9=10
        exercise6(12);//непростое NO
        exercise6(19);//простое YES
        exercise8("poop");//YES
        exercise8("poos");//NO
        exercise8("pop");//YES
        exercise8("mag");//NO
        exercise9(3, 3);
        exercise10(123);
    }

    static void exercise1(int n) {
        System.out.println("Exercise1:" + n);
        exercise1realize(n, 1);
    }

    static int exercise1realize(int n, int fact) {
        if (n != 1) {
            fact = exercise1realize(n - 1, 0);
        }
        for (int i = 1; i < fact + 1; i++) {
            System.out.print(fact + " ");
        }
        return n;
    }

    static void exercise2(int n) {
        System.out.println("\n\nExercise2:" + n);
        for (int i = 0; i < n; i++) {
            System.out.print(i + 1 + " ");

        }
    }

    static void exercise3(int n1, int n2) {
        System.out.println("\nExercise3:" + n1 + " " + n2);
        if (n1 <= n2) {
            for (int i = n1; i <= n2; i++) {
                System.out.print(i + " ");

            }
        } else {
            for (int i = n1; i >= n2; i--) {
                System.out.print(i + " ");
            }

        }

    }

    static void exercise4(int k, int d) {
        System.out.println("\nExercise4:" + k + " " + d);
        int length = (int) (Math.log10(k) + 1);

        int answer = 0;
        int sumNumber = 0;
        int downNumber = (int) Math.pow(10, length - 1);
        int upNumber = (int) Math.pow(10, length);
        System.out.println(downNumber + " " + upNumber);
        for (int i = downNumber; i < upNumber; i++, sumNumber = 0) {
            for (int j = i; j > 0; j /= 10)
                sumNumber += j % 10;
            if (sumNumber == d) answer++;
        }
        System.out.println(answer);
    }

    static void exercise5(int n) {
        System.out.println("\nExercise5:" + n);
        System.out.println(exercise5_realize(n, 0));
    }

    static int exercise5_realize(int n, int sum) {
        if (n == 0) return sum;//условие выхода
        sum += n % 10;
        sum = exercise5_realize(n / 10, sum);
        return sum;
    }


    static void exercise6(int n) {
        System.out.println("\nExercise6:" + n);
        System.out.println(exercise6_realize(n, n - 1));
    }

    private static String exercise6_realize(int n, int del) {
        if (n % del == 0 && del > 1) return "NO";//10%9
        if (del == 1) return "YES";
        return exercise6_realize(n, del - 1);//10%9
    }

    static void exercise8(String palindrom) {
        System.out.println("\nExercise8:" + palindrom);
        String palindromBegin;
        String palindromEnd;

        if (palindrom.length() % 2 == 0) {
            palindromBegin = palindrom.substring(0, palindrom.length() / 2);
            palindromEnd = palindrom.substring(palindrom.length() / 2, palindrom.length());
            palindromEnd = new StringBuffer(palindromEnd).reverse().toString();

            if (palindromBegin.equals(palindromEnd)) System.out.println("YES");
            else System.out.println("NO");
        } else {
            palindromBegin = palindrom.substring(0, palindrom.length() / 2);
            palindromEnd = palindrom.substring(palindrom.length() / 2 + 1, palindrom.length());
            palindromEnd = new StringBuffer(palindromEnd).reverse().toString();
            if (palindromBegin.equals(palindromEnd)) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    static void exercise9(int a, int b) {
        System.out.println("\nExercise9:" + a + " " + b);
        System.out.println(exercise9realize(a, b));
    }

    static int exercise9realize(int a, int b) {
        if (a - 1 > b) return 0;
        if (a == 0 || b == 0) return 1;
        return exercise9realize(a, b - 1) + exercise9realize(a - 1, b - 1);

    }

    static void exercise10(int a) {
        System.out.println("\nExercise9:" + a);
        System.out.println(exercise10realize(a, 0));
    }

    private static int exercise10realize(int n, int a) {
        if (n == 0) {
            return a;
        } else {
            return exercise10realize(n / 10, 10 * a + n % 10);//прошлый результат + нынешний остаток
        }
    }

}
