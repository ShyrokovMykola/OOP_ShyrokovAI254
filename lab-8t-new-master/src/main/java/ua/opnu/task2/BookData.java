package ua.opnu.task2;

import java.util.Locale;
import java.util.Objects;

/**
 * Завдання 2. Інформація про книгу в інтернет-магазині.
 */
public class BookData implements Comparable<BookData> {

    private final String title;
    private final String author;
    private final int reviews;
    private final double total;

    /**
     * Створює опис книги.
     *
     * @param title   назва
     * @param author  автор
     * @param reviews загальна кількість оцінок
     * @param total   загальна сума оцінок
     */
    public BookData(String title, String author, int reviews, double total) {
        if (reviews < 0 || total < 0) {
            throw new IllegalArgumentException("Кількість та сума оцінок не можуть бути від'ємними");
        }
        this.title = Objects.requireNonNull(title, "title");
        this.author = Objects.requireNonNull(author, "author");
        this.reviews = reviews;
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getReviews() {
        return reviews;
    }

    public double getTotal() {
        return total;
    }

    /**
     * Обчислює рейтинг книги.
     *
     * @return рейтинг або 0, якщо книгу ще ніхто не оцінив
     */
    public double getRating() {
        return reviews == 0 ? 0 : total / reviews;
    }

    /**
     * Книга з вищим рейтингом "менша"; за однакового рейтингу порівнюються назви.
     */
    @Override
    public int compareTo(BookData other) {
        int byRating = Double.compare(other.getRating(), this.getRating());
        return byRating != 0 ? byRating : this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return String.format(Locale.ROOT, "%s (%s), рейтинг: %.2f", title, author, getRating());
    }
}
