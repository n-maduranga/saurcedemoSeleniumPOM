package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String getTimestamp(){
        return new SimpleDateFormat("yyyyMMddHHmmss").format((new Date()));
    }
}
