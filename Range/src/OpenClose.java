public final class OpenClose extends Interval{
    OpenClose(int low, int high) {
        this.low = low;
        this.high = high;
    }

    @Override
    public boolean lessThan(Interval other) {
        return ((other instanceof CloseClose || other instanceof CloseOpen) && this.high < other.low) ||
                ((other instanceof OpenClose || other instanceof OpenOpen) && this.high <= other.low );
    }

    @Override
    public int length() {
        return this.high - this.low;
    }

    @Override
    public boolean contains(int x) {
        return x > this.low && x <= this.high;
    }

    @Override
    public boolean contains(Interval other) {
        return (other instanceof CloseClose && this.high >= other.high && this.low < other.low) ||
                (other instanceof CloseOpen && this.high >= other.high - 1 && this.low < other.low) ||
                (other instanceof OpenClose && this.high >= other.high && this.low <= other.low) ||
                (other instanceof OpenOpen && this.high >= other.high - 1 && this.low <= other.low);
    }

    @Override
    public boolean equals(Interval other) {
        return other instanceof OpenClose && other.high == this.high && other.low == this.low;
    }

    @Override
    public boolean isDisjoint(Interval other) {
        return (other instanceof CloseClose && (this.high < other.low || this.low >= other.high)) ||
                (other instanceof CloseOpen && (this.high < other.low || this.low >= other.high - 1)) ||
                (other instanceof OpenClose && (this.high <= other.low || this.low >= other.high)) ||
                (other instanceof OpenOpen && (this.high <= other.low || this.low >= other.high - 1));
    }
}
