package sample;

import java.nio.file.Path;

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
