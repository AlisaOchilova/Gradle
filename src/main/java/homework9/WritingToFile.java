package homework9;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WritingToFile {
    private final File usersFile = new File("C:/Users/a.ochilova/IdeaProjects/HomeworkGradle/users.txt");
    private final File addressFile = new File("C:/Users/a.ochilova/IdeaProjects/HomeworkGradle/users.txt");

    public void writeUsersToFile(List<User> users){
        try {
            FileWriter fw = new FileWriter(usersFile);
            users.forEach(user -> {
                try {
                    fw.write(user.toString() + System.lineSeparator());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            fw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeAddressToFile(List<User> users)  {
        FileWriter fw = null;
        try {
            fw = new FileWriter(addressFile);
            for (User user : users) {
                user.setDirection(new Address());
                try {
                    fw.write(user.getName() + user.getDirection() + System.lineSeparator());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
