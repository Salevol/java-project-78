package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public class MapSchema extends BaseSchema {
    private Map<String, BaseSchema> schema = new HashMap<>();

    public MapSchema() {
        checkList.add(o -> (o instanceof Map) || (o == null));
    }

    public MapSchema sizeof(int minSize) {
        checkList.add(o -> ((o != null) && ((Map) o).size() >= minSize));
        return this;
    }

    public void shape(Map<String, BaseSchema> schemas) {
        this.schema = schemas;
    }

    @Override
    public boolean isValid(final Object object) {
        if (schema.isEmpty()) {
            return super.isValid(object);
        }
        Map<String, Object> map = (Map) object;
        return map.entrySet().stream()
                .allMatch(e -> this.schema.get(e.getKey()).isValid(e.getValue()));
    }
}
