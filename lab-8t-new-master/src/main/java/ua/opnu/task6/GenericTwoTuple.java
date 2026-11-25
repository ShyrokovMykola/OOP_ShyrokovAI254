package ua.opnu.task6;

/**
 * Завдання 6. Кортеж з двох елементів.
 *
 * @param <T> тип першого елемента
 * @param <V> тип другого елемента
 */
public class GenericTwoTuple<T, V> {

    public final T first;
    public final V second;

    public GenericTwoTuple(T first, V second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ')';
    }
}
