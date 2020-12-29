
public class OpenInterval extends Interval{
    
    OpenInterval(int limit) {
        super(limit);
        min = getStart() + 1;
        max = getLimit() - 1;
    } 

    OpenInterval(int start, int limit) {
        super(start, limit);
        min = getStart() + 1;
        max = getLimit() - 1;
    }

    @Override
    public Interval combine(Interval i) {
        if (!checkValidity(i))
            return null;
            
        int newMin = this.min <= i.min ? this.min : i.min;
        int newMax = this.max >= i.max ? this.max : i.max;
        return new OpenInterval(newMin - 1, newMax + 1);
    }

    @Override
    public String toString() {
        if (this == null || !checkValidity()) return "Invalid Interval";

        return "(" + super.toString() + ")"; 
    }

}
