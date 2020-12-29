abstract class Interval {
    protected int low;
    protected int high;

    public abstract boolean lessThan(Interval other);
    public abstract int length();
    public abstract boolean contains(int x);
    public abstract boolean contains(Interval other);
    public abstract boolean equals(Interval other);
    public abstract boolean isDisjoint(Interval other);
}
