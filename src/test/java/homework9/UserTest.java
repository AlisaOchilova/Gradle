package homework9;

import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

public class UserTest {
    public static void main(String[] args) {
        List<User> users = User.generateUsers(10);
//        Writer writer = new FileWriter();

        WritingToFile writer = new WritingToFile();
        writer.writeUsersToFile(users);
        writer.writeAddressToFile(users);
    }
}
