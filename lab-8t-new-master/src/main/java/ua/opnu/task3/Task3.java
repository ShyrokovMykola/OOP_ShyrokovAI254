package ua.opnu.task3;

/**
 * Демонстрація завдання 3: {@link Printer}.
 */
public class Task3 {

    public static void main(String[] args) {
        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
    }
}
