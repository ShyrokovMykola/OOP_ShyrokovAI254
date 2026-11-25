package ua.opnu.task6;

/**
 * Завдання 6. Кортеж з трьох елементів, побудований на основі {@link GenericTwoTuple} (композиція).
 *
 * @param <T> тип першого елемента
 * @param <V> тип другого елемента
 * @param <S> тип третього елемента
 */
public class GenericThreeTuple<T, V, S> {

    public final S three;

    private final GenericTwoTuple<T, V> twoTuple;

    public GenericThreeTuple(T first, V second, S three) {
        this.twoTuple = new GenericTwoTuple<>(first, second);
        this.three = three;
    }

    public T getFirst() {
        return twoTuple.first;
    }

    public V getSecond() {
        return twoTuple.second;
    }

    @Override
    public String toString() {
        return "(" + getFirst() + "," + getSecond() + "," + three + ')';
    }
}
