package com.learning.wordprocess.model;

import java.io.File;
import java.util.Date;

/**
 * Created by nodanvik on 19.12.2016.
 */
public class Document {

    private String text;

    private String author;

    private String fileName;

    private String font;

    private File saveFile;

    private File loadFile;

    private Date lastModified;

    public Document() {}

    public Document(String fileName) {
        this.fileName = fileName;
    }

    public Document(String text, String fileName) {
        this.text = text;
        this.fileName = fileName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public String getFont() {
        return font;
    }

    public File getSaveFile() {
        return saveFile;
    }

    public void setSaveFile(File saveFile) {
        this.saveFile = saveFile;
    }

    public File getLoadFile() {
        return loadFile;
    }

    public void setLoadFile(File loadFile) {
        this.loadFile = loadFile;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
}
