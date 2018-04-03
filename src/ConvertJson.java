import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class ConvertJson {

    private static Gson gson = new GsonBuilder().create();
    
    // Truyền vào path, Lấy ra đc một List<Information> ra từ file JSON. 
    // Từ list này có thể lấy ra được list client, cashPayment, creditPayment,resNumber 
    public static List<Information> getFromJSON(String path) throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        Type type = new TypeToken<List<Information>>(){}.getType();
        return gson.fromJson(bufferedReader, type);
    }
    
    // Để ghi dữ liệu ra file JSON cần truyền vào một List<Information>, path 
    public static void toJSON(List clazz, String path) {
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
