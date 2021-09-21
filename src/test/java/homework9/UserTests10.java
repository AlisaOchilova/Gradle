package homework9;

import homework9.pojo.User;
import homework9.utils.JsonMapper;
import homework9.utils.Mapper;
import homework9.utils.XMLMapper;
import homework9.pojo.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class UserTests10 {
    User user = new User();
    List<User> userList = Arrays.asList(new User(), new User(), new User(), new User());
    Users users;

    public UserTests10() {
        this.users = new Users(this.userList);
    }

    @Test
    void userXML() throws Exception {
        Mapper<User> mapper = new XMLMapper(this.user);
        String userString = mapper.serialize();
        User deserialized = (User)mapper.deserialize(userString);
        System.out.println(userString);
        Assertions.assertEquals(this.user.toString(), deserialized.toString());
    }

    @Test
    void userJSON() throws Exception {
        Mapper<User> mapper = new JsonMapper(this.user);
        String jsonString = mapper.serialize();
        User deserialized = (User) mapper.deserialize(jsonString);
        Assertions.assertEquals(this.user.toString(), deserialized.toString());
    }

    @Test
    void userListXML() throws Exception {
        Mapper<Users> mapper = new XMLMapper(this.users);
        String userListString = mapper.serialize();
        Users deserialized = (Users)mapper.deserialize(userListString);
        System.out.println(userListString);
        Assertions.assertEquals(4, deserialized.getUsers().size());
    }

    @Test
    void userListJSON() throws Exception {
        Mapper<Users> mapper = new JsonMapper(this.users);
        String jsonString = mapper.serialize();
        Users deserialized = (Users)mapper.deserialize(jsonString);
        System.out.println(jsonString);
        Assertions.assertEquals(4, deserialized.getUsers().size());
    }
}
