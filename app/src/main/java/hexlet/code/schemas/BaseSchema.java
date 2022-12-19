package hexlet.code.schemas;

interface BaseSchema {
    Boolean isValid(Object object);
    void required();
}
