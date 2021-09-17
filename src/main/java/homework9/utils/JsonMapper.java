package homework9.utils;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Moshi.Builder;

import java.io.Serializable;
import java.lang.reflect.Type;


public class JsonMapper <T extends Serializable> implements Mapper<T> {
    Moshi moshi = (new Builder()).build();
    private final T object;

    public String serialize() {
        JsonAdapter<T> jsonAdapter = this.moshi.adapter((Type) this.object.getClass());
        return jsonAdapter.toJson(this.object);
    }

    public T deserialize(String string) throws Exception {
        try {
            JsonAdapter<T> jsonAdapter = this.moshi.adapter((Type) this.object.getClass());
            return (T) jsonAdapter.fromJson(string);
        } catch (Exception var3) {
            throw new Exception();
        }
    }

    public JsonMapper(T object) {
        this.object = object;
    }
}
