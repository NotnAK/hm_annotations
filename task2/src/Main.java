import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Class<?> cls = TextContainer.class;
        if(!cls.isAnnotationPresent(SaveTo.class)){
            System.out.println("Annotation @SaveTo not found!!!");
            return;
        }
        String path = cls.getAnnotation(SaveTo.class).path();
        Arrays.stream(cls.getDeclaredMethods()).forEach(m -> {
            if(m.isAnnotationPresent(Saver.class)){
                //TextContainer textContainer = new TextContainer();
                 TextContainer textContainer = new TextContainer("Hi");
                try {
                    m.invoke(textContainer, path);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(";)");
    }
}
