package com.learning.wordprocess.controller;

import com.learning.wordprocess.model.Document;

import java.io.File;

/**
 * Created by nodanvik on 19.12.2016.
 */
public interface WordController {
    String buildText();
    int saveFile(File file, Document document);
    String loadFile(File file);
}
