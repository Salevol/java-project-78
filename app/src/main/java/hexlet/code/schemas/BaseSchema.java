package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public abstract class BaseSchema {
    protected boolean notRequired = true;
    protected List<Predicate<Object>> checkList = new ArrayList<>();
    protected Map<String, BaseSchema> schema = new HashMap<>();

    protected final void addCheck(Predicate check) {
        checkList.add(check);
    }

    public final boolean isValid(final Object object) {
        if (Objects.isNull(object)) {
            return notRequired;
        }
        return checkList.stream().allMatch(pre -> pre.test(object));
    }
}
