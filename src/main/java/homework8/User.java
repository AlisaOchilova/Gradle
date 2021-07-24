package homework8;

import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class User {
    public String name; //фио
    public String birthDay; // Дата в виде года 1991-01-01
    public LocalDateTime registrationDate; //Дата в виде 2020-01-01Т00:00:00
    public String login; //6 знаков алфавитно-числовой на латинице
    public String password;//10 знаков алфавитно-числовой на латинице

    public User(String name, String  birthDay, LocalDateTime registrationDate, String login, String password) {
        this.name = name;
        this.birthDay = birthDay;
        this.registrationDate = registrationDate;
        this.login = login;
        this.password = password;
    }

    public User() {
        name = generateRandomName();
        birthDay = generateRandomDate();
        registrationDate = generateRandomRegistrationDate();
        login = generateRandomLogin(6);
        password = generateRandomPassword(10);
    }

    public String  getName(){
        return name;
    }

    public String  getBirthDay(){
        return birthDay;
    }

    public LocalDateTime getRegistrationDate(){
        return registrationDate;
    }

    public String  getLogin(){
        return login;
    }

    public String  getPassword(){
        return password;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", registrationDate=" + registrationDate +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }



    public String generateRandomDate(){
        LocalDate from = LocalDate.of(1919, 1, 1);
        LocalDate to = LocalDate.of(2021, 1, 1);
        long days = from.until(to, ChronoUnit.DAYS);
        long randomDays = ThreadLocalRandom.current().nextLong(days + 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return from.plusDays(randomDays).format(formatter);
    }

    public String generateRandomName(){
        String[] root = {"Богдан", "Гончар", "Мельник", "Сидор",  "Петр", "Герасим", "Лис", "Александр", "Тихон"};
        String [] suf = {"ов", "ев", "ёв", "ын", "инский", "ицкий", "ый", "ой"};
        String [] sof = {"ович", "овна"};
        return root[new Random().nextInt(root.length)] +
                root[new Random().nextInt(root.length)] + sof[new Random().nextInt(sof.length)] +
                root[new Random().nextInt(root.length)] + suf[new Random().nextInt(suf.length)];
    }



    public LocalDateTime generateRandomRegistrationDate(){
       return  LocalDateTime.now();
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


