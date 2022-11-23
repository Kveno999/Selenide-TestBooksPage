package generalutils;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@UtilityClass
public class StringUtils {

    public static boolean areStringsFilled(List<String> strings) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        for (String s : strings) {
            if (s.isEmpty()) {
                atomicBoolean.set(false);
                break;
            }
        }
        return atomicBoolean.get();
    }

}
