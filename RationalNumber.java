public class RationalNumber extends Number {
    private int numerator, denominator;

    /**
     * Initialize the RationalNumber with the provided values if the denominator is
     * 0, make the fraction 0/1 instead
     * 
     * @param nume the numerator
     * @param deno the denominator
     */
    public RationalNumber(int nume, int deno) {
        if (deno == 0) {
            numerator = 0;
            denominator = 1;
        } else {
            numerator = nume * (int) Math.signum((float) deno);
            denominator = Math.abs(deno);
            if (nume == 0) denominator = 1;
            else reduce();
        }
    }

    /**
     * @return the numerator
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * @return the denominator
     */
    public int getDenominator() {
        return denominator;
    }

    public double getValue() {
        return (double) numerator / denominator;
    }

    /**
     * @return a new RationalNumber that has the same numerator and denominator as
     *         this RationalNumber but reversed.
     */
    public RationalNumber reciprocal() {
        return new RationalNumber(denominator, numerator);
    }

    /**
     * @return true when the RationalNumbers have the same numerators and
     *         denominators, false otherwise.
     */
    public boolean equals(RationalNumber other) {
        return numerator == other.getNumerator() && denominator == other.getDenominator();
    }

    /**
     * @return the value expressed as "3/4" or "8/3"
     */
    public String toString() {
        if (denominator == 1) return "" + numerator;
        return numerator + "/" + denominator;
    }

    /**
     * Calculate the GCD of two integers.
     * 
     * @param a the first integers
     * @param b the second integer
     * @return the value of the GCD
     */
    private static int gcd(int a, int b) {
        /* use euclids method or a better one */
        // sites.math.rutgers.edu/~greenfie/gs2004/euclid.html
        int larger = Math.max(a, b);
        int smaller = Math.min(a, b);
        int mod;
        while ((mod = larger % smaller) != 0) {
            larger = smaller;
            smaller = mod;
        }
        return smaller;
    }

    /**
     * Divide the numerator and denominator by the GCD This must be used to maintain
     * that all RationalNumbers are reduced after construction.
     */
    private void reduce() {
        int divisor = gcd(numerator, denominator);
        numerator /= divisor;
        denominator /= divisor;
    }

    /****************** Operations Return a new RationalNumber!!!! ****************/
    /**
     * Return a new RationalNumber that is the product of this and the other
     */
    public RationalNumber multiply(RationalNumber other) {
        return new RationalNumber(numerator * other.getNumerator(), denominator * other.getDenominator());
    }

    /**
     * Return a new RationalNumber that is the this divided by the other
     */
    public RationalNumber divide(RationalNumber other) {
        return multiply(other.reciprocal());
    }

    /**
     * Return a new RationalNumber that is the sum of this and the other
     */
    public RationalNumber add(RationalNumber other) {
        return new RationalNumber(numerator * other.getDenominator() + other.getNumerator() * denominator,
                denominator * other.getDenominator());
    }

    /**
     * Return a new RationalNumber that this minus the other
     */
    public RationalNumber subtract(RationalNumber other) {
        return add(other.multiply(new RationalNumber(-1, 1)));
    }
}