package homework9;


import java.util.Random;

public class Address {
    public String city;
    public String street;
    public String house;
    public int appartment;
    public Random random = new Random();

    public Address() {
        String[] cities = {"Москва", "Санкт-Петербург", " Новосибирск", "Екатеринбург", "Казань", "Нижний Новгород", "Челябинск"};
        String[] streets = {"Ветеранов", "Буденного", "Генерала Кравченко", "Адмирала Трибуца", "Пионерстроя", "Херсонская", "Восстания"};
        String[] houses = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        this.city = getRandomString(cities);
        this.street = getRandomString(streets);
        this.house = getRandomString(houses);
        this.appartment = getRandomInt(10);
    }

    public String getRandomString(String[] array) {
        return array[random.nextInt(array.length)];
    }

    public int getRandomInt(int maxValue) {
        return random.nextInt(maxValue) + 1;
    }

    @Override
    public String toString() {
        return String.format( " %s,%s,%s,%s",city, street, house, appartment);
    }
}
