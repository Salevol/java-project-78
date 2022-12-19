package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;

public class StringSchema implements BaseSchema {
    private boolean isRequired;
    private int minLength;
    private List<String> containsList = new ArrayList<>();

    public StringSchema() {
        this.isRequired = false;
    }

    public void required() {
        this.isRequired = true;
    }

    public StringSchema contains(String str) {
        this.containsList.add(str);
        return this;
    }

    @Override
    public Boolean isValid(final Object object) {
        if (object == null || object.equals("")) {
            return isRequired ? false : true;
        }
        if (!(object instanceof String)) {
            return false;
        }
        String str = (String) object;
        if (str.length() < minLength) {
            return false;
        }
        if (!containsAllInList(str)) {
            return false;
        }
        return true;

    }

    public void setMinLength(int length) {
        this.minLength = length;
    }

    private Boolean containsAllInList(String str) {
        for (String s: containsList) {
            if (!str.contains(s)) {
                return false;
            }
        }
        return true;
    }
}
