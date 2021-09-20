package sample;

import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Canvas canvas;
    public GraphicsContext gtx;
    public ColorPicker colorPicker;
    public Label thicknessLabel;
    public Slider thicknessSlider;

    public void paint(MouseEvent mouseEvent) {
        int thickness = (int) thicknessSlider.getValue();
        gtx.setFill(colorPicker.getValue());
        if (mouseEvent.getButton().equals(MouseButton.SECONDARY)) {
            gtx.setFill(Color.WHITE);
            gtx.fillOval(mouseEvent.getX(), mouseEvent.getY(), thickness, thickness);
            return;
        }
        gtx.fillOval(mouseEvent.getX(), mouseEvent.getY(), thickness, thickness);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gtx = canvas.getGraphicsContext2D();

        thicknessSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            thicknessLabel.setText(String.valueOf(Math.round(thicknessSlider.getValue())));
        });
    }

    public void clear() {
        gtx.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
}
