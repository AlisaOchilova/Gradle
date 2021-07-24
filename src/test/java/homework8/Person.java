package homework8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class Person extends User{

    User person = new User("/", "1900-01-01", LocalDateTime.now(), ".", "''");

    @Test
    void testLogin() {
        Assertions.assertFalse(UserTests.checkLogin(person.getLogin())); //вопрос
    }

    @Test
    public void testName() {
        Assertions.assertFalse(UserTests.checkName(person.getName()));
    }

    @Test
    public void testPassword(){
        Assertions.assertFalse(UserTests.checkPassword(person.getPassword()));
    }

}
