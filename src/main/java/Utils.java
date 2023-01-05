import org.apache.commons.lang3.RandomStringUtils;

public class Utils {

    public static String getFirstName(){
        String randomString = RandomStringUtils.randomAlphanumeric(3);
        return "John"+randomString;
    }

    public static String getJob(){
        String randomString = RandomStringUtils.randomAlphanumeric(3);
        return "Dev"+randomString;
    }

    public static String getAge(){
        return RandomStringUtils.randomNumeric(2);
    }

    public static String getSalary(){
        return RandomStringUtils.randomNumeric(6);
    }

}
