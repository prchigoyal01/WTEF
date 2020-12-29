import java.util.Objects;

public class Range {
    private int min;
    private int max;

    Range(int max) {
        this.min = 0;
        this.max = max;
    }

    Range(int min, int max) {
        if (max < min) {
            this.max = max;
            this.min = min;
        } else {
            this.min = min;
            this.max = max;
        }
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    boolean contains(Range r) {
        return r.min >= min && r.max <= max;
    }

    boolean contains(int n) {
        return n >= min && n < max;
    }

    Range combine(Range r) {
        int newMin = this.min <= r.min ? this.min : r.min;
        int newMax = this.max >= r.max ? this.max : r.max;
        return new Range(newMin, newMax);
    }

    boolean overlaps(Range r) {
        if (this.min >= r.min && this.min < r.max)
            return true;
        if (this.min <= r.min && r.min < this.max)
            return true;
        return false;
    }

    boolean lessThan(Range r) {
        if (r.min == this.min) return r.max < this.max;
        return r.min < this.min;
    }

    boolean moreThan(Range r) {
        if (r.min == this.min) return r.max > this.max;
        return r.min > this.min;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Range range = (Range) o;
        return min == range.min && max == range.max;
    }

    boolean disjoint(Range r) {
        return min > r.max || max < r.min;
    }

    @Override
    public String toString() {
        String range = "{";
        for (int i = min; i < max; i++) {
            range += i + ", ";
        }
        return range.substring(0, range.length() - 2) + "}";
    }
}
