package framework.utils;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateUtil {
    public static String getTimeAndDate(String patternDateAndTime){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(patternDateAndTime, Locale.forLanguageTag(ConfigUtil.getConfProperty("language")));
        return LocalDateTime.now().format(dateFormat);
    }

    public static String getTimeAndDate(LocalDateTime date, String patternDateAndTime){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(patternDateAndTime, Locale.forLanguageTag(ConfigUtil.getConfProperty("language")));
        return date.format(dateFormat);
    }

    public static LocalDateTime getNearest29February(LocalDateTime date){
        if(isLeapYear(date.getYear())){
            return LocalDateTime.of(date.getYear(),2,29,12, 0);
        }
        LocalDateTime dateNext29February = LocalDateTime.of(getNextLeapYear(date.getYear()),2,29,12,0);
        LocalDateTime datePrevious29February = LocalDateTime.of(getPreviousLeapYear(date.getYear()),2,29,12,0);
        long timePrevious = DateUtil.getLongTime(date) - DateUtil.getLongTime(datePrevious29February);
        long timeNext = DateUtil.getLongTime(dateNext29February) - DateUtil.getLongTime(date) ;
        if(timeNext<=timePrevious )
        {
            return dateNext29February;
        }else {
            return datePrevious29February;
        }
    }

    public static int getNextLeapYear(int year){
        int i = 1;
        while (true){
            if(isLeapYear(year+i)){
                return year+i;
            }
            else {
                i++;
            }
        }
    }

    public static int getPreviousLeapYear(int year){
        int i = 1;
        while (true){
            if(isLeapYear(year-i)){
                return year-i;
            }
            else {
                i++;
            }
        }
    }

    public static boolean isLeapYear(int year){
        if(year%4==0&&year%100!=0){
            return true;
        }
        else return year % 400 == 0;
    }
    public static long getLongTime(LocalDateTime localDateTime){
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}

