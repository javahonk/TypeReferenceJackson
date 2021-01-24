package javahonk.util;

/**
 * @author Javahonk 1/24/2021 1:38 PM
 */
public interface BaseEnum<T> {

    T getCode();
    String getName();

    static <T extends BaseEnum> T resolve(String name, T values[]) {
        if (name == null) return null;

        for (T n : values) {
            if (String.valueOf(n.getCode()).equals(name) || n.getName().equalsIgnoreCase(name)) {
                return n;
            }
        }
        return null;
    }

    static <T extends BaseEnum> boolean validateMultiValue(String name, T values[]) {
        if (name == null) return false;
        String[] splitedValue = name.split("\\st");

        for (String value : splitedValue) {
            T result = null;
            for (T n : values) {
                if (String.valueOf(n.getCode()).equals(value) || n.getName().equalsIgnoreCase(value)) {
                    result = n;
                    break;
                }
            }
            if (result == null) {
                return false;
            }
        }
        return true;
    }
}
