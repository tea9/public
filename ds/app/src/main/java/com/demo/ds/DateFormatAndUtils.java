package com.demo.ds;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <pre>
 *  时间辅助类
 *  LocalDate ,LocalDateTime,LocalTime, Date 之间的互转
 * </pre>
 */
public class DateFormatAndUtils {

    public final static String DEFAULT_FOMAT_TIMS = "yyyy-MM-dd HH:mm:ss";

    public final static String DEFAULT_FOMAT_DAY = "yyyy-MM-dd";






    /**
     *  String -> Date
     * @param dateStr 时间字符串 2017-04-18
     * @param pattern 字符串格式 如 yyyy-MM-dd
     * @return Date
     */
    public static Date parseToDate(String dateStr, String pattern) {
        Date date = null;
        try {
            date = new SimpleDateFormat(pattern).parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException( "时间格式化错误 字符串[" + dateStr + "],格式{" + pattern + "}");
        }
        return date;
    }


}
