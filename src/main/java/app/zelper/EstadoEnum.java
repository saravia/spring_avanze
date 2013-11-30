package app.zelper;

import java.util.HashMap;
import java.util.Map;

public enum EstadoEnum {

    ACTIVO(1), INACTIVO(0);
    
    private final Integer value;
    private static final Map<Integer, EstadoEnum> lookup = new HashMap<Integer, EstadoEnum>();

    static {
        for (EstadoEnum d : EstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static EstadoEnum get(Integer abbreviation) {
        return lookup.get(abbreviation);
    }
}
