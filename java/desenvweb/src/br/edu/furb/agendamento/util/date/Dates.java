package br.edu.furb.agendamento.util.date;

import java.util.TimeZone;

public class Dates {

    public static final String TIME_ZONE = "GMT";
    public static final long MSEC_PER_SECOND = 1000;
    public static final long MSEC_PER_MINUTE = 60 * MSEC_PER_SECOND;
    public static final long MSEC_PER_HOUR = 60 * MSEC_PER_MINUTE;
    public static final long MSEC_PER_DAY = 24 * MSEC_PER_HOUR;
    public static final long MSEC_PER_WEEK = 7 * MSEC_PER_DAY;

    public static final long SEC_PER_MINUTE = 60;
    public static final long SEC_PER_HOUR = 60 * SEC_PER_MINUTE;
    public static final long SEC_PER_DAY = 24 * SEC_PER_HOUR;
    public static final long SEC_PER_WEEK = 7 * SEC_PER_DAY;

    public static final long MIN_PER_HOUR = 60;
    public static final long MIN_PER_DAY = 24 * MIN_PER_HOUR;
    public static final long MIN_PER_WEEK = 7 * MIN_PER_DAY;

    public static final long HOUR_PER_DAY = 24;
    public static final long HOUR_PER_WEEK = 7 * HOUR_PER_DAY;

    public static final long DAY_PER_WEEK = 7;

    public static final long MONTHS_PER_YEAR = 12;
    public static final long MONTH_PER_YEAR = MONTHS_PER_YEAR;

    public static final TimeZone JAVA_TIME_ZONE = TimeZone.getTimeZone(TIME_ZONE);

    public static double AVG_DAYS_PER_YEAR = 365.2425;

    public static final long AVG_MSEC_PER_YEAR = (long) (AVG_DAYS_PER_YEAR * Dates.MSEC_PER_DAY);
    public static final long AVG_MSEC_PER_MONTH = AVG_MSEC_PER_YEAR / MONTHS_PER_YEAR;

    public static final long AVG_SEC_PER_YEAR = (long) (AVG_DAYS_PER_YEAR * Dates.SEC_PER_DAY);
    public static final long AVG_SEC_PER_MONTH = AVG_SEC_PER_YEAR / MONTHS_PER_YEAR;

    public static final double AVG_MIN_PER_YEAR = AVG_DAYS_PER_YEAR * Dates.MIN_PER_DAY;
    public static final double AVG_MIN_PER_MONTH = AVG_MIN_PER_YEAR / MONTHS_PER_YEAR;

    public static final double AVG_HOUR_PER_YEAR = AVG_DAYS_PER_YEAR * Dates.HOUR_PER_DAY;
    public static final double AVG_HOUR_PER_MONTH = AVG_HOUR_PER_YEAR / MONTHS_PER_YEAR;

    public static final double AVG_DAY_PER_YEAR = AVG_DAYS_PER_YEAR;
    public static final double AVG_DAY_PER_MONTH = AVG_DAY_PER_YEAR / MONTHS_PER_YEAR;

}
