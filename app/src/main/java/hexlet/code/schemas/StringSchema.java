package hexlet.code.schemas;

import java.util.Objects;

public class StringSchema extends BaseSchema {

    public StringSchema() {
        checkList.add(o -> (o instanceof String) || (o == null));
    }

    @Override
    public StringSchema required() {
        checkList.add(str -> !(Objects.isNull(str) || ((String) str).isEmpty()));
        return this;
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
