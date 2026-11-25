package model;

/**
 * Арифметика з округленням до копійок.
 * <p>
 * Без округлення 0.1 + 0.2 - 0.3 != 0, і такий рахунок неможливо було б видалити.
 */
final class Money {

    private Money() {
    }

    static double round(double value) {
        return Math.round(value * 100) / 100.0;
    }

    static double plus(double left, double right) {
        return round(left + right);
    }

    static double minus(double left, double right) {
        return round(left - right);
    }
}
