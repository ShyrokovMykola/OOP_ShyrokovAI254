package ua.opnu.task5;

/**
 * Завдання 5. Узагальнений пошук елемента в масиві.
 */
public final class ArraySearch {

    private ArraySearch() {
    }

    /**
     * Перевіряє, чи входить елемент у масив.
     * Елементи {@code null} у масиві пропускаються, пошук {@code null} завжди повертає {@code false}.
     *
     * @param array   масив
     * @param element шуканий елемент
     * @param <T>     тип елементів масиву
     * @param <V>     тип шуканого елемента: {@code T} або його підклас
     * @return {@code true}, якщо елемент знайдено
     */
    public static <T extends Comparable<T>, V extends T> boolean contains(T[] array, V element) {
        if (element == null) {
            return false;
        }
        for (T item : array) {
            if (item != null && item.compareTo(element) == 0) {
                return true;
            }
        }
        return false;
    }
}
