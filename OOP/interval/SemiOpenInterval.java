
public class SemiOpenInterval extends Interval {
    
    SemiOpenInterval(int limit) {
        super(limit);
        min = getStart();
        max = getLimit() - 1;
    } 

    SemiOpenInterval(int start, int limit) {
        super(start, limit);
        min = getStart();
        max = getLimit() - 1;
    }

    @Override
    public Interval combine(Interval i) {
        if (!checkValidity(i))
            return null;

        int newMin = this.min <= i.min ? this.min : i.min;
        int newMax = this.max >= i.max ? this.max : i.max;
        return new OpenInterval(newMin, newMax + 1);
    }

    @Override
    public String toString() {
        if (this == null || !checkValidity()) return "Invalid Interval";

        return "[" + super.toString() + ")"; 
    }
}
