package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

abstract class BaseSchema {
    List<Predicate<Object>> checkList = new ArrayList<>();

    public boolean isValid(final Object object) {
        return checkList.stream().allMatch(pre -> pre.test(object));
    }

    protected BaseSchema required() {
        checkList.add(Objects::nonNull);
        return this;
    }
}
