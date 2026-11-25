import exceptions.IllegalInputTimeSpanException;
import exceptions.IllegalScaleFactorException;
import exceptions.NegativeTimeSpanException;
import exceptions.TimeSpanOverflowException;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Демонстрація роботи класу TimeSpan та його виключень (завдання 1).
 */
public class TimeSpanDemo {

    public static void main(String[] args) {
        TimeSpan span = new TimeSpan(2, 15);

        showOperations(span);

        System.out.println("\nErrors:");
        invalidCalls(span).forEach(TimeSpanDemo::attempt);

        System.out.println("\nAfter errors:     " + span);
    }

    private static void showOperations(TimeSpan span) {
        System.out.println("Initial:          " + span);

        span.add(1, 50);
        System.out.println("add(1, 50):       " + span);

        span.subtract(new TimeSpan(65));
        System.out.println("subtract(65 min): " + span);

        span.scale(2);
        System.out.println("scale(2):         " + span);
        System.out.println("Total hours:      " + span.getTotalHours());
        System.out.println("Total minutes:    " + span.getTotalMinutes());
    }

    private static Map<String, Runnable> invalidCalls(TimeSpan span) {
        Map<String, Runnable> calls = new LinkedHashMap<>();
        calls.put("new TimeSpan(-5)", () -> new TimeSpan(-5));
        calls.put("new TimeSpan(-1, 10)", () -> new TimeSpan(-1, 10));
        calls.put("new TimeSpan(1, 60)", () -> new TimeSpan(1, 60));
        calls.put("add(null)", () -> span.add(null));
        calls.put("subtract(100, 0)", () -> span.subtract(100, 0));
        calls.put("scale(0)", () -> span.scale(0));
        calls.put("scale(-3)", () -> span.scale(-3));
        calls.put("scale(Integer.MAX_VALUE)", () -> span.scale(Integer.MAX_VALUE));
        return calls;
    }

    private static void attempt(String title, Runnable call) {
        String outcome;
        try {
            call.run();
            outcome = "OK";
        } catch (IllegalInputTimeSpanException e) {
            outcome = "illegal input. " + e.getMessage();
        } catch (NegativeTimeSpanException e) {
            outcome = "negative result. " + e.getMessage();
        } catch (IllegalScaleFactorException e) {
            outcome = "illegal factor. " + e.getMessage();
        } catch (TimeSpanOverflowException e) {
            outcome = "overflow. " + e.getMessage();
        }
        System.out.println(" - " + title + ": " + outcome);
    }
}
