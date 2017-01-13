package com.learning.wordprocess.view.alerts;

import com.learning.wordprocess.model.alerts.OverWriteAlert;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * Created by nodanvik on 08.01.2017.
 */
public class AlertFactoryImpl implements AlertFactory{

    //Alert alert;

    @Override
    public Optional<ButtonType> getFileOpenAlert() {
        OverWriteAlert alert = new OverWriteAlert();
        Optional<ButtonType> result = alert.showAndWait();

        return result;
    }

    @Override
    public Optional<ButtonType> getOverWriteAlert() {
        Alert overwriteAlert = new Alert(Alert.AlertType.CONFIRMATION);
        overwriteAlert.setTitle("Overwrite confirmation");
        overwriteAlert.setContentText("Open document will be overwritten");

        Optional<ButtonType> result = overwriteAlert.showAndWait();

        return result;
    }
}
