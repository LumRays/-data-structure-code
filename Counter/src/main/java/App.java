import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("0");
        label.setStyle("-fx-font-size: 48px;");
        Button incrementBtn = new Button("+");
        incrementBtn.setStyle("-fx-font-size: 24px;");
        incrementBtn.setPrefWidth(80);
        Button decrementBtn = new Button("-");
        decrementBtn.setStyle("-fx-font-size: 24px;");
        decrementBtn.setPrefWidth(80);

        incrementBtn.setOnAction(e -> {
            int value = Integer.parseInt(label.getText()) + 1;
            label.setText(String.valueOf(value));
        });
        decrementBtn.setOnAction(e -> {
            int value = Integer.parseInt(label.getText()) - 1;
            label.setText(String.valueOf(value));
        });

        HBox buttonBox = new HBox(10, incrementBtn, decrementBtn);
        buttonBox.setAlignment(Pos.CENTER);

        VBox root = new VBox(20, label, buttonBox);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("counter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
