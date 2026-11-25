package ua.opnu;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class Task {
    private static final String MARK = "****";

    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        // Після видалення від пари залишається один рядок на позиції i,
        // тому наступна пара починається з позиції i + 1
        for (int i = 0; i < list.size() - 1; i++) {
            boolean firstIsLonger = list.get(i).length() > list.get(i + 1).length();
            list.remove(firstIsLonger ? i + 1 : i);
        }
    }

    public void stutter(List<String> list) {
        // Рухаємось з кінця, щоб не дублювати щойно додані рядки
        for (int i = list.size() - 1; i >= 0; i--) {
            list.add(i, list.get(i));
        }
    }

    public void switchPairs(List<String> list) {
        for (int i = 1; i < list.size(); i += 2) {
            String first = list.get(i - 1);
            list.set(i - 1, list.get(i));
            list.set(i, first);
        }
    }

    public void removeDuplicates(List<String> list) {
        int i = 1;
        while (i < list.size()) {
            if (list.get(i).equals(list.get(i - 1))) {
                list.remove(i);
            } else {
                i++;
            }
        }
    }

    public void markLength4(List<String> list) {
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().length() == 4) {
                // Повертаємось на крок назад, щоб вставити позначку перед рядком
                iterator.previous();
                iterator.add(MARK);
                iterator.next();
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        // Вершиною стеку стає останній елемент черги
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (Integer value : queue) {
            stack.push(value);
        }

        // Черга лише переглядається, тому залишається без змін
        for (Integer value : queue) {
            if (!value.equals(stack.pop())) {
                return false;
            }
        }
        return true;
    }

    public void reorder(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        // Від'ємні числа переносимо у стек: найменше з них опиниться на вершині
        for (int i = 0; i < size; i++) {
            int value = queue.remove();
            if (value < 0) {
                stack.push(value);
            } else {
                queue.add(value);
            }
        }

        int nonNegativeCount = queue.size();
        moveStackToQueue(stack, queue);
        rotate(queue, nonNegativeCount);
    }

    public void rearrange(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        // У черзі залишаються парні числа, непарні переходять у стек
        for (int i = 0; i < size; i++) {
            int value = queue.remove();
            if (value % 2 == 0) {
                queue.add(value);
            } else {
                stack.push(value);
            }
        }

        // Стек змінює порядок непарних чисел на зворотній,
        // тому пропускаємо їх через стек ще раз
        int evenCount = queue.size();
        moveStackToQueue(stack, queue);
        rotate(queue, evenCount);
        while (queue.size() > evenCount) {
            stack.push(queue.remove());
        }
        moveStackToQueue(stack, queue);
    }

    public int maxLength(Set<String> set) {
        return set.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    public void removeEvenLength(Set<String> set) {
        set.removeIf(value -> value.length() % 2 == 0);
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> remaining = new HashSet<>(list1);
        int count = 0;
        for (Integer value : list2) {
            // remove() повертає true лише для першої зустрічі спільного числа
            if (remaining.remove(value)) {
                count++;
            }
        }
        return count;
    }

    public boolean isUnique(Map<String, String> map) {
        Set<String> seen = new HashSet<>();
        for (String value : map.values()) {
            if (!seen.add(value)) {
                return false;
            }
        }
        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (map2.containsKey(key) && Objects.equals(value, map2.get(key))) {
                result.put(key, value);
            }
        }
        return result;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> result = new HashMap<>();
        map.forEach((key, value) -> result.put(value, key));
        return result;
    }

    public int rarest(Map<String, Integer> map) {
        if (map.isEmpty()) {
            throw new IllegalArgumentException("Відображення не повинно бути пустим");
        }

        // TreeMap впорядковує числа за зростанням, а min() повертає перший мінімум,
        // тому за однакової частоти буде обрано найменше число
        Map<Integer, Integer> counts = new TreeMap<>(countOccurrences(map.values()));
        return Collections.min(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public int maxOccurrences(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }
        return Collections.max(countOccurrences(list).values());
    }

    /** Підраховує, скільки разів кожне число зустрічається в колекції. */
    private Map<Integer, Integer> countOccurrences(Collection<Integer> values) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer value : values) {
            counts.merge(value, 1, Integer::sum);
        }
        return counts;
    }

    /** Переносить всі елементи стеку в кінець черги, починаючи з вершини. */
    private void moveStackToQueue(ArrayDeque<Integer> stack, Queue<Integer> queue) {
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    /** Переносить перші {@code count} елементів черги в її кінець. */
    private void rotate(Queue<Integer> queue, int count) {
        for (int i = 0; i < count; i++) {
            queue.add(queue.remove());
        }
    }

}
