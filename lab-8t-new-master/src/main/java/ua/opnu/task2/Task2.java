package ua.opnu.task2;

import java.util.Arrays;

/**
 * Демонстрація завдання 2: сортування {@link BookData}.
 */
public class Task2 {

    public static void main(String[] args) {
        BookData[] books = {
            new BookData("Тигролови", "Іван Багряний", 10, 45),
            new BookData("Нова книга", "Невідомий автор", 0, 0),
            new BookData("Кобзар", "Тарас Шевченко", 20, 98),
            new BookData("Місто", "Валер'ян Підмогильний", 4, 18)
        };

        Arrays.sort(books);

        // Кобзар (4.90), Місто (4.50), Тигролови (4.50), Нова книга (0.00)
        for (BookData book : books) {
            System.out.println(book);
        }
    }
}
