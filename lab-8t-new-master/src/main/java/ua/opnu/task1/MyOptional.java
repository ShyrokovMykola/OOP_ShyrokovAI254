package ua.opnu.task1;

/**
 * Завдання 1. Контейнер, який або містить значення типу {@code T}, або порожній.
 *
 * @param <T> тип значення
 */
public class MyOptional<T> {

    private final T value;
    private final boolean present;

    /**
     * Створює порожній об'єкт.
     */
    public MyOptional() {
        this.value = null;
        this.present = false;
    }

    /**
     * Створює об'єкт зі значенням.
     *
     * @param value значення, не може бути {@code null}
     * @throws IllegalArgumentException якщо {@code value} дорівнює {@code null}
     */
    public MyOptional(T value) {
        if (value == null) {
            throw new IllegalArgumentException("MyOptional не приймає null");
        }
        this.value = value;
        this.present = true;
    }

    public boolean isPresent() {
        return present;
    }

    public boolean isEmpty() {
        return !isPresent();
    }

    /**
     * Повертає значення, якщо воно існує.
     *
     * @return збережене значення
     * @throws IllegalStateException якщо значення відсутнє
     */
    public T get() {
        if (isEmpty()) {
            throw new IllegalStateException("Значення відсутнє");
        }
        return value;
    }

    /**
     * Повертає значення, якщо воно існує, інакше - значення за замовчуванням.
     *
     * @param defaultValue значення за замовчуванням
     * @return збережене значення або {@code defaultValue}
     */
    public T orElse(T defaultValue) {
        return isPresent() ? value : defaultValue;
    }

    @Override
    public String toString() {
        return isPresent() ? "MyOptional[value=" + value + "]" : "MyOptional[empty]";
    }
}
