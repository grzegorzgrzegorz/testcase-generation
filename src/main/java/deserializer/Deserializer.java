package deserializer;

import com.google.gson.Gson;
import org.json.JSONObject;
import some_class_dsl.Capitals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Deserializer {

    public static void main(String[] args) throws URISyntaxException {
        new Deserializer();
    }

    public Deserializer() throws URISyntaxException {
        deserialize();
    }

    public void deserialize() throws URISyntaxException {
        try {
            Path path = Paths.get(this.getClass().getClassLoader().getResource("example.json").toURI());
            String json = Files.readString(path);

            JSONObject jsonObject = new JSONObject(json);
            String serializedClass = jsonObject.get("InputContent.Capitals").toString();


            Capitals instance = new Gson().fromJson(serializedClass, Capitals.class);
            System.out.println(instance);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
