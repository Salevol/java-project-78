package hexlet.code.schemas;

import java.util.Map;

public class MapSchema implements BaseSchema {
    private boolean isRequired;
    private int size;

    public MapSchema() {
        this.isRequired = false;
    }

    @Override
    public void required() {
        this.isRequired = true;
    }

    public void sizeof(int minSize) {
        this.size = minSize;
    }

    @Override
    public Boolean isValid(Object object) {
        if (object == null && !isRequired && size == 0) {
            return true;
        }
        return (object instanceof Map) && (((Map<?, ?>) object).size() >= size);
    }
}
