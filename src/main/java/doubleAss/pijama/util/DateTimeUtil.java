package doubleAss.pijama.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class DateTimeUtil {

    private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * Convert date time to string
     * @param dateTime
     * @return
     */
    public static String convertToString(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);
        return Objects.nonNull(dateTime) ? dateTime.format(formatter) : null;
    }

}
