package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;

import java.io.File;
import java.nio.file.Path;

public class Controller {
    @FXML
    private HTMLEditor areaText;
    private TextFile currentTextFile;

    private Model model;

    public Controller(Model model){
        this.model = model;
    }

    @FXML
    private void onSaveAs(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save");
        fileChooser.setInitialDirectory(new File("./"));
        File file = fileChooser.showSaveDialog(null);
        if (file!=null){
            currentTextFile = new TextFile(Path.of(String.valueOf(file)), areaText.getHtmlText());
//                    Arrays.asList(areaText.getHtmlText().split("\n")));
            model.save(currentTextFile);
        }
    }
    @FXML
    private void onSave(){
        if (currentTextFile==null){
            onSaveAs();
        }else {
            TextFile textFile = new TextFile(currentTextFile.getFile(), areaText.getHtmlText());
//                    Arrays.asList(areaText.getHtmlText().split("\n")));
            model.save(textFile);
        }
    }
    @FXML
    private void onLoad(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("./"));
        File file = fileChooser.showOpenDialog(null);
        if (file!=null){
            Result<TextFile> res = model.load(file.toPath());
            if (res.isOk() && res.hasData()){
                currentTextFile = res.getData();
                areaText.setHtmlText((currentTextFile.getContent().toString()));
//                currentTextFile.getContent().forEach(line -> areaText.setHtmlText(line+"\n"));
            }else{
                System.out.println("Failed");
            }
        }
    }
    @FXML
    private void onClose(){
        model.close();
    }
    @FXML
    private void onAbout(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("About");
        alert.setContentText("This is a simple text editor Editor app");
        alert.show();
    }

    protected class AutoSave extends Thread{
        public void run(){
            onSave();
        }
    }
//        ExecutorService service = null;
//        try {
//            service = Executors.newFixedThreadPool(20);
//            for (int i = 0; i < 10; i++)
//                service.submit(() -> onSave());
//        }
//        finally
//        {
//            if (service != null)
//                service.shutdown();
//        }
//            ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
//            exec.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                onSave();
//            }
//        }, 0, 5, TimeUnit.SECONDS);
//        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
//        Runnable periodicTask = new Runnable() {
//            @Override
//            public void run() {
//                onSave();
//            }
//        };
//        executor.scheduleAtFixedRate(periodicTask, 0, 10, TimeUnit.SECONDS);

}
