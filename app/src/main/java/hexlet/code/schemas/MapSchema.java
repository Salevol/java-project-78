package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {


    public MapSchema() {
        addCheck(o -> (o instanceof Map));
    }

    public MapSchema sizeof(int minSize) {
        addCheck(o -> (((Map) o).size() >= minSize));
        return this.required();
    }

    public MapSchema required() {
        this.notRequired = false;
        return this;
    }

    public void shape(Map<String, BaseSchema> schemas) {
        schemas.entrySet().stream()
                .forEach(e -> addCheck(o -> e.getValue().isValid(((Map) o).get(e.getKey()))));
    }
}
