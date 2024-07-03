import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Human human = new Human(99, "Alex", "White", "Baker Street");
        String path = "task3.txt";
        SerializationUtil.serialize(human, path);
        Human human1 = new Human();
        System.out.println(human1.getName());
        SerializationUtil.deserialize(human1, path);
        System.out.println(human1.getName());

    }
}
