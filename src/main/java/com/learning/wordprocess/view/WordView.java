package com.learning.wordprocess.view;

import com.learning.wordprocess.controller.WordController;
import com.learning.wordprocess.controller.impl.WordControllerImpl;
import com.learning.wordprocess.model.Document;
import com.learning.wordprocess.view.alerts.AlertFactory;
import com.learning.wordprocess.view.alerts.AlertFactoryImpl;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.Optional;
import java.util.logging.Logger;


/**
 * Created by nodanvik on 19.12.2016.
 */
public class WordView extends Application{

    TextArea textArea;
    GridPane gridPane;
    FileChooser fileChooser;


    WordController wordController = new WordControllerImpl();

    Document currentDoc;

    boolean fileOpen = false;

    AlertFactory alertFactory = new AlertFactoryImpl();

    public static final Logger logger = Logger.getAnonymousLogger();

    public void init() {
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(5));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        fileChooser = new FileChooser();
        fileChooser.setTitle("open file...");


        textArea = new TextArea();
        textArea.setPrefRowCount(20);
        textArea.setPrefColumnCount(100);
        textArea.setWrapText(true);
        textArea.setPrefWidth(700);

        GridPane.setHalignment(textArea, HPos.CENTER);
        GridPane.setValignment(textArea, VPos.BOTTOM);
        gridPane.add(textArea, 0, 1);


    }

    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Word Processor");

        FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 10, 10);

        Scene scene = new Scene(rootNode, 800, 600);
        scene.setFill(javafx.scene.paint.Paint.valueOf(String.valueOf(Color.CHOCOLATE)));

        MenuBar menuBar = new MenuBar();


        Menu menuFile = new Menu("File");
        MenuItem newFile = new MenuItem("New");
        newFile.setOnAction((actionEvent)->{
            if(fileOpen) {
                Optional<?> result = alertFactory.getFileOpenAlert();
                if(result.get() == ButtonType.OK) {
                    logger.info("Clearing text-area for new document");
                    textArea.clear();

                } else {
                    logger.info("Cancel");
                }
            } else {
                rootNode.getChildren().add(gridPane);
                currentDoc = new Document();
                fileOpen = true;
            }
        });
        MenuItem saveFile = new MenuItem("Save");
        saveFile.setOnAction((actionEvent)-> {
            if(currentDoc != null) {
                currentDoc.setText(textArea.getText());
                logger.info(currentDoc.getText());

                File file = fileChooser.showSaveDialog(primaryStage);
                logger.info(file.getAbsolutePath());
                int saveResult = wordController.saveFile(file, currentDoc);
                if(saveResult == 0) {
                    logger.info("save successful");
                } else {
                    logger.severe("save failed");
                }
            }
        });
        MenuItem openFile = new MenuItem("Open");
        openFile.setOnAction((actionEvent)->{
            File file = fileChooser.showOpenDialog(primaryStage);
            String loadedText = wordController.loadFile(file);
            if(!fileOpen) {
                logger.warning("No document has been opened yet, creating new text-area");
                rootNode.getChildren().add(gridPane);
            }
            if(textArea.getLength() > 0) {
                logger.warning("Text-area already contains text");

                Optional<?> result = alertFactory.getOverWriteAlert();

                if(result.get() == ButtonType.OK) {
                    textArea.clear();
                    textArea.insertText(0, loadedText);
                } else {
                    logger.info("Cancel");
                }

            } else { textArea.insertText(0, loadedText); }
            fileOpen = true;
        });
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction((actionEvent)->{
            fileOpen = false;
            System.exit(0);
        });
        menuFile.getItems().addAll(newFile, saveFile, openFile, new SeparatorMenuItem(), exit);

        Menu menuEdit = new Menu("Edit");
        MenuItem setFont = new MenuItem("Set font...");
        setFont.setOnAction((actionEvent)-> {

        });


        Menu menuView = new Menu("View");

        menuBar.getMenus().addAll(menuFile, menuEdit, menuView);


        rootNode.getChildren().addAll(menuBar);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}
