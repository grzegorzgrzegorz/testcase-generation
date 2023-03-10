package utils;

import com.google.common.io.Resources;
import com.google.gson.Gson;
import core.DslGenerator;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {

    public static JSONObject getParsedJson(String fileName) {
        Path path = null;
        try {
            Path targetPath = Paths.get(Resources.getResource("").toURI()).getParent();
            path = Paths.get(targetPath.toString(), "/test-classes/", fileName);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        String json = null;
        try {
            json = Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new JSONObject(json);
    }

    public static DslGenerator getDeserializedInstance(String varName, JSONObject jsonObject) {
        Class cls = getClassFromVarName(varName);
        String className = jsonObject.get(varName).toString();
        return new Gson().fromJson(className, (Type) cls);
    }

    private static Class getClassFromVarName(String varName) {
        try {
            if (varName.contains(".")) {
                varName = varName.split("\\.")[1];
            }
            return Class.forName("class_under_test_dsl." + varName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
