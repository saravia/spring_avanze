package app.zelper;

import java.util.HashMap;
import java.util.Map;

public enum RolesEnum {

    ADMIN("ADMIN"), SOCIO("SOCIO");
    
    private final String value;
    private static final Map<String, RolesEnum> lookup = new HashMap<String, RolesEnum>();

    static {
        for (RolesEnum d : RolesEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private RolesEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RolesEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }
}
