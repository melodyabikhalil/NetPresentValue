package NPV;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private TextField annualGainTextField;
    @FXML private TextField initalInvTextField;
    @FXML private TextField discountRateTextField;
    @FXML private TextField usefulLifeTextField;
    @FXML private TextField npvTextField;

    private NetPresentValue npv;
    private DecimalFormat decimalFormat = new DecimalFormat(".##");


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addActionOnEnter(annualGainTextField);
        addActionOnEnter(initalInvTextField);
        addActionOnEnter(discountRateTextField);
        addActionOnEnter(usefulLifeTextField);
    }

    private void addActionOnEnter(TextField tf){
        tf.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER){
                calculatePressed();
            }
        });
    }

    public void calculatePressed(){
        try{
            double annualGain = Double.parseDouble(annualGainTextField.getText());
            double initialInvestment = Double.parseDouble(initalInvTextField.getText());
            double discountRate = Double.parseDouble(discountRateTextField.getText());
            double usefulLife = Double.parseDouble(usefulLifeTextField.getText());

             npv = new NetPresentValue(annualGain,initialInvestment,discountRate,usefulLife);
            try {
                npvTextField.setText(String.valueOf(decimalFormat.format(npv.computeNetPresentValue())));
            }
            catch(ValueError e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Inputs");
                alert.setHeaderText(null);
                alert.setContentText("Discount rate cannot be 0");

                alert.showAndWait();
            }
        } catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Inputs");
            alert.setHeaderText(null);
            alert.setContentText("Input must be a numeric value");

            alert.showAndWait();
        }



    }


}
