package homework9.utils;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class XMLMapper<T extends Serializable> implements Mapper<T> {
    private final Serializer serializer = new Persister();
    private final File file = new File("outputs/output.xml");
    private final T object;

    public String serialize() throws Exception {
        try {
            this.serializer.write(this.object, this.file);
            return Files.readString(this.file.toPath(), StandardCharsets.UTF_8);
        } catch (Exception var2) {
            throw new Exception();
        }
    }

    public T deserialize(String string) throws Exception {
        Persister serializer = new Persister();

        try {
            return (T) serializer.read(this.object.getClass(), string);
        } catch (Exception var4) {
            throw new Exception();
        }
    }

    public XMLMapper(T object) {
        this.object = object;
    }
}
