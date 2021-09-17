package homework9.pojo;

import homework9.Address;
import org.apache.commons.lang3.RandomStringUtils;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Root
public class User implements Serializable {
    @Element
    private String name; //фио
    @Element
    private String birthday; // Дата в виде года 1991-01-01
    @Element
    private String registrationDate; //Дата в виде 2020-01-01Т00:00:00
    @Element
    private String login; //6 знаков алфавитно-числовой на латинице
    @Element
    private String password;//10 знаков алфавитно-числовой на латинице
    @Element
    private Address direction;

    public User() {
        this.name = generateRandomName();
        this.birthday = birthDateGenerator();
        this.registrationDate = generateRegistrationDate();
        this.login = generateRandomLogin(6);
        this.password = generateRandomPassword(10);
        this.direction = new Address();
    }

    public void setDirection(Address direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction.toString();
    }

    public List<User> getGenerateUsers(int count){
        List<User> users = new ArrayList<>(Collections.emptyList());
        for (int i=1; i<=count; i++)
            users.add(new User());
        return users;
    }

    public String  getName(){
        return name;
    }



    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", birthDay=" + birthday +
                ", registrationDate=" + registrationDate +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    public String birthDateGenerator(){
        LocalDate start = LocalDate.now().minus(102, ChronoUnit.YEARS);
        LocalDate end = LocalDate.now();
        long days = start.until(end, ChronoUnit.DAYS);
        long randomDays = ThreadLocalRandom.current().nextLong(days + 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return start.plusDays(randomDays).format(formatter);
    }

    public String generateRandomName(){
        String[] root = {"Богдан", "Гончар", "Мельник", "Сидор",  "Петр", "Герасим", "Лис", "Александр", "Тихон"};
        String [] suf = {"ов", "ев", "ёв", "ын", "инский", "ицкий", "ый", "ой"};
        String [] sof = {"ович", "овна"};
        return root[new Random().nextInt(root.length)] +
                root[new Random().nextInt(root.length)] + sof[new Random().nextInt(sof.length)] +
                root[new Random().nextInt(root.length)] + suf[new Random().nextInt(suf.length)];
    }



    public String generateRegistrationDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDateTime.now().format(formatter);
    }

    public String generateRandomLogin(int count){
        Random rand = new Random();
        return RandomStringUtils.randomAlphabetic(rand.nextInt((count) + 1));
    }

    public String generateRandomPassword(int count) {

        String CHAR_LOWERCASE = "йцукенгшщзхъфывапролджэячсмитьбю";
        String CHAR_UPPERCASE = CHAR_LOWERCASE.toUpperCase();
        String DIGIT = "0123456789";
        String SPECIALS = "!@#&()–[{}]:;',?/*~$^+=<>";
        StringBuffer password = new StringBuffer(count);

        int i = 1;
        while (i < count) {
            if (i % 2 == 0)
                password.append(CHAR_LOWERCASE.charAt(new Random().nextInt(CHAR_LOWERCASE.length())));
            else
                password.append(CHAR_UPPERCASE.charAt(new Random().nextInt(CHAR_UPPERCASE.length())));
            i++;
        }
        password.setCharAt(new Random().nextInt(password.length()), DIGIT.charAt(new Random().nextInt(DIGIT.length())));
        password.append(SPECIALS.charAt(new Random().nextInt(SPECIALS.length())));

        return password.toString();
    }



}
