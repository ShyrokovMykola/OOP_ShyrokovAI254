package ua.opnu.task6;

/**
 * Демонстрація завдання 6: {@link GenericTwoTuple} та {@link GenericThreeTuple}.
 */
public class Task6 {

    public static void main(String[] args) {
        GenericTwoTuple<String, Integer> student = getStudentWithRating("Іванов Петро Петрович");
        System.out.println("Студент: " + student.first + ", рейтинг: " + student.second);
        System.out.println(student);

        GenericThreeTuple<Integer, Integer, Double> stats = getStatistics(new int[]{4, 8, 15, 16, 23, 42});
        System.out.println("Мінімум: " + stats.getFirst()
                + ", максимум: " + stats.getSecond()
                + ", середнє: " + stats.three);
        System.out.println(stats);
    }

    private static GenericTwoTuple<String, Integer> getStudentWithRating(String fullName) {
        int rating = 95;
        return new GenericTwoTuple<>(fullName, rating);
    }

    /**
     * Повертає мінімум, максимум та середнє значення непорожнього масиву.
     */
    private static GenericThreeTuple<Integer, Integer, Double> getStatistics(int[] numbers) {
        int min = numbers[0];
        int max = numbers[0];
        double sum = 0;
        for (int number : numbers) {
            min = Math.min(min, number);
            max = Math.max(max, number);
            sum += number;
        }
        return new GenericThreeTuple<>(min, max, sum / numbers.length);
    }
}
