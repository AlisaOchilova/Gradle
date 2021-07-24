package homework8;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static homework8.User.*;
import static org.apache.commons.lang3.Validate.matchesPattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTests {

    User user = new User();

    public static boolean checkLogin(String login) {
        Pattern pattern = Pattern.compile("^.{1,6}$");
        Matcher matcher = pattern.matcher(login);
        return matcher.find();
    }

    @Test
    void testLogin() {
        Assertions.assertTrue(UserTests.checkLogin(user.getLogin()));
    }

    public static boolean checkName(String name) {
        Pattern pattern = Pattern.compile("[\u0401\u0451\u0410-\u044f]{1,3}");
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }

    @Test
    public void testName() {
        Assertions.assertTrue(UserTests.checkName(user.getName()));
    }

    public static boolean checkPassword(String password){
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[\u0401\u0451\u0410-\u044f])(?=.*[!@#&()–\\[{}\\]!@#&()–[{}]:;',?/*~$^+=<>]).{10}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    @Test
    public void testPassword(){
        Assertions.assertTrue(UserTests.checkPassword(user.getPassword()));
    }
}







