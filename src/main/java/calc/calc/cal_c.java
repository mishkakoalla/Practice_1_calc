package calc.calc;

import java.awt.Component;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.JOptionPane;


public class cal_c implements cal_ovewr {
    @FXML
    private Button button_math;
    @FXML
    private Button button_clear;
    @FXML
    private Button button_exit;
    @FXML
    private Label label_a;
    @FXML
    private Label label_b;
    @FXML
    private Label label_x;
    @FXML
    private Label label_done;
    @FXML
    private TextField TextA;
    @FXML
    private TextField TextB;
    @FXML
    private TextField TextX;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    @FXML
    private void buttonMathAction(ActionEvent event){
        double a, b, x, y;
        try{
            a=Double.parseDouble(TextA.getText());
            b=Double.parseDouble(TextB.getText());
            x=Double.parseDouble(TextX.getText());
        } catch (Exception exception) {
            Toolkit.getDefaultToolkit().beep();
            Component rootPane = null;
            JOptionPane.showMessageDialog(null, "Ошибка введенных данных!", "Ошибка ввода",
                    JOptionPane.ERROR_MESSAGE);
            TextA.requestFocus();
            label_done.setText("В введенных значениях допущены ошибки");
            TextA.setText("");
            TextB.setText("");
            TextX.setText("");
            return;
        }
        if (x>6) {
            y=((a/x)+(b/(x*x)));
            label_done.setText("Ответ: \" + String.format(\"%.2f\",y)");
        } else {
            y=((a*a)*(x+b));
            label_done.setText("Ответ: \" + String.format(\"%.2f\",y)");
        }
        if (!(Double.isNaN(y)) && (!Double.isInfinite(y))) {
            label_done.setText("Ответ: " + String.format("%.2f", y));
        } else {
            label_done.setText("Нет ответа");
        }
    }
    @FXML
    private void buttonClearAction(ActionEvent event) {
        label_done.setText("Ответ:");
        TextA.setText("");
        TextB.setText("");
        TextX.setText("");
    }
    @FXML
    private void buttonExitAction(ActionEvent event) {
        System.exit(0);
    }
}
