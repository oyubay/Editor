package sample;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Model {

    public void save(TextFile textFile) {
        try {
            Files.write(textFile.getFile(), textFile.getContent().getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Result<TextFile> load(Path file){
        try{
            String lines = Files.readString(file);
            return new Result<>(true, new TextFile(file, lines));
        }catch (IOException e){
            e.printStackTrace();
            return new Result<>(false, null);
        }
    }

    public void close(){
        System.exit(0);
    }

}
