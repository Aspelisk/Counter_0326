import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    private int count = 0;
    private Label countLabel;

    @Override
    public void start(Stage primaryStage) {
        // Создаем метку для отображения числа
        countLabel = new Label("0");
        countLabel.setFont(new Font("Arial", 48)); // Крупный шрифт
        countLabel.setTextFill(Color.WHITE); // Белый цвет текста
        countLabel.setStyle("-fx-background-color: #333333; -fx-padding: 10px; -fx-background-radius: 10px;");

        // Кнопка +1
        Button btnPlus = new Button("+1");
        btnPlus.setFont(new Font("Arial", 18));
        btnPlus.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 5px; -fx-padding: 5px 15px;");
        btnPlus.setOnAction(e -> {
            count++;
            updateLabel();
        });

        // Кнопка -1
        Button btnMinus = new Button("-1");
        btnMinus.setFont(new Font("Arial", 18));
        btnMinus.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-background-radius: 5px; -fx-padding: 5px 15px;");
        btnMinus.setOnAction(e -> {
            count--;
            updateLabel();
        });

        // Контейнер для кнопок
        HBox buttonBox = new HBox(10); // Расстояние между кнопками 10px
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(btnMinus, btnPlus);

        // Основной контейнер (вертикальный)
        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #222222; -fx-padding: 20px;");
        root.getChildren().addAll(countLabel, buttonBox);

        // Настройка сцены
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT); // Прозрачный фон сцены

        // Настройка окна (Stage)
        primaryStage.initStyle(StageStyle.TRANSPARENT); // Убираем рамки окна (стиль "поп-ап")
        primaryStage.setScene(scene);
        primaryStage.setTitle("Счетчик");
        primaryStage.setAlwaysOnTop(true); // Окно всегда поверх других
        primaryStage.show();
    }

    private void updateLabel() {
        countLabel.setText(String.valueOf(count));
        // Анимация изменения цвета при изменении
        countLabel.setStyle("-fx-background-color: #555555; -fx-padding: 10px; -fx-background-radius: 10px;");

        // Возвращаем цвет через 200мс (простая анимация)
        javafx.animation.Timeline timeline = new javafx.animation.Timeline(
                new javafx.animation.KeyFrame(javafx.util.Duration.millis(200), e ->
                        countLabel.setStyle("-fx-background-color: #333333; -fx-padding: 10px; -fx-background-radius: 10px;")
                )
        );
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}