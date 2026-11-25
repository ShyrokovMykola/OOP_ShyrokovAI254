package ua.opnu.task5;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

/**
 * Демонстрація завдання 5: {@link ArraySearch#contains}.
 */
public class Task5 {

    public static void main(String[] args) {
        String[] words = {"Hello", "World"};
        System.out.println("World: " + ArraySearch.contains(words, "World")); // true
        System.out.println("Java: " + ArraySearch.contains(words, "Java")); // false

        Integer[] numbers = {1000, 2000, 3000};
        System.out.println("2000: " + ArraySearch.contains(numbers, 2000)); // true
        System.out.println("5: " + ArraySearch.contains(numbers, 5)); // false

        // T - ChronoLocalDate, V - його підтип LocalDate
        ChronoLocalDate[] dates = {LocalDate.of(2025, 1, 1), LocalDate.of(2025, 9, 1)};
        LocalDate date = LocalDate.of(2025, 9, 1);
        System.out.println(date + ": " + ArraySearch.contains(dates, date)); // true

        // Не компілюється, бо String не є підтипом Integer:
        // ArraySearch.contains(numbers, "Hello");
    }
}
