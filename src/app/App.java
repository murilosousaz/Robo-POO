package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    static final String FXML_MENU      = "resources/fxml/menu.fxml";
    static final String FXML_TABULEIRO = "resources/fxml/tabuleiro.fxml";
    static final String FXML_DIALOGO   = "resources/fxml/dialogo-posicao.fxml";

    static final Class<?> ANCORA = view.TabuleiroView.class;

    @Override
    public void start(Stage stage) throws Exception {
        Parent raiz = FXMLLoader.load(ANCORA.getResource(FXML_MENU));

        Scene scene = new Scene(raiz, 400, 560);
        stage.setTitle("Robô Game — P00 UECE");
        stage.setScene(scene);
        stage.setMinWidth(400);
        stage.setMinHeight(560);
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}