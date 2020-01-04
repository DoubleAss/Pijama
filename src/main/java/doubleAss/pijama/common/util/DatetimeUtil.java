package doubleAss.pijama.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;


public class DatetimeUtil {

    private static final String FORMAT_EN = "yyyy-MM-dd HH:mm:ss";
    private static final String FORMAT_VN = "dd-MM-yyyy HH:mm:ss";

    public static String convertToString(LocalDateTime datetime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return datetime.format(formatter);
    }

    public static String getSystemDateTimeSave() {
        return convertToString(LocalDateTime.now(), FORMAT_EN);
    }
    
    public static String getSystemDateTime() {
        return convertToString(LocalDateTime.now(), FORMAT_VN);
    }

    public static LocalDateTime convertToDateTime(String datetime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_EN);
        return LocalDateTime.parse(datetime, formatter);
    }
    
    public static String displaySystemDate(String datetime) {
        return Optional.ofNullable(datetime)
                .map(dt -> convertToString(convertToDateTime(dt), FORMAT_VN))
                .orElse(null);
    }
}
