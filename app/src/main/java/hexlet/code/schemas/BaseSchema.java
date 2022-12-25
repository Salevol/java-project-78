package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public abstract class BaseSchema<T extends BaseSchema<T>> {
    protected List<Predicate<Object>> checkList = new ArrayList<>();
    protected Map<String, BaseSchema> schema = new HashMap<>();

    public final boolean isValid(final Object object) {
        if (schema.isEmpty()) {
            return checkList.stream().allMatch(pre -> pre.test(object));
        }
        Map<String, Object> map = (Map) object;
        return map.entrySet().stream()
                   .allMatch(e -> this.schema.get(e.getKey()).isValid(e.getValue()));
    }

    public final T required() {
        checkList.add(o -> !(Objects.isNull(o) || o.toString().isEmpty()));
        return (T) this;
    }
}
