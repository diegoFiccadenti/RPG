import javafx.application.Application;
import javafx.stage.Stage;
import scenes.MainMenu;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("MyRPG");
        stage.setResizable(false);

        MainMenu.create(stage);

        stage.show();

    }

    static void main(String[] args) {
        launch();
    }

}