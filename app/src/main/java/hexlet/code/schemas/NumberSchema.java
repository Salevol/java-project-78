package hexlet.code.schemas;

public class NumberSchema implements BaseSchema {
    private boolean isRequired;
    private boolean isPositive;
    private boolean inRange;
    private int[] requiredRange = new int[2];

    public NumberSchema() {
        this.isPositive = false;
        this.isRequired = false;
        this.inRange = true;
    }

    public void range(int start, int end) {
        this.requiredRange[0] = start;
        this.requiredRange[1] = end;
        this.inRange = false;
    }

    public void required() {
        this.isRequired = true;
    }

    private boolean isInRange(Integer number) {
        if (!inRange) {
            return requiredRange[0] <= number && number <= requiredRange[1];
        }
        return true;
    }

    public NumberSchema positive() {
        this.isPositive = true;
        return this;
    }

    @Override
    public Boolean isValid(Object object) {
        if (object == null && !isRequired && inRange) {
            return true;
        }
        if (!(object instanceof Integer)) {
            return false;
        }
        Integer number = (Integer) object;
        return (number > 0 && isPositive && isInRange(number)) || (!isPositive && isInRange(number));
    }
}
