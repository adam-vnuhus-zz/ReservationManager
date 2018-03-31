import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class ConvertJson {
    private static Gson gson = new GsonBuilder().create();

    public static final Map<String,Information> getFromJSON(String path) throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        Type type = new TypeToken<Map<String, Information>>(){}.getType();
        return gson.fromJson(bufferedReader, type);
    }

    public static final void toJSON(Map clazz,String path) {
        try {
            Writer writer = new FileWriter(path);
            Gson gson = new GsonBuilder().create();
            gson.toJson(clazz, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
