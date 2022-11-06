package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;

public class CalculatorController {

    private final String sinS = "s";
    private final String cosS = "c";
    private final String tanS = "t";
    private final String sinInverseS = "q";
    private final String cosInverseS = "w";
    private final String coTanS = "e";
    private final String remainderS = "r";
    private String finalExpression="";

    @FXML
    private JFXButton num1;

    @FXML
    private JFXButton num2;

    @FXML
    private JFXButton num3;

    @FXML
    private JFXButton num4;

    @FXML
    private JFXButton num5;

    @FXML
    private JFXButton num6;

    @FXML
    private JFXButton num7;

    @FXML
    private JFXButton num8;

    @FXML
    private JFXButton num9;

    @FXML
    private JFXButton num0;

    @FXML
    private JFXButton btnC;

    @FXML
    private JFXButton btnPlus;

    @FXML
    private JFXButton btnMinus;

    @FXML
    private JFXButton btnDivide;

    @FXML
    private JFXButton btnMult;

    @FXML
    private JFXButton btnSin;

    @FXML
    private JFXButton btnCos;

    @FXML
    private JFXButton btnTan;

    @FXML
    private JFXButton btnSinI;

    @FXML
    private JFXButton btnCosI;

    @FXML
    private JFXButton btnCoTan;

    @FXML
    private JFXButton btnBOPen;

    @FXML
    private JFXButton btnBClosed;

    @FXML
    private JFXButton btnEqual;

    @FXML
    private Label lblExpression;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnRemainder;

    @FXML
    void btnRemainderPressed(ActionEvent event){
        lblExpression.setText(lblExpression.getText()+"%");
        finalExpression+=remainderS;
    }

    @FXML
    void btnBClosedPressed(ActionEvent event) {
        lblExpression.setText(lblExpression.getText()+")");
        finalExpression+=")";
    }

    @FXML
    void btnBOpenPressed(ActionEvent event) {
        lblExpression.setText(lblExpression.getText()+"(");
        finalExpression+="(";
    }

    @FXML
    void btnCPressed(ActionEvent event) {
        lblExpression.setText("");
        finalExpression="";
    }

    @FXML
    void btnCoTanPressed(ActionEvent event) {
        lblExpression.setText(lblExpression.getText()+"cot");
        finalExpression+=coTanS;
    }

    @FXML
    void btnCosIPressed(ActionEvent event) {
        lblExpression.setText(lblExpression.getText()+"cosI");
        finalExpression+=cosInverseS;
    }

    @FXML
    void btnCosPressed(ActionEvent event) {
        lblExpression.setText(lblExpression.getText()+"cos");
        finalExpression+=cosS;
    }

    @FXML
    void btnDividePressed(ActionEvent event) {
        lblExpression.setText(lblExpression.getText()+"/");
        finalExpression += "/";
    }

    @FXML
    void btnEqualPressed(ActionEvent event) {
        if(!finalExpression.equals("")){
            System.out.println(finalExpression);
            double evaluatedExpression = 0;
            try {

                evaluatedExpression = ExpressionEvaluator.evaluate(finalExpression);
                if(Double.isInfinite(evaluatedExpression) || Double.isNaN(evaluatedExpression)){
                    Alert alert = new Alert(Alert.AlertType.ERROR,"Value not Defined");
                    alert.show();
                    finalExpression = "";
                    lblExpression.setText("");
                }else{
                    finalExpression=ExpressionEvaluator.evaluate(finalExpression)+"";
                    lblExpression.setText(evaluatedExpression+"");
                }

            } catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR,"Invalid Expression");
                alert.show();
            }



        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR,"Expression is Empty");
            alert.show();
        }


    }

    @FXML
    void btnMinusPressed(ActionEvent event) {
        lblExpression.setText(lblExpression.getText()+"-");
        finalExpression+="-";
    }

    @FXML
    void btnMultPressed(ActionEvent event) {
        lblExpression.setText(lblExpression.getText()+"X");
        finalExpression+="*";
    }

    @FXML
    void btnPlusPressed(ActionEvent event) {
        lblExpression.setText(lblExpression.getText()+"+");
        finalExpression+="+";
    }

    @FXML
    void btnSinIPressed(ActionEvent event) {
        lblExpression.setText(lblExpression.getText()+"sinI");
        finalExpression+=sinInverseS;
    }

    @FXML
    void btnSinPressed(ActionEvent event) {
        lblExpression.setText(lblExpression.getText()+"sin");
        finalExpression+=sinS;
    }

    @FXML
    void btnTanPressed(ActionEvent event) {
        lblExpression.setText(lblExpression.getText()+"tan");
        finalExpression+=tanS;
    }

    @FXML
    void btnDeletePressed(ActionEvent event) {
        if(!lblExpression.getText().equals("")){
            String textInLbl = lblExpression.getText();
            //lblExpression.setText(lblExpression.getText().substring(0,lblExpression.getText().length()-1));
            if(textInLbl.endsWith("I")){
                lblExpression.setText(lblExpression.getText().substring(0,lblExpression.getText().length()-4));
            }else if(textInLbl.endsWith("n") || textInLbl.endsWith("t") || textInLbl.endsWith("s")){
                lblExpression.setText(lblExpression.getText().substring(0,lblExpression.getText().length()-3));
            }else{
                lblExpression.setText(lblExpression.getText().substring(0,lblExpression.getText().length()-1));
            }
            finalExpression = finalExpression.substring(0,finalExpression.length()-1);
        }
    }

    @FXML
    void num0Pressed(ActionEvent event) {
        lblExpression.setText(lblExpression.getText()+"0");
        finalExpression+="0";
    }

    @FXML
    void num1Pressed(ActionEvent event) {
        lblExpression.setText(lblExpression.getText()+"1");
        finalExpression+="1";
    }

    @FXML
    void num2Pressed(ActionEvent event) {
        lblExpression.setText(lblExpression.getText()+"2");
        finalExpression+="2";
    }

    @FXML
    void num3Pressed(ActionEvent event) {
        lblExpression.setText(lblExpression.getText()+"3");
        finalExpression+="3";
    }

    @FXML
    void num4Pressed(ActionEvent event) {
        lblExpression.setText(lblExpression.getText()+"4");
        finalExpression+="4";
    }

    @FXML
    void num5Pressed(ActionEvent event) {
        lblExpression.setText(lblExpression.getText()+"5");
        finalExpression+="5";
    }

    @FXML
    void num6Pressed(ActionEvent event) {
        lblExpression.setText(lblExpression.getText()+"6");
        finalExpression+="6";
    }

    @FXML
    void num7Pressed(ActionEvent event) {
        lblExpression.setText(lblExpression.getText()+"7");
        finalExpression+="7";
    }

    @FXML
    void num8Pressed(ActionEvent event) {
        lblExpression.setText(lblExpression.getText()+"8");
        finalExpression+="8";
    }

    @FXML
    void num9Pressed(ActionEvent event) {
        lblExpression.setText(lblExpression.getText()+"9");
        finalExpression+="9";
    }

}
