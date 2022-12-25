package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {

    public NumberSchema() {
        checkList.add(o -> (o instanceof Integer) || (o == null));
    }

    public NumberSchema range(int start, int end) {
        checkList.add(o -> (o != null)  && ((Integer) o) >= start && ((Integer) o) <= end);
        return this;
    }

    public NumberSchema positive() {
        checkList.add((o -> (o == null) || ((Integer) o) > 0));
        return this;
    }
}
