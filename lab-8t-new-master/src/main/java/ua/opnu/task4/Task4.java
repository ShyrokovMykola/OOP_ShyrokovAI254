package ua.opnu.task4;

import java.util.Arrays;

/**
 * Демонстрація завдання 4: {@link ArrayFilter#filter}.
 */
public class Task4 {

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 6};
        Integer[] even = ArrayFilter.filter(numbers, n -> n % 2 == 0);
        System.out.println("Парні числа: " + Arrays.toString(even)); // [2, 4, 6]

        String[] words = {"Java", "generic", "class", "method"};
        String[] longWords = ArrayFilter.filter(words, w -> w.length() > 5);
        System.out.println("Довгі слова: " + Arrays.toString(longWords)); // [generic, method]

        Integer[] none = ArrayFilter.filter(numbers, n -> n > 100);
        System.out.println("Числа більше 100: " + Arrays.toString(none)); // []
    }
}
