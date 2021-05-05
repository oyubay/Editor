package sample;

import javafx.scene.Parent;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TextFile {
    private final Path file;
    private final String content;
    public TextFile(Path file, String  content){
        this.file = file;
        this.content = content;
    }
    public Path getFile(){
        return file;
    }
    public String getContent(){
        return content;
    }

}
