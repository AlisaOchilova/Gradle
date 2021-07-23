package homework8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestsRegex {
    public static boolean checkLogin(String login){
        Pattern pattern = Pattern.compile("^.{1,6}$");
        Matcher matcher = pattern.matcher(login);
        return matcher.find();
    }
}
