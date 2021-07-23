package homework8;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static homework8.User.*;
import static org.apache.commons.lang3.Validate.matchesPattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTests {

    User user = new User();

    @Test
    void testLogin(){
        Assertions.assertTrue(TestsRegex.checkLogin(user.generateRandomLogin()));
    }

}
