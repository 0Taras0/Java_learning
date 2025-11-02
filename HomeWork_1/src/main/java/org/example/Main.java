package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfQuestions = 10;
        int correctAnswers = 0;

        System.out.println("--- Перевірка знань таблиці множення ---");

        for (int i = 1; i <= numberOfQuestions; i++) {
            int a = GetRandom(1, 10);
            int b = GetRandom(1, 10);
            int correct = a * b;

            System.out.printf("Приклад %d: %d * %d = ", i, a, b);
            int answer = scanner.nextInt();

            if (answer == correct) {
                System.out.println("Правильно!\n");
                correctAnswers++;
            } else {
                System.out.printf("Неправильно. Правильна відповідь: %d\n\n", correct);
            }
        }

        System.out.printf("Ваш результат: %d з %d правильних відповідей.\n", correctAnswers, numberOfQuestions);

        double percent = ((double) correctAnswers / numberOfQuestions) * 100;
        System.out.printf("Оцінка: %.1f%%\n", percent);

        if (percent == 100) {
            System.out.println("Відмінно! Ну ти професор!");
        } else if (percent >= 70) {
            System.out.println("ОК");
        } else {
            System.out.println("Йди назад в школу)");
        }

        scanner.close();
    }

    public static int GetRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}