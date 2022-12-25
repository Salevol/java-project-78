package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<StringSchema> {

    public StringSchema() {
        checkList.add(o -> (o instanceof String) || (o == null));
    }

    public StringSchema contains(String str) {
        checkList.add(o -> ((o != null) && ((String) o).contains(str)));
        return this;
    }

    public StringSchema minLength(int length) {
        checkList.add(o -> ((o != null) && ((String) o).length() >= length));
        return this;
    }
}
