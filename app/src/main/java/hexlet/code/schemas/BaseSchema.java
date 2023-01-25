package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public abstract class BaseSchema {
    protected boolean optional = true;
    private final List<Predicate<Object>> checkList = new ArrayList<>();

    protected final void addCheck(Predicate<Object> check) {
        checkList.add(check);
    }

    public final boolean isValid(final Object object) {
        return Objects.isNull(object)
                ? optional
                : checkList.stream().allMatch(pre -> pre.test(object));
    }
}
