package com.learning.wordprocess.controller.impl;

import com.learning.wordprocess.controller.WordController;
import com.learning.wordprocess.model.Document;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

import static java.lang.System.out;

/**
 * Created by nodanvik on 19.12.2016.
 */
public class WordControllerImpl implements WordController {

    private Document document;

    private static final Logger logger = Logger.getAnonymousLogger();

    public String buildText() {
        return null;
    }

    public int saveFile(File file, Document document) {
        int saveResult = -1;

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {

            bufferedWriter.write(document.getText());

            saveResult = 0;
        } catch (IOException ioe) {
            logger.severe(ioe.getMessage());
            ioe.printStackTrace();
        }

        return saveResult;
    }

    public String loadFile(File file) {

        StringBuilder stringBuilder = new StringBuilder();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            bufferedReader.lines()
                    .forEach((line)->stringBuilder.append(line));
            logger.info(stringBuilder.toString());
        } catch(FileNotFoundException fnfex) {
            logger.severe("File Not Found!");
            fnfex.printStackTrace();
            return null;
        } catch (IOException ioex) {
            ioex.printStackTrace();
            logger.severe(ioex.getMessage());
            return null;
        }

        return stringBuilder.toString();
    }
}
