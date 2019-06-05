package com.example.myapplication.module;

import java.io.Serializable;

public class NewsDetail implements Serializable {

    private String releaseType;
    private String publish;
    private String informationID;
    private String source;
    private String quotation;
    private String title;
    private String subtitle;
    private String digest;
    private String author;
    private String correspondent;
    private String column;
    private String photoDescription;
    private String downward;
    private String up;
    private String serialNumber;
    private String classification;
    private String genre;
    private String transfer;
    private String fileName;
    private String relatedItem;
    private String numberOfWords;
    private LayoutMap layoutMap;
    private String content;
    private AttachedDrawing attachedDrawing;


    public AttachedDrawing getAttachedDrawing() {
        return attachedDrawing;
    }

    public void setAttachedDrawing(AttachedDrawing attachedDrawing) {
        this.attachedDrawing = attachedDrawing;
    }

    public String getReleaseType() {
        return releaseType;
    }

    public void setReleaseType(String releaseType) {
        this.releaseType = releaseType;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getInformationID() {
        return informationID;
    }

    public void setInformationID(String informationID) {
        this.informationID = informationID;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getQuotation() {
        return quotation;
    }

    public void setQuotation(String quotation) {
        this.quotation = quotation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCorrespondent() {
        return correspondent;
    }

    public void setCorrespondent(String correspondent) {
        this.correspondent = correspondent;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getPhotoDescription() {
        return photoDescription;
    }

    public void setPhotoDescription(String photoDescription) {
        this.photoDescription = photoDescription;
    }

    public String getDownward() {
        return downward;
    }

    public void setDownward(String downward) {
        this.downward = downward;
    }

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getRelatedItem() {
        return relatedItem;
    }

    public void setRelatedItem(String relatedItem) {
        this.relatedItem = relatedItem;
    }

    public String getNumberOfWords() {
        return numberOfWords;
    }

    public void setNumberOfWords(String numberOfWords) {
        this.numberOfWords = numberOfWords;
    }

    public LayoutMap getLayoutMap() {
        return layoutMap;
    }

    public void setLayoutMap(LayoutMap layoutMap) {
        this.layoutMap = layoutMap;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
