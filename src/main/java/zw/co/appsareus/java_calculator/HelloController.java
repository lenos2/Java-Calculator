package zw.co.appsareus.java_calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.util.Locale;

public class HelloController {

    @FXML
    private TextField tfWorkArea;

    private String operator = "";
    private Float memory;

    @FXML
    protected void onEquals(){
        float currentNumber = Float.parseFloat(tfWorkArea.getText());
        float ans;
        DecimalFormat df = new DecimalFormat("0.##########");
        switch (operator){
            case "X":
                ans = currentNumber * memory;
                tfWorkArea.setText(df.format(ans));
                memory = 0f;
                operator = "";
                break;
            case "/":
                ans = memory / currentNumber;
                tfWorkArea.setText(df.format(ans));
                memory = 0f;
                operator = "";
                break;
            case "+":
                ans = currentNumber + memory;
                tfWorkArea.setText(df.format(ans));
                memory = 0f;
                operator = "";
                break;
            case "-":
                ans = memory - currentNumber;
                tfWorkArea.setText(df.format(ans));
                memory = 0f;
                operator = "";
                break;
        }
    }

    @FXML
    protected void onNumberClick(ActionEvent event){
        Button btnNumber = (Button) event.getSource();
        String buttonText  = btnNumber.getText();
        String currentNumber = tfWorkArea.getText();
        if (buttonText.equals(".")){
            for (char c : tfWorkArea.getText().toCharArray()) {
                if (c == '.') return;
            }
            tfWorkArea.setText(tfWorkArea.getText()+".");
        }else{
            if(Float.parseFloat(tfWorkArea.getText()) == 0f){
                tfWorkArea.setText(buttonText);
            }else{
                tfWorkArea.setText(currentNumber+buttonText);
            }
        }
    }

    @FXML
    protected void onNegate(){
        String currentNumber = tfWorkArea.getText();
        float currentNum = Float.parseFloat(currentNumber);
        tfWorkArea.setText(String.format(Locale.getDefault(),"%f",(currentNum*-1)));
    }

    @FXML
    protected void onSelectOperator(ActionEvent event){
        operator = ((Button) (event.getSource())).getText();
        memory = Float.parseFloat(tfWorkArea.getText());
        tfWorkArea.setText("0");
    }

    @FXML
    protected void onClear(){
        memory = 0f;
        operator = "";
        tfWorkArea.setText("0");
    }

    @FXML
    protected void onAddToMemory(){
        memory = Float.parseFloat(tfWorkArea.getText());
        tfWorkArea.setText("0");
    }

    @FXML
    protected void onMemoryRecall(){
        DecimalFormat df = new DecimalFormat("0.#");
        tfWorkArea.setText(df.format(memory));
    }
}