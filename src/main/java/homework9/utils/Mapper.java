package homework9.utils;

import java.io.Serializable;

public interface Mapper<T extends Serializable> {
    String serialize() throws Exception;

    T deserialize(String var1) throws Exception;
}
