import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Method[] methods = MyClass.class.getDeclaredMethods();
        MyClass obj = new MyClass();
        Arrays.asList(methods).stream().forEach(m->{
            if(m.isAnnotationPresent(Test.class)){
                Test test = m.getAnnotation(Test.class);
                   try {
                    m.invoke(obj,  test.a(), test.b());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}