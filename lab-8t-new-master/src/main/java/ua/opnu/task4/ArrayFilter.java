package ua.opnu.task4;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Завдання 4. Узагальнена фільтрація масиву.
 */
public final class ArrayFilter {

    private ArrayFilter() {
    }

    /**
     * Відбирає елементи масиву, що задовольняють предикат.
     *
     * @param input вхідний масив
     * @param p     предикат
     * @param <T>   тип елементів масиву
     * @return новий масив з відібраними елементами
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] filter(T[] input, Predicate<T> p) {
        T[] result = (T[]) new Object[input.length];

        int counter = 0;
        for (T item : input) {
            if (p.test(item)) {
                result[counter] = item;
                counter++;
            }
        }

        // result насправді має тип Object[], тому копіюємо його в масив того ж типу, що й input.
        // Інакше Integer[] r = filter(...) завершиться з ClassCastException.
        return Arrays.copyOfRange(result, 0, counter, (Class<? extends T[]>) input.getClass());
    }
}
