package ua.opnu;

import ua.opnu.task1.Task1;
import ua.opnu.task2.Task2;
import ua.opnu.task3.Task3;
import ua.opnu.task4.Task4;
import ua.opnu.task5.Task5;
import ua.opnu.task6.Task6;

/**
 * Запускає демонстрації всіх завдань лабораторної роботи.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Завдання 1 ===");
        Task1.main(args);

        System.out.println("\n=== Завдання 2 ===");
        Task2.main(args);

        System.out.println("\n=== Завдання 3 ===");
        Task3.main(args);

        System.out.println("\n=== Завдання 4 ===");
        Task4.main(args);

        System.out.println("\n=== Завдання 5 ===");
        Task5.main(args);

        System.out.println("\n=== Завдання 6 ===");
        Task6.main(args);
    }
}
