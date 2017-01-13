package com.learning.wordprocess.view.alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * Created by nodanvik on 08.01.2017.
 */
public interface AlertFactory {
    Optional<ButtonType> getFileOpenAlert();
    Optional<ButtonType> getOverWriteAlert();

}
