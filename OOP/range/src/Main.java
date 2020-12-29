public class Main {
    public static void main(String[] args) {
        Range a = new Range(8);
        Range b = new Range(4, 9);
        Range c = a.combine(b);

        System.out.println(a + "\n" + b + "\n" + c);
        System.out.println(a.contains(b));
        System.out.println(c.contains(a));
        System.out.println(a.overlaps(b));
        System.out.println(a.lessThan(b));
        System.out.println(a.disjoint(b));
        System.out.println(a.contains(3));

        Range d = new Range(4, 1);
    }
}
