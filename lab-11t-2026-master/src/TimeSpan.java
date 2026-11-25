import exceptions.IllegalInputTimeSpanException;
import exceptions.IllegalScaleFactorException;
import exceptions.NegativeTimeSpanException;
import exceptions.TimeSpanOverflowException;

/**
 * Інтервал часу в годинах та хвилинах.
 * <p>
 * Якщо метод викидає виключення, стан об'єкта не змінюється.
 */
public class TimeSpan {

    private static final int MINUTES_PER_HOUR = 60;

    private int hours;
    private int minutes;

    public TimeSpan() {
    }

    public TimeSpan(int minutes) {
        add(minutes);
    }

    public TimeSpan(int hours, int minutes) {
        add(hours, minutes);
    }

    public TimeSpan(TimeSpan other) {
        add(other);
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public double getTotalHours() {
        return hours + (double) minutes / MINUTES_PER_HOUR;
    }

    public int getTotalMinutes() {
        return hours * MINUTES_PER_HOUR + minutes;
    }

    public final void add(int minutes) {
        requireValid(minutes);
        shift(minutes);
    }

    public final void add(int hours, int minutes) {
        requireValid(hours, minutes);
        shift(inMinutes(hours, minutes));
    }

    public final void add(TimeSpan other) {
        requireValid(other);
        shift(other.getTotalMinutes());
    }

    public void subtract(int minutes) {
        requireValid(minutes);
        shift(-(long) minutes);
    }

    public void subtract(int hours, int minutes) {
        requireValid(hours, minutes);
        shift(-inMinutes(hours, minutes));
    }

    public void subtract(TimeSpan other) {
        requireValid(other);
        shift(-(long) other.getTotalMinutes());
    }

    public void scale(int factor) {
        if (factor < 1) {
            throw new IllegalScaleFactorException(
                    "Scale factor must be greater than 0, but was " + factor);
        }
        assign((long) getTotalMinutes() * factor);
    }

    @Override
    public String toString() {
        return String.format("%dh %dm", hours, minutes);
    }

    // Змінює інтервал на delta хвилин (delta може бути від'ємною)
    private void shift(long delta) {
        long result = getTotalMinutes() + delta;
        if (result < 0) {
            throw new NegativeTimeSpanException(
                    "Time span cannot be negative: " + getTotalMinutes() + " min - " + (-delta) + " min");
        }
        assign(result);
    }

    private void assign(long total) {
        if (total > Integer.MAX_VALUE) {
            throw new TimeSpanOverflowException("Time span is too large: " + total + " min");
        }
        hours = (int) (total / MINUTES_PER_HOUR);
        minutes = (int) (total % MINUTES_PER_HOUR);
    }

    private static long inMinutes(int hours, int minutes) {
        return (long) hours * MINUTES_PER_HOUR + minutes;
    }

    private static void requireValid(int minutes) {
        if (minutes < 0) {
            throw new IllegalInputTimeSpanException(
                    "Minutes cannot be negative, but were " + minutes);
        }
    }

    private static void requireValid(int hours, int minutes) {
        if (hours < 0) {
            throw new IllegalInputTimeSpanException(
                    "Hours cannot be negative, but were " + hours);
        }
        if (minutes < 0 || minutes >= MINUTES_PER_HOUR) {
            throw new IllegalInputTimeSpanException(
                    "Minutes must be between 0 and 59, but were " + minutes);
        }
    }

    private static void requireValid(TimeSpan other) {
        if (other == null) {
            throw new IllegalInputTimeSpanException("Time span cannot be null");
        }
    }
}
