import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@SaveTo(path = "task2.txt")
public class TextContainer {
    private String text;

    public TextContainer() {
        text = "Hello world";
    }

    public TextContainer(String text) {
        this.text = text;
    }
    @Saver
    public void save(String path){
        try(FileWriter pw = new FileWriter(path)){
            pw.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
