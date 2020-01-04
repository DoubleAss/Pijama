package doubleAss.pijama.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DatetimeUtil {

    private static final String FORMAT_1 = "yyyy-MM-dd HH:mm:ss";
    private static final String FORMAT_2 = "dd-MM-yyyy HH:mm:ss";

    public static String convertToString(LocalDateTime datetime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return datetime.format(formatter);
    }

    public static String getSystemDateTimeSave() {
        return convertToString(LocalDateTime.now(), FORMAT_1);
    }
    
    public static String getSystemDateTime() {
        return convertToString(LocalDateTime.now(), FORMAT_2);
    }

}
