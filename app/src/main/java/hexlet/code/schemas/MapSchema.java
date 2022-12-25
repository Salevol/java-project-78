package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<MapSchema> {


    public MapSchema() {
        checkList.add(o -> (o instanceof Map) || (o == null));
    }

    public MapSchema sizeof(int minSize) {
        checkList.add(o -> ((o != null) && ((Map) o).size() >= minSize));
        return this;
    }

    public void shape(Map<String, BaseSchema> schemas) {
        super.schema = schemas;
    }
}
