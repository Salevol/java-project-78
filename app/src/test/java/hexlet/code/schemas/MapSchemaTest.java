package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MapSchemaTest {
    private Validator v = new Validator();
    private MapSchema schema;
    private static Map<Object, Object> mapOneValue;
    private static Map<Object, Object>  mapSeveralValues;
    private static Map<Object, Object> emptyMap = new HashMap<>();



    @BeforeAll
    static void preset() {
        mapOneValue = Map.of("k1", "v1");
        mapSeveralValues = Map.of("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
    }

    @BeforeEach
    void reset() {
        this.schema = v.map();
    }

    @Test
    void required() {
        assertTrue(schema.isValid(null));
        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(emptyMap));
    }

    @Test
    void sizeof() {
        assertTrue(schema.isValid(mapOneValue));
        schema.sizeof(3);
        assertFalse(schema.isValid(mapOneValue));
        assertTrue(schema.isValid(mapSeveralValues));
        assertFalse(schema.isValid(null));
    }

    @Test
    void isValid() {
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(emptyMap));
        assertTrue(schema.isValid(mapSeveralValues));
        assertFalse(schema.isValid("Not a map"));
    }
}
