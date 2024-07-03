import java.io.*;
import java.lang.reflect.Field;
import java.util.Arrays;

public class SerializationUtil {
    public static void serialize(Object obj, String path) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            Arrays.stream(obj.getClass().getDeclaredFields()).forEach(f -> {
                if (f.isAnnotationPresent(Save.class)) {
                    f.setAccessible(true);
                    try {
                        bw.write(f.getName() + "=" + f.get(obj) + "\n");
                    } catch (IOException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static void deserialize(Object obj, String path) throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            Class<?> cls = obj.getClass();
             reader.lines().forEach(l ->{
                 String[] parts = l.split("=");
                 String fieldName = parts[0];
                 String fieldValue = parts[1];
                 try {
                     Field f = cls.getDeclaredField(fieldName);
                     f.setAccessible(true);
                     if(f.getType() == int.class){
                         f.set(obj, Integer.parseInt(fieldValue));
                     }
                     else if(f.getType() == String.class){
                         f.set(obj, fieldValue);
                     }
                 }
                 catch (NoSuchFieldException | IllegalAccessException e) {
                     e.printStackTrace();
                 }

             });
        }
    }
}
