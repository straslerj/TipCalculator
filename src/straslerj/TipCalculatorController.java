package straslerj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.NumberFormat;
import java.util.Locale;

public class TipCalculatorController {
    private static final double FIFTEEN_PERCENT_TIP = 0.15;
    private static final double TWENTY_PERCENT_TIP = 0.20;
    private static final double TWENTYFIVE_PERCENT_TIP = 0.25;
    private double total = 0;

    NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
    NumberFormat format = NumberFormat.getPercentInstance(Locale.US);

    @FXML
    TextField totalTextField;

    @FXML
    Button fifButton;

    @FXML
    Button twenButton;

    @FXML
    Button twenfiveButton;

    @FXML
    Label tipCalculated;

    @FXML
    Label totalCalculated;

    @FXML
    Button roundUpButton;

    @FXML
    Button roundDownButton;

    @FXML
    Label newTipCalculated;

    @FXML
    Label newTotalCalculated;

    public double getTotal() {
        total = Double.parseDouble(totalTextField.getText());
        return total;
    }

    public void setTotalCalculatedFifteen(ActionEvent event) {
        getTotal();
        tipCalculated.setText(String.valueOf(n.format(total * FIFTEEN_PERCENT_TIP)));
        totalCalculated.setText(String.valueOf(n.format(total + (total * FIFTEEN_PERCENT_TIP))));
    }

    public void setTotalCalculatedTwenty(ActionEvent event) {
        getTotal();
        tipCalculated.setText(String.valueOf(n.format(total * TWENTY_PERCENT_TIP)));
        totalCalculated.setText(String.valueOf(n.format(total + (total * TWENTY_PERCENT_TIP))));
    }

    public void setTotalCalculatedTwentyfive(ActionEvent event) {
        getTotal();
        tipCalculated.setText(String.valueOf(n.format(total * TWENTYFIVE_PERCENT_TIP)));
        totalCalculated.setText(String.valueOf(n.format(total + (total * TWENTYFIVE_PERCENT_TIP))));
    }

    public void roundUp(ActionEvent event) {
        double greaterThanCheck = Double.parseDouble(totalCalculated.getText().substring(1));
        double roundedUp = Math.round(Double.parseDouble((totalCalculated.getText().substring(1))));
        if((greaterThanCheck - (Math.round(greaterThanCheck))) > 0) {
            newTotalCalculated.setText(String.valueOf(n.format(Math.round(Double.parseDouble(
                    (totalCalculated.getText().substring(1)))) + 1.00)));
            roundedUp = Math.round(Double.parseDouble((totalCalculated.getText().substring(1)))) + 1.00;
        } else {
            newTotalCalculated.setText
                    (n.format(Math.round(Double.parseDouble((totalCalculated.getText().substring(1))))));
        }
        double roundedTip = roundedUp - total;
        newTipCalculated.setText(n.format(roundedTip) + " (" + format.format(roundedTip / total) + ")");
    }

    public void roundDown(ActionEvent event) {
        double greaterThanCheck = Double.parseDouble(totalCalculated.getText().substring(1));
        double roundedDown = Math.round(Double.parseDouble((totalCalculated.getText().substring(1))));
        if((greaterThanCheck - (Math.round(greaterThanCheck))) > 0) {
            newTotalCalculated.setText(String.valueOf(n.format(Math.round(Double.parseDouble(
                    (totalCalculated.getText().substring(1)))))));
        } else {
            newTotalCalculated.setText
                    (n.format(Math.round(Double.parseDouble((totalCalculated.getText().substring(1))) - 1.00)));
            roundedDown = Math.round(Double.parseDouble((totalCalculated.getText().substring(1))) - 1.00);
        }
        //newTotalCalculated.setText(n.format(Math.round(Double.parseDouble((totalCalculated.getText().substring(1))))));
        double roundedTip = roundedDown -total;
        newTipCalculated.setText(n.format(roundedTip) + " (" + format.format(roundedTip / total) + ")");
    }

}
