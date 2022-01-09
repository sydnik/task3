package framework.utils;


import java.time.DateTimeException;
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

    public static LocalDateTime getNearestDay(LocalDateTime time,int whatMonth, int whatDay){
        LocalDateTime thisYear = getNearestThisYear(time,whatMonth,whatDay);
        LocalDateTime nextTime = getNextNearestYears(time,whatMonth,whatDay);
        LocalDateTime previousTime = getPreviousNearestYears(time,whatMonth,whatDay);
        long thisYearMs;
        if(thisYear==null){
            thisYearMs =Long.MAX_VALUE;
        }
        else {
            thisYearMs = getDifferenceBetweenTime(time,thisYear);
        }
        long previousYearMs = getDifferenceBetweenTime(previousTime,time);
        long nextYearMs = getDifferenceBetweenTime(nextTime,time);
        if(previousYearMs>=thisYearMs&&thisYearMs<=nextYearMs){
            return thisYear;
        }
        else if(thisYearMs>=previousYearMs&&previousYearMs<=nextYearMs){
            return previousTime;
        }
        else {
            return nextTime;
        }

    }

    public static LocalDateTime getNearestThisYear(LocalDateTime time, int month, int day){
        LocalDateTime thisYear = null;
        try {
            thisYear = LocalDateTime.of(time.getYear(),month,day,12,0);
        }catch (DateTimeException e){
            if(!e.getMessage().endsWith("leap year")){
                throw e;
            }
        }
        return thisYear;
    }

    public static LocalDateTime getNextNearestYears(LocalDateTime time, int month, int day){
        int i =1;
        while (true){
            try {
                return LocalDateTime.of(time.getYear()+i,month,day,12,0);
            }catch (DateTimeException e ){
                if(!e.getMessage().endsWith("leap year")){
                    throw e;
                }
                i++;
            }
        }
    }

    public static LocalDateTime getPreviousNearestYears(LocalDateTime time, int month, int day){
        int i =1;
        while (true){
            try {
                return LocalDateTime.of(time.getYear()-i,month,day,12,0);
            }catch (DateTimeException e ){
                if(!e.getMessage().endsWith("leap year")){
                    throw e;
                }
                i++;
            }
        }
    }

    public static long getDifferenceBetweenTime(LocalDateTime time1,LocalDateTime time2){
        return Math.abs(getLongTime(time1)-getLongTime(time2));
    }
    public static long getLongTime(LocalDateTime localDateTime){
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}

