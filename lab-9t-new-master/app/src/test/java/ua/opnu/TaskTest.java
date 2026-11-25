package ua.opnu;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    public static Task task;

    @BeforeAll
    static void setup() {
        task = new Task();
    }

    @Nested
    @DisplayName("Tests for the task 1")
    class Task1Test {

        @Test
        public void test1() {
            String[] data = {"four", "score", "and", "seven", "years", "ago"};
            String[] data2 = {"score", "seven", "years"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.removeShorterStrings(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test2() {
            String[] data = {"Lots", "of  ", "ties", "in  ", "this", "test"};
            String[] data2 = {"of  ", "in  ", "test"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.removeShorterStrings(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test3() {
            String[] data = {"Don't", "remove", "the", "last", "string (me)"};
            String[] data2 = {"remove", "last", "string (me)"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.removeShorterStrings(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test4() {
            String[] data = {"Don't remove me"};
            String[] data2 = {"Don't remove me"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.removeShorterStrings(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test5() {
            String[] data = {};
            String[] data2 = {};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.removeShorterStrings(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }
    }

    @Nested
    @DisplayName("Tests for the task 2")
    class Task2Test {
        @Test
        public void test1() {

            String[] data = {"how", "are", "you?"};
            String[] data2 = {"how", "how", "are", "are", "you?", "you?"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.stutter(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test2() {

            String[] data = {"I", "am", "great,", "thanks!"};
            String[] data2 = {"I", "I", "am", "am", "great,", "great,", "thanks!", "thanks!"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.stutter(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test3() {

            String[] data = {"One string only"};
            String[] data2 = {"One string only", "One string only"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.stutter(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test4() {

            String[] data = {"1", "4", "3"};
            String[] data2 = {"1", "1", "4", "4", "3", "3"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.stutter(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test5() {

            String[] data = {};
            String[] data2 = {};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.stutter(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

    }

    @Nested
    @DisplayName("Tests for the task 3")
    class Task3Test {

        @Test
        public void test1() {
            String[] data = {"four", "score", "and", "seven", "years", "ago"};
            String[] data2 = {"score", "four", "seven", "and", "ago", "years"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.switchPairs(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test2() {
            String[] data = {"to", "be", "or", "not", "to", "be", "hamlet"};
            String[] data2 = {"be", "to", "not", "or", "be", "to", "hamlet"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.switchPairs(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test3() {
            String[] data = {"I", "love", "programming!"};
            String[] data2 = {"love", "I", "programming!"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.switchPairs(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test4() {
            String[] data = {"Pretty", "straight", "forward", "test", "with", "a", "twist"};
            String[] data2 = {"straight", "Pretty", "test", "forward", "a", "with", "twist"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.switchPairs(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test5() {
            String[] data = {"don't move me"};
            String[] data2 = {"don't move me"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.switchPairs(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test6() {
            String[] data = {};
            String[] data2 = {};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.switchPairs(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

    }

    @Nested
    @DisplayName("Tests for the task 4")
    class Task4Test {

        @Test
        public void test1() {
            String[] data = {"be", "be", "is", "not", "or", "question", "that", "the", "to", "to"};
            String[] data2 = {"be", "is", "not", "or", "question", "that", "the", "to"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.removeDuplicates(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test2() {
            String[] data = {"duplicate", "duplicate", "duplicate", "duplicate", "duplicate"};
            String[] data2 = {"duplicate"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.removeDuplicates(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test3() {
            String[] data = {"unique"};
            String[] data2 = {"unique"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.removeDuplicates(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test4() {
            String[] data = {"be", "is", "not", "or", "question", "that", "the", "to"};
            String[] data2 = {"be", "is", "not", "or", "question", "that", "the", "to"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.removeDuplicates(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test5() {
            String[] data = {};
            String[] data2 = {};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.removeDuplicates(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

    }

    @Nested
    @DisplayName("Tests for the task 5")
    class Task5Test {

        @Test
        public void test1() {
            String[] data = {"this", "is", "lots", "of", "fun", "for", "every", "Java", "programmer"};
            String[] data2 = {"****", "this", "is", "****", "lots", "of", "fun", "for", "every", "****", "Java", "programmer"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.markLength4(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test2() {
            String[] data = {"four", "for ", "all "};
            String[] data2 = {"****", "four", "****", "for ", "****", "all "};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.markLength4(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test3() {
            String[] data = {"Don't", "do", "anything", "to", "the", "list!"};
            String[] data2 = {"Don't", "do", "anything", "to", "the", "list!"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.markLength4(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test4() {
            String[] data = {"four"};
            String[] data2 = {"****", "four"};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.markLength4(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

        @Test
        public void test5() {
            String[] data = {};
            String[] data2 = {};
            List<String> actual = new ArrayList<>(Arrays.asList(data2));
            List<String> expected = new ArrayList<>(Arrays.asList(data));
            Task task = new Task();
            task.markLength4(expected);

            assertArrayEquals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        }

    }

    @Nested
    @DisplayName("Tests for the task 6")
    class Task6Test {

        @Test
        public void test1() {
            Integer[] data = {3, 8, 17, 9, 17, 8, 3};

            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            boolean result = task.isPalindrome(actual);

            assertTrue(result);
        }

        @Test
        public void test2() {
            Integer[] data = {3, 8, 17, 9, 4, 17, 8, 3};

            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            boolean result = task.isPalindrome(actual);

            assertFalse(result);
        }

        @Test
        public void test3() {
            Integer[] data = {};

            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            boolean result = task.isPalindrome(actual);

            assertTrue(result);
        }

        @Test
        public void test4() {
            Integer[] data = {1};

            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            boolean result = task.isPalindrome(actual);

            assertTrue(result);
        }

        @Test
        public void test5() {
            Integer[] data = {1, 2};

            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            boolean result = task.isPalindrome(actual);

            assertFalse(result);
        }

        @Test
        public void test6() {
            Integer[] data = {1, 2, 1};

            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            boolean result = task.isPalindrome(actual);

            assertTrue(result);
        }

        @Test
        public void test7() {
            Integer[] data = {5, 10, -1, 4, 3, 2, 4, -1, 10, 5};

            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            boolean result = task.isPalindrome(actual);

            assertFalse(result);
        }

        @Test
        public void test8() {
            Integer[] data = {5, 10, -1, 4, 3, 3, 4, -1, 10, 5};

            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            boolean result = task.isPalindrome(actual);

            assertTrue(result);
        }

        @Test
        public void test9() {
            Integer[] data = {5, 10, -1, 4, 3, 2, 2, 4, -1, 10, 5};

            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            boolean result = task.isPalindrome(actual);

            assertFalse(result);
        }

        @Test
        public void test10() {
            Integer[] data = {5, 10, -1, 4, 3, 4, -1, 10, 5};

            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            boolean result = task.isPalindrome(actual);

            assertTrue(result);
        }
    }

    @Nested
    @DisplayName("Tests for the task 7")
    class Task7Test {

        @Test
        public void test1() {
            Integer[] data = {-15, -8, -5, -2, 1, 2, 4, 8, 12, 23};
            Integer[] data2 = {1, 2, -2, 4, -5, 8, -8, 12, -15, 23};
            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data2));
            Queue<Integer> expected = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            task.reorder(actual);

            assertArrayEquals(actual.toArray(new Integer[0]), expected.toArray(new Integer[0]));
        }

    }

    @Nested
    @DisplayName("Tests for the task 8")
    class Task8Test {

        @Test
        public void test1() {
            Integer[] data = {4, 6, 84, 16, 3, 5, 17, 83, 1, 37};
            Integer[] data2 = {3, 5, 4, 17, 6, 83, 1, 84, 16, 37};
            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data2));
            Queue<Integer> expected = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            task.rearrange(actual);

            assertArrayEquals(actual.toArray(new Integer[0]), expected.toArray(new Integer[0]));
        }

        @Test
        public void test2() {
            Integer[] data = {-3, -1, 1, 3};
            Integer[] data2 = {-3, -1, 1, 3};
            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data2));
            Queue<Integer> expected = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            task.rearrange(actual);

            assertArrayEquals(actual.toArray(new Integer[0]), expected.toArray(new Integer[0]));
        }

        @Test
        public void test3() {
            Integer[] data = {-4, -2, 0, 2, 4};
            Integer[] data2 = {-4, -2, 0, 2, 4};
            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data2));
            Queue<Integer> expected = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            task.rearrange(actual);

            assertArrayEquals(actual.toArray(new Integer[0]), expected.toArray(new Integer[0]));
        }

        @Test
        public void test4() {
            Integer[] data = {0, -3, -1, 1, 3};
            Integer[] data2 = {-3, -1, 0, 1, 3};
            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data2));
            Queue<Integer> expected = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            task.rearrange(actual);

            assertArrayEquals(actual.toArray(new Integer[0]), expected.toArray(new Integer[0]));
        }

        @Test
        public void test5() {
            Integer[] data = {-4, -2, 8, 6, 0, 3, 7, 1, 5};
            Integer[] data2 = {-4, -2, 3, 7, 8, 6, 1, 5, 0};
            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data2));
            Queue<Integer> expected = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            task.rearrange(actual);

            assertArrayEquals(actual.toArray(new Integer[0]), expected.toArray(new Integer[0]));
        }

        @Test
        public void test6() {
            Integer[] data = {0};
            Integer[] data2 = {0};
            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data2));
            Queue<Integer> expected = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            task.rearrange(actual);

            assertArrayEquals(actual.toArray(new Integer[0]), expected.toArray(new Integer[0]));
        }

        @Test
        public void test7() {
            Integer[] data = {};
            Integer[] data2 = {};
            Queue<Integer> actual = new LinkedList<>(Arrays.asList(data2));
            Queue<Integer> expected = new LinkedList<>(Arrays.asList(data));
            Task task = new Task();
            task.rearrange(actual);

            assertArrayEquals(actual.toArray(new Integer[0]), expected.toArray(new Integer[0]));
        }
    }

    @Nested
    @DisplayName("Tests for the task 9")
    class Task9Test {

        @Test
        public void test1() {
            Set<String> src = Set.of("tenletters");
            int actual = task.maxLength(src);

            assertEquals(10, actual);
        }

        @Test
        public void test2() {
            Set<String> src = Set.of("one", "two", "three", "four", "get your person", "on the floor", "gotta gotta get up to get", "down");
            int actual = task.maxLength(src);

            assertEquals(25, actual);
        }

        @Test
        public void test3() {
            Set<String> src = Collections.emptySet();
            int actual = task.maxLength(src);

            assertEquals(0, actual);
        }
    }

    @Nested
    @DisplayName("Tests for the task 10")
    class Task10Test {
        @Test
        public void test1() {
            Set<String> actual = Stream.of("foo", "buzz", "bar", "fork", "bort", "spoon", "!", "dude").collect(Collectors.toSet());
            Set<String> expected = Stream.of("!", "bar", "foo", "spoon").collect(Collectors.toSet());
            task.removeEvenLength(actual);

            assertEquals(expected, actual);
        }

        @Test
        public void test2() {
            Set<String> actual = Stream.of("foo", "bar").collect(Collectors.toSet());
            Set<String> expected = Stream.of("foo", "bar").collect(Collectors.toSet());
            task.removeEvenLength(actual);

            assertEquals(expected, actual);
        }

        @Test
        public void test3() {
            Set<String> actual = Collections.emptySet();
            Set<String> expected = Collections.emptySet();
            task.removeEvenLength(actual);

            assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("Tests for the task 11")
    class Task11Test {

        @Test
        public void test1() {
            List<Integer> list1 = List.of(3, 7, 3, -1, 2, 3, 7, 2, 15, 15);
            List<Integer> list2 = List.of(-5, 15, 2, -1, 7, 15, 36);
            int actual = task.numInCommon(list1, list2);

            assertEquals(4, actual);
        }

        @Test
        public void test2() {
            List<Integer> list1 = List.of(1, 2, 3);
            List<Integer> list2 = List.of(3, 4, 5);
            int actual = task.numInCommon(list1, list2);

            assertEquals(1, actual);
        }

        @Test
        public void test3() {
            List<Integer> list1 = List.of(1, 2, 3);
            List<Integer> list2 = List.of(2);
            int actual = task.numInCommon(list1, list2);

            assertEquals(1, actual);
        }

        @Test
        public void test4() {
            List<Integer> list1 = List.of(4);
            List<Integer> list2 = List.of(1, 2, 3);
            int actual = task.numInCommon(list1, list2);

            assertEquals(0, actual);
        }

        @Test
        public void test5() {
            List<Integer> list1 = Collections.emptyList();
            List<Integer> list2 = Collections.emptyList();
            int actual = task.numInCommon(list1, list2);

            assertEquals(0, actual);
        }
    }

    @Nested
    @DisplayName("Tests for the task 12")
    class Task12Test {

        @Test
        public void test1() {
            Map<String, String> map = new HashMap<>();
            map.put("Marty", "Stepp");
            map.put("Stuart", "Reges");
            map.put("Jessica", "Miller");
            map.put("Amanda", "Camp");
            map.put("Hal", "Perkins");
            boolean actual = task.isUnique(map);

            assertTrue(actual);
        }

        @Test
        public void test2() {
            Map<String, String> map = new HashMap<>();
            map.put("Kendrick", "Perkins");
            map.put("Stuart", "Reges");
            map.put("Jessica", "Miller");
            map.put("Bruce", "Reges");
            map.put("Hal", "Perkins");
            boolean actual = task.isUnique(map);

            assertFalse(actual);
        }

        @Test
        public void test3() {
            Map<String, String> map = new HashMap<>();
            boolean actual = task.isUnique(map);

            assertTrue(actual);
        }
    }

    @Nested
    @DisplayName("Tests for the task 13")
    class Task13Test {

        @Test
        public void test1() {
            Map<String, Integer> map1 = new HashMap<>();
            map1.put("Janet", 87);
            map1.put("Logan", 62);
            map1.put("Whitaker", 46);
            map1.put("Alyssa", 100);
            map1.put("Stefanie", 80);
            map1.put("Jeff", 88);
            map1.put("Kim", 52);
            map1.put("Sylvia", 95);

            Map<String, Integer> map2 = new HashMap<>();
            map2.put("Logan", 62);
            map2.put("Kim", 52);
            map2.put("Whitaker", 52);
            map2.put("Jeff", 88);
            map2.put("Stefanie", 80);
            map2.put("Brian", 60);
            map2.put("Lisa", 83);
            map2.put("Sylvia", 87);

            Map<String, Integer> expected = new HashMap<>();
            expected.put("Logan", 62);
            expected.put("Stefanie", 80);
            expected.put("Jeff", 88);
            expected.put("Kim", 52);

            Map<String, Integer> actual = task.intersect(map1, map2);

            assertEquals(expected, actual);
        }

        @Test
        public void test2() {
            Map<String, Integer> map1 = new HashMap<>();
            map1.put("a", 1);
            map1.put("b", 2);
            map1.put("c", 3);
            map1.put("d", 4);

            Map<String, Integer> map2 = new HashMap<>();
            map2.put("b", 2);
            map2.put("c", 5);
            map2.put("d", 4);
            map2.put("e", 4);
            map2.put("f", 1);

            Map<String, Integer> expected = new HashMap<>();
            expected.put("b", 2);
            expected.put("d", 4);

            Map<String, Integer> actual = task.intersect(map1, map2);

            assertEquals(expected, actual);
        }

        @Test
        public void test3() {
            Map<String, Integer> map1 = new HashMap<>();
            map1.put("a", 1);
            map1.put("b", 2);
            map1.put("c", 3);
            map1.put("d", 4);

            Map<String, Integer> map2 = new HashMap<>();
            map2.put("a", 1);
            map2.put("b", 2);
            map2.put("c", 3);
            map2.put("d", 4);

            Map<String, Integer> expected = new HashMap<>();
            expected.put("a", 1);
            expected.put("b", 2);
            expected.put("c", 3);
            expected.put("d", 4);

            Map<String, Integer> actual = task.intersect(map1, map2);

            assertEquals(expected, actual);
        }

        @Test
        public void test4() {
            Map<String, Integer> map1 = new HashMap<>();
            map1.put("a", 1);
            map1.put("b", 2);
            map1.put("c", 3);
            map1.put("d", 4);

            Map<String, Integer> map2 = new HashMap<>();
            map2.put("x", 0);
            map2.put("a", 1);
            map2.put("b", 2);
            map2.put("c", 3);
            map2.put("d", 4);
            map2.put("e", 5);

            Map<String, Integer> expected = new HashMap<>();
            expected.put("a", 1);
            expected.put("b", 2);
            expected.put("c", 3);
            expected.put("d", 4);

            Map<String, Integer> actual = task.intersect(map1, map2);

            assertEquals(expected, actual);
        }

        @Test
        public void test5() {
            Map<String, Integer> map1 = new HashMap<>();
            map1.put("x", 0);
            map1.put("a", 1);
            map1.put("b", 2);
            map1.put("c", 3);
            map1.put("d", 4);
            map1.put("e", 5);

            Map<String, Integer> map2 = new HashMap<>();
            map2.put("a", 1);
            map2.put("b", 2);
            map2.put("c", 3);
            map2.put("d", 4);

            Map<String, Integer> expected = new HashMap<>();
            expected.put("a", 1);
            expected.put("b", 2);
            expected.put("c", 3);
            expected.put("d", 4);

            Map<String, Integer> actual = task.intersect(map1, map2);

            assertEquals(expected, actual);
        }

        @Test
        public void test6() {
            Map<String, Integer> map1 = new HashMap<>();
            map1.put("a", 1);
            map1.put("b", 2);
            map1.put("c", 3);
            map1.put("d", 4);

            Map<String, Integer> map2 = new HashMap<>();
            map2.put("a", 5);
            map2.put("b", 6);
            map2.put("c", 7);
            map2.put("d", 8);

            Map<String, Integer> expected = new HashMap<>();
            Map<String, Integer> actual = task.intersect(map1, map2);

            assertEquals(expected, actual);
        }

        @Test
        public void test7() {
            Map<String, Integer> map1 = new HashMap<>();
            map1.put("a", 1);
            map1.put("b", 2);

            Map<String, Integer> map2 = new HashMap<>();

            Map<String, Integer> expected = new HashMap<>();
            Map<String, Integer> actual = task.intersect(map1, map2);

            assertEquals(expected, actual);
        }

        @Test
        public void test8() {
            Map<String, Integer> map1 = new HashMap<>();

            Map<String, Integer> map2 = new HashMap<>();
            map2.put("a", 1);

            Map<String, Integer> expected = new HashMap<>();
            Map<String, Integer> actual = task.intersect(map1, map2);

            assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("Tests for the task 14")
    class Task14Test {

        @Test
        public void test1() {
            Map<Integer, String> map = new TreeMap<>();
            map.put(42, "Marty");
            map.put(81, "Sue");
            map.put(17, "Ed");
            map.put(31, "Dave");
            map.put(56, "Ed");
            map.put(3, "Marty");
            map.put(29, "Ed");

            Map<String, Integer> expected = new TreeMap<>();
            expected.put("Sue", 81);
            expected.put("Marty", 42);
            expected.put("Dave", 31);
            expected.put("Ed", 56);

            Map<String, Integer> actual = task.reverse(map);

            assertEquals(expected, actual);
        }

        @Test
        public void test2() {
            Map<Integer, String> map = new HashMap<>();
            map.put(13, "King");
            map.put(12, "Queen");
            map.put(11, "Jack");
            map.put(1, "Ace");

            Map<String, Integer> expected = new HashMap<>();
            expected.put("Ace", 1);
            expected.put("King", 13);
            expected.put("Queen", 12);
            expected.put("Jack", 11);

            Map<String, Integer> actual = task.reverse(map);

            assertEquals(expected, actual);
        }

        @Test
        public void test3() {
            Map<Integer, String> map = new HashMap<>();
            map.put(1, "John");
            map.put(25, "John");
            map.put(47, "John");
            map.put(13, "John");
            map.put(0, "Smith");

            Map<String, Integer> expected = new HashMap<>();
            expected.put("Smith", 0);
            expected.put("John", 47);

            Map<String, Integer> actual = task.reverse(map);

            assertEquals(expected, actual);
        }

        @Test
        public void test4() {
            Map<Integer, String> map = new HashMap<>();

            Map<String, Integer> expected = new HashMap<>();
            Map<String, Integer> actual = task.reverse(map);

            assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("Tests for the task 15")
    class Task15Test {

        @Test
        public void test1() {
            Map<String, Integer> map = new TreeMap<>();
            map.put("Alyssa", 22);
            map.put("Char", 25);
            map.put("Dan", 25);
            map.put("Jeff", 20);
            map.put("Kasey", 20);
            map.put("Kim", 20);
            map.put("Morgan", 25);
            map.put("Ryan", 25);
            map.put("Stef", 22);

            int actual = task.rarest(map);

            assertEquals(22, actual);
        }

        @Test
        public void test2() {
            Map<String, Integer> map = new TreeMap<>();
            map.put("Alyssa", 22);
            map.put("Char", 25);
            map.put("Dan", 25);
            map.put("Jeff", 20);
            map.put("Kasey", 20);
            map.put("Kim", 20);
            map.put("Morgan", 25);
            map.put("Ryan", 25);
            map.put("Stef", 22);
            map.put("Kelly", 22);

            int actual = task.rarest(map);

            assertEquals(20, actual);
        }

        @Test
        public void test3() {
            Map<String, Integer> map = new TreeMap<>();
            map.put("Alyssa", 21);
            map.put("Char", 21);
            map.put("Dan", 21);
            map.put("Jeff", 21);
            map.put("Kasey", 21);
            map.put("Kim", 21);
            map.put("Morgan", 21);
            map.put("Ryan", 21);
            map.put("Stef", 21);

            int actual = task.rarest(map);

            assertEquals(21, actual);
        }

        @Test
        public void test4() {
            Map<String, Integer> map = new TreeMap<>();
            map.put("Marty", 40);
            map.put("Stuart", 50);

            int actual = task.rarest(map);

            assertEquals(40, actual);
        }

        @Test
        public void test5() {
            Map<String, Integer> map = new TreeMap<>();
            map.put("Alyssa", 40);

            int actual = task.rarest(map);
            assertEquals(40, actual);
        }
    }

    @Nested
    @DisplayName("Tests for the task 16")
    class Task16Test {

        @Test
        public void test1() {
            List<Integer> list1 = List.of(1, 1, 2, 3, 4);

            int actual = task.maxOccurrences(list1);

            assertEquals(2, actual);
        }

        @Test
        public void test2() {
            List<Integer> list1 = List.of(5, 6, 5, 6, 5, 6);

            int actual = task.maxOccurrences(list1);

            assertEquals(3, actual);
        }

        @Test
        public void test3() {
            List<Integer> list1 = List.of(0, 0, 0, 0);

            int actual = task.maxOccurrences(list1);

            assertEquals(4, actual);
        }

        @Test
        public void test4() {
            List<Integer> list1 = Collections.emptyList();

            int actual = task.maxOccurrences(list1);

            assertEquals(0, actual);
        }
    }
}