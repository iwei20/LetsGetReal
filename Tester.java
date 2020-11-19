public class Tester {
    public static void main(String[] args) {
        RealNumber a = new RealNumber(Math.sqrt(2));
        System.out.println(a);
        System.out.println(a.add(a));
        System.out.println(a.multiply(a)); // 2
        System.out.println(a.subtract(a)); // 0
        System.out.println(a.divide(a)); // 1
        System.out.println(a.equals(new RealNumber(Math.cos(Math.PI / 4) * 2))); // True
        System.out.println(a.equals(new RealNumber(0))); // False
    }
}
