
public class CloseInterval extends Interval {

    CloseInterval(int limit) {
        super(limit);
        min = getStart();
        max = getLimit();
    } 

    CloseInterval(int start, int limit) {
        super(start, limit);
        min = getStart();
        max = getLimit();
    }

    @Override
    public Interval combine(Interval i) {
        if (!checkValidity(i))
            return null;

        int newMin = this.min <= i.min ? this.min : i.min;
        int newMax = this.max >= i.max ? this.max : i.max;
        return new CloseInterval(newMin, newMax);
    }

    @Override
    public String toString() {
        if (this == null || !checkValidity()) return "Invalid Interval";

        return "[" + super.toString() + "]"; 
    }
}
