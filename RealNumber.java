public class RealNumber extends Number {
    private double value;

    public RealNumber(double v) {
        value = v;
    }

    /*
     * Return the sum of this and the other
     */
    public RealNumber add(RealNumber other) {
        // other can be ANY RealNumber, including a RationalNumber
        // or other subclasses of RealNumber (that aren't written yet)
        return new RealNumber(value + other.getValue());
    }

    /*
     * Return the product of this and the other
     */
    public RealNumber multiply(RealNumber other) {
        return new RealNumber(value * other.getValue());
    }

    /*
     * Return the this divided by the other
     */
    public RealNumber divide(RealNumber other) {
        return new RealNumber(value / other.getValue());
    }

    /*
     * Return the this minus the other
     */
    public RealNumber subtract(RealNumber other) {
        return new RealNumber(value - other.getValue());
    }

    public double getValue() {
        return value;
    }

    public String toString() {
        return "" + value;
    }
}