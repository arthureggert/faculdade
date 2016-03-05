package br.edu.furb.agendamento.util.date;

import java.util.Date;

/**
 * Uma classe para manipular datas.<br>
 * Utiliza os seguintes tipos.<br>
 * <br>
 * <code><b>Tipo singular. </b>Utilizado principalmente para montar datas.<br>
 * <b>ex: </b>getDate(short year, int month, int day)</code><br>
 * <code>short year</code> - ano<br>
 * <code>int month</code> - mes<br>
 * <code>int day</code> - dia<br>
 * <code>int hour</code> - hora<br>
 * <code>int minute</code> - minuto<br>
 * <code>long second</code> - segundo<br>
 * <code>long milli</code> - milisegundo<br>
 * <br>
 * <code><b>Tipo plural: </b>Utilizado em operacoes artimeticas.
 * <br><b>ex: </b>addYearsToMonths(int dateInMonths, <b>int years</b>)<br>
 * <code>short years</code> - quantidade de anos<br>
 * <code>int months</code> - quantidade de meses<br>
 * <code>int days</code> - quantidade de dias<br>
 * <code>int hours</code> - quantidade de horas<br>
 * <code>int minutes</code> - quantidade de minutos<br>
 * <code>long seconds</code> - quantidade de segundos<br>
 * <code>long millis</code> - quantidade de milisegundos<br>
 * <br>
 * <code><b>Tipos de data: </b>Equivale a uma data com a precisao do tipo especificado. Vale a quantidade do tipo (horas/minutos/etc) a partir da data <b>01-jan-1970</b>.</code>
 * <br>
 * <b>ex: </b>addYearsToMonths(<b>int dateInMonths</b>, int years)<br>
 * <code>short dateInYears</code> - data em anos<br>
 * <code>int dateInMonths</code> - data em meses<br>
 * <code>int Date</code> - data em dias<br>
 * <code>int dateInHours</code> - data em horas<br>
 * <code>int dateInMinutes</code> - data em minutos<br>
 * <code>long dateInSeconds</code> - data em segundos<br>
 * <code>long dateInMillis</code> - data em milisegundos<br>
 * 
 * 
 */
public final class GregorianDates extends Dates {

    private GregorianDates() {
    }

    public static long floorDivisionL(long dividend, long divisor) { //ok
        return (long) Math.floor(dividend / (double) divisor);
    }

    /**
     * Converte uma data com precisao de milisegundos para uma data com precisao de horas.<br>
     * Ambas contam a partir de 01-jan-1970.
     * 
     * @param dateInMillis
     * @return
     */
    public static long millisToHours(Long dateInMillis) {
        return floorDivisionL(dateInMillis.longValue(), MSEC_PER_HOUR);
    }

    /**
     * Converte uma data com precisao de milisegundos para uma data com precisao de minutos.<br>
     * Ambas contam a partir de 01-jan-1970.
     * 
     * @param dateInMillis
     * @return
     */
    public static long millisToMinutes(Long dateInMillis) {
        return floorDivisionL(dateInMillis.longValue(), MSEC_PER_MINUTE);
    }

    /**
     * Converte uma data com precisao de milisegundos para uma data com precisao de segundos.<br>
     * Ambas contam a partir de 01-jan-1970.
     * 
     * @param dateInMillis
     * @return
     */
    public static long millisToSeconds(long dateInMillis) {
        return floorDivisionL(dateInMillis, MSEC_PER_SECOND);
    }

    /**
     * Converte uma data com precisao de horas para uma data com precisao de milisegundos.<br>
     * Ambas contam a partir de 01-jan-1970.
     * 
     * @param dateInHours
     * @return
     */
    public static long hoursToMillis(Long dateInHours) {
        return dateInHours * MSEC_PER_HOUR;
    }

    /**
     * Converte uma data com precisao de minutos para uma data com precisao de milisegundos.<br>
     * Ambas contam a partir de 01-jan-1970.
     * 
     * @param dateInMinutes
     * @return
     */
    public static long minutesToMillis(Long dateInMinutes) {
        return dateInMinutes * MSEC_PER_MINUTE;
    }

    /**
     * Converte uma data com precisao de segundos para uma data com precisao de milisegundos.<br>
     * Ambas contam a partir de 01-jan-1970.
     * 
     * @param date
     * @param years
     * @return
     */
    public static long secondsToMillis(long dateInSeconds) {
        return dateInSeconds * MSEC_PER_SECOND;
    }

    public static String dateToTime(Date date) {
        long executionTime = System.currentTimeMillis() - date.getTime();
        Long hour = GregorianDates.millisToHours(executionTime);
        executionTime = executionTime - GregorianDates.hoursToMillis(hour);
        Long minutes = GregorianDates.millisToMinutes(executionTime);
        executionTime = executionTime - GregorianDates.minutesToMillis(minutes);
        Long seconds = GregorianDates.millisToSeconds(executionTime);
        return formatNumberToDate(hour) + ":" + formatNumberToDate(minutes) + ":" + formatNumberToDate(seconds);
    }

    public static String formatNumberToDate(Long number) {
        return (number >= 10 ? number.toString() : "0" + number);
    }

}
