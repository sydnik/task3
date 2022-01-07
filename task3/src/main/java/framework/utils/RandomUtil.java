package framework.utils;

import org.apache.commons.lang.RandomStringUtils;

public class RandomUtil {
    public static String randomText(){
        return RandomStringUtils.randomAlphabetic((int) (Math.random()*100));
    }
    public static String randomText(int size){
        return RandomStringUtils.randomAlphabetic(size);
    }
    public static int randomNumber(int min,int max){
        return (int) (Math.random()*(max- min)- min);
    }
}
