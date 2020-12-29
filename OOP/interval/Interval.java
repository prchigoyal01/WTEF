
public abstract class Interval {
    protected int start, limit;
    protected int min, max;

    Interval() {
        start = 0;
        limit = 0;
    }

    Interval(int start) {
        this.start = start;
        this.limit = 0;
    }

    Interval(int start, int limit) {
        this.limit = limit;
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public int getStart() {
        return start;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setStart(int start) {
        this.start = start;
    }

    protected boolean checkValidity() {
        return start < limit;
    }

    protected boolean checkValidity(Interval i) {
        return (i.start < i.limit) && checkValidity();
    }

    public boolean contains(int n) {
        return checkValidity() && n >= min && n <= max;
    }
    
    public boolean contains(Interval i) {
        return i.min >= this.min && i.max <= this.max && checkValidity() && checkValidity(i);
    }

    public boolean overlaps(Interval i) {
        if (!checkValidity(i))
            return false;

        if (this.min >= i.min && this.min < i.max)
            return true;
        if (this.min <= i.min && i.min < this.max)
            return true;
        return false;
    }

    public boolean lessThan(Interval i) {
        if (!checkValidity(i))
            return false;
        
        if (i.min == this.min) return i.max < this.max;
        return i.min < this.min;
    }

    public boolean moreThan(Interval i) {
        if (!checkValidity(i))
            return false;

        if (i.min == this.min) return i.max > this.max;
        return i.min > this.min;
    }  

    public abstract Interval combine(Interval i);

    @Override
    public String toString() {
        return start + ", " + limit;
    }

    public static String validity() {
        return "When passing one argument in the constructor:\n"
            + "-> The argument should be greater than zero\n" 
            + "When passing two arguments in the constructor:\n" 
            + "-> Secong argument should be greater than first argument\n";
    }
}