package ua.opnu.task3;

/**
 * Завдання 3. Друк масивів довільного типу.
 */
public class Printer {

    /**
     * Роздруковує всі елементи масиву, кожен з нового рядка.
     *
     * @param array масив
     * @param <T>   тип елементів масиву
     */
    public <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}
