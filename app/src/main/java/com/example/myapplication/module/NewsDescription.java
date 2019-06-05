package com.example.myapplication.module;

import java.io.Serializable;

public class NewsDescription implements Serializable {

    private String date;
    private String edition;
    private String editionName;
    private String groupEdition;
    private String registration;
    private String realName;
    private String fileName;
    private String issuingDepartment;
    private String issuer;
    private String layoutEditor;
    private String layoutHeight;
    private String layoutWidth;
    private String numberOfTexts;
    private String numberOfPictures;
    private Pdf pdf;
    private LayoutImageBean layoutImageBean;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getEditionName() {
        return editionName;
    }

    public void setEditionName(String editionName) {
        this.editionName = editionName;
    }

    public String getGroupEdition() {
        return groupEdition;
    }

    public void setGroupEdition(String groupEdition) {
        this.groupEdition = groupEdition;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getIssuingDepartment() {
        return issuingDepartment;
    }

    public void setIssuingDepartment(String issuingDepartment) {
        this.issuingDepartment = issuingDepartment;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getLayoutEditor() {
        return layoutEditor;
    }

    public void setLayoutEditor(String layoutEditor) {
        this.layoutEditor = layoutEditor;
    }

    public String getLayoutHeight() {
        return layoutHeight;
    }

    public void setLayoutHeight(String layoutHeight) {
        this.layoutHeight = layoutHeight;
    }

    public String getLayoutWidth() {
        return layoutWidth;
    }

    public void setLayoutWidth(String layoutWidth) {
        this.layoutWidth = layoutWidth;
    }

    public String getNumberOfTexts() {
        return numberOfTexts;
    }

    public void setNumberOfTexts(String numberOfTexts) {
        this.numberOfTexts = numberOfTexts;
    }

    public String getNumberOfPictures() {
        return numberOfPictures;
    }

    public void setNumberOfPictures(String numberOfPictures) {
        this.numberOfPictures = numberOfPictures;
    }

    public Pdf getPdf() {
        return pdf;
    }

    public void setPdf(Pdf pdf) {
        this.pdf = pdf;
    }

    public LayoutImageBean getLayoutImageBean() {
        return layoutImageBean;
    }

    public void setLayoutImageBean(LayoutImageBean layoutImageBean) {
        this.layoutImageBean = layoutImageBean;
    }

    public static class Pdf{

        private String fileName;

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }
    }
}
