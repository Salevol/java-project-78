package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public abstract class BaseSchema {
    protected List<Predicate<Object>> checkList = new ArrayList<>();

    public boolean isValid(final Object object) {
        return checkList.stream().allMatch(pre -> pre.test(object));
    }

    public BaseSchema required() {
        checkList.add(Objects::nonNull);
        return this;
    }
}
