/*
 * Name: Jake Strasler
 * Tip Calculator
 * Created: 3/3/2020
 */
package straslerj;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Controller class for TipCalculator; contains the project's logic
 */
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

    /**
     * Gets the initial total entered by the user
     * @return total entered by user as a double
     */
    public double getTotal() {
        total = Double.parseDouble(totalTextField.getText());
        return total;
    }

    /**
     * Determines the total and tip when a user selects 15%
     */
    public void setTotalCalculatedFifteen() {
        getTotal();
        tipCalculated.setText(String.valueOf(n.format(total * FIFTEEN_PERCENT_TIP)));
        totalCalculated.setText(String.valueOf(n.format(total + (total * FIFTEEN_PERCENT_TIP))));
        newTipCalculated.setText("");
        newTotalCalculated.setText("");
    }

    /**
     * Determines the total and tip when a user selects 20%
     */
    public void setTotalCalculatedTwenty() {
        getTotal();
        tipCalculated.setText(String.valueOf(n.format(total * TWENTY_PERCENT_TIP)));
        totalCalculated.setText(String.valueOf(n.format(total + (total * TWENTY_PERCENT_TIP))));
        newTipCalculated.setText("");
        newTotalCalculated.setText("");
    }

    /**
     * Determines the total and tip when a user selects 25%
     */
    public void setTotalCalculatedTwentyfive() {
        getTotal();
        tipCalculated.setText(String.valueOf(n.format(total * TWENTYFIVE_PERCENT_TIP)));
        totalCalculated.setText(String.valueOf(n.format(total + (total * TWENTYFIVE_PERCENT_TIP))));
        newTipCalculated.setText("");
        newTotalCalculated.setText("");
    }

    /**
     * Rounds the dollar value up to the nearest whole dollar,
     * adjusts the tip dollar value and percentage accordingly
     */
    public void roundUp() {
        double greaterThanCheck = Double.parseDouble(totalCalculated.getText().substring(1));
        double roundedUp = Math.round(Double.parseDouble((totalCalculated.getText().substring(1))));
        if((greaterThanCheck - (Math.round(greaterThanCheck))) > 0) {
            newTotalCalculated.setText(String.valueOf(n.format(Math.round(Double.parseDouble(
                    (totalCalculated.getText().substring(1)))) + 1.00)));
            roundedUp = Math.round(Double.parseDouble(
                    (totalCalculated.getText().substring(1)))) + 1.00;
        } else {
            newTotalCalculated.setText(n.format(
                    Math.round(Double.parseDouble((totalCalculated.getText().substring(1))))));
        }
        double roundedTip = roundedUp - total;
        newTipCalculated.setText(n.format(roundedTip) + " (" + format.format(
                roundedTip / total) + ")");
    }

    /**
     * Rounds the dollar value down to the nearest whole dollar,
     * adjusts the tip dollar value and percentage accordingly
     */
    public void roundDown() {
        double greaterThanCheck = Double.parseDouble(totalCalculated.getText().substring(1));
        double roundedDown = Math.round(Double.parseDouble(
                (totalCalculated.getText().substring(1))));
        if((greaterThanCheck - (Math.round(greaterThanCheck))) > 0) {
            newTotalCalculated.setText(n.format(Math.round(Double.parseDouble(
                    (totalCalculated.getText().substring(1))))));
        } else {
            newTotalCalculated.setText(n.format(Math.round(
                    Double.parseDouble((totalCalculated.getText().substring(1))) - 1.00)));
            roundedDown = Math.round(Double.parseDouble(
                    (totalCalculated.getText().substring(1))) - 1.00);
        }
        double roundedTip = roundedDown -total;
        newTipCalculated.setText(n.format(roundedTip) + " (" + format.format(
                roundedTip / total) + ")");
    }
}
