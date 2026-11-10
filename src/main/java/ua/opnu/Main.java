package ua.opnu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    private static final Student[] GROUP = {
            new Student("Дмитро", "Мельник", "АІ-254", new int[]{88, 64, 91}),
            new Student("Софія", "Кравченко", "АІ-254", new int[]{72, 59, 77}),
            new Student("Андрій", "Ткаченко", "АІ-254", new int[]{100, 83, 67}),
            new Student("Юлія", "Литвиненко", "АІ-254", new int[]{40, 66, 55}),
            new Student("Максим", "Савченко", "АІ-254", new int[]{60, 60, 60})
    };

    public static void main(String[] args) {
        taskPrimes();
        taskStudentsWithoutDebts();
        taskTwoConditions();
        taskPrintStudents();
        taskConditionalAction();
        taskPowersOfTwo();
        taskStringify();
    }

    // ---------------- Завдання 1 ----------------
    private static void taskPrimes() {
        header(1, "Прості числа");

        // Предикат реалізовано через анонімний клас
        Predicate<Integer> prime = new Predicate<Integer>() {
            @Override
            public boolean test(Integer value) {
                if (value <= 1) {
                    return false;
                }
                int limit = (int) Math.sqrt(value);
                for (int i = 2; i <= limit; i++) {
                    if (value % i == 0) {
                        return false;
                    }
                }
                return true;
            }
        };

        int[] range = new int[30];
        for (int i = 0; i < range.length; i++) {
            range[i] = i + 1;
        }
        System.out.println("Вхідний масив: " + Arrays.toString(range));
        System.out.println("Результат:     " + Arrays.toString(filter(range, prime)));
    }

    // ---------------- Завдання 2 ----------------
    private static void taskStudentsWithoutDebts() {
        header(2, "Студенти без заборгованостей");

        Predicate<Student> hasNoDebts = student -> {
            for (int mark : student.getMarks()) {
                if (mark < 60) {
                    return false;
                }
            }
            return true;
        };

        for (Student student : filter(GROUP, hasNoDebts)) {
            System.out.println(" • " + student);
        }
    }

    // ---------------- Завдання 3 ----------------
    private static void taskTwoConditions() {
        header(3, "Фільтр за двома умовами");

        int[] data = {-7, -4, 0, 3, 8, 12, 15, 21, 24, 30};
        Predicate<Integer> positive = x -> x > 0;
        Predicate<Integer> divisibleByThree = x -> x % 3 == 0;

        System.out.println("Вхідний масив:          " + Arrays.toString(data));
        System.out.println("Додатні й кратні трьом: " + Arrays.toString(filter(data, positive, divisibleByThree)));
    }

    // ---------------- Завдання 4 ----------------
    private static void taskPrintStudents() {
        header(4, "Consumer: ПРІЗВИЩЕ + ІМ'Я");

        Consumer<Student> printer = s -> System.out.println(s.getSurname().toUpperCase() + " " + s.getName());
        forEach(GROUP, printer);
    }

    // ---------------- Завдання 5 ----------------
    private static void taskConditionalAction() {
        header(5, "Predicate + Consumer");

        int[] values = {14, 3, 27, 8, 50, 1, 33, 16};
        Predicate<Integer> isOdd = x -> x % 2 != 0;
        Consumer<Integer> showCube = x -> System.out.printf("%d -> куб = %d%n", x, x * x * x);

        System.out.println("Вхідний масив: " + Arrays.toString(values));
        System.out.println("Куби непарних чисел:");
        actIf(values, isOdd, showCube);
    }

    // ---------------- Завдання 6 ----------------
    private static void taskPowersOfTwo() {
        header(6, "Function: n -> 2^n");

        Function<Integer, Integer> twoInPower = n -> {
            int result = 1;
            for (int i = 0; i < n; i++) {
                result *= 2;
            }
            return result;
        };

        int[] powers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] results = transform(powers, twoInPower);
        for (int i = 0; i < powers.length; i++) {
            System.out.println("2^" + powers[i] + " = " + results[i]);
        }
    }

    // ---------------- Завдання 7 ----------------
    private static void taskStringify() {
        header(7, "stringify()");

        Function<Integer, String> asWord = digit -> {
            switch (digit) {
                case 0: return "нуль";
                case 1: return "один";
                case 2: return "два";
                case 3: return "три";
                case 4: return "чотири";
                case 5: return "п'ять";
                case 6: return "шість";
                case 7: return "сім";
                case 8: return "вісім";
                case 9: return "дев'ять";
                default: throw new IllegalArgumentException("Не цифра: " + digit);
            }
        };

        int[] shuffled = {7, 2, 9, 0, 4, 1, 8, 3, 6, 5};
        System.out.println("Числа: " + Arrays.toString(shuffled));
        System.out.println("Слова: " + String.join(", ", stringify(shuffled, asWord)));
    }

    // ================= Допоміжні методи =================

    static int[] filter(int[] source, Predicate<Integer> rule) {
        List<Integer> passed = new ArrayList<>();
        for (int x : source) {
            if (rule.test(x)) {
                passed.add(x);
            }
        }
        return toIntArray(passed);
    }

    static Student[] filter(Student[] source, Predicate<Student> rule) {
        List<Student> passed = new ArrayList<>();
        for (Student s : source) {
            if (rule.test(s)) {
                passed.add(s);
            }
        }
        return passed.toArray(new Student[0]);
    }

    static int[] filter(int[] source, Predicate<Integer> first, Predicate<Integer> second) {
        List<Integer> passed = new ArrayList<>();
        for (int x : source) {
            if (first.test(x) && second.test(x)) {
                passed.add(x);
            }
        }
        return toIntArray(passed);
    }

    static void forEach(Student[] source, Consumer<Student> action) {
        for (Student s : source) {
            action.accept(s);
        }
    }

    static void actIf(int[] source, Predicate<Integer> condition, Consumer<Integer> action) {
        for (int x : source) {
            if (condition.test(x)) {
                action.accept(x);
            }
        }
    }

    static int[] transform(int[] source, Function<Integer, Integer> fn) {
        int[] out = new int[source.length];
        for (int i = 0; i < source.length; i++) {
            out[i] = fn.apply(source[i]);
        }
        return out;
    }

    static String[] stringify(int[] source, Function<Integer, String> fn) {
        String[] out = new String[source.length];
        for (int i = 0; i < source.length; i++) {
            out[i] = fn.apply(source[i]);
        }
        return out;
    }

    private static int[] toIntArray(List<Integer> list) {
        int[] out = new int[list.size()];
        for (int i = 0; i < out.length; i++) {
            out[i] = list.get(i);
        }
        return out;
    }

    private static void header(int number, String title) {
        System.out.println();
        System.out.println("────── Завдання " + number + ": " + title + " ──────");
    }
}

class Student {
    private String name;
    private String surname;
    private String group;
    private int[] marks;

    public Student() {
        this("", "", "", new int[0]);
    }

    public Student(String name, String surname, String group, int[] marks) {
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.marks = Arrays.copyOf(marks, marks.length);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int[] getMarks() {
        return Arrays.copyOf(marks, marks.length);
    }

    public void setMarks(int[] marks) {
        this.marks = Arrays.copyOf(marks, marks.length);
    }

    @Override
    public String toString() {
        return String.format("%s %s, група %s, оцінки %s", surname, name, group, Arrays.toString(marks));
    }
}
