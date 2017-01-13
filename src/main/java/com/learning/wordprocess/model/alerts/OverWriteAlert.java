package com.learning.wordprocess.model.alerts;

import javafx.beans.NamedArg;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * Created by nodanvik on 08.01.2017.
 */
public class OverWriteAlert extends Alert{



    public OverWriteAlert(@NamedArg("alertType") AlertType alertType) {
        super(alertType);
    }

    public OverWriteAlert(@NamedArg("alertType") AlertType alertType, @NamedArg("contentText") String contentText, ButtonType... buttons) {
        super(alertType, contentText, buttons);
    }
}
