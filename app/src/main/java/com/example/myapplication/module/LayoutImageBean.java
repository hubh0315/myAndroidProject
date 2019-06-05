package com.example.myapplication.module;

public class LayoutImageBean {

    private String fileName;
    private String height;
    private String width;
    private ImageBean realImageBean;
    private ImageBean standardImageBean;
    private ImageBean simpleImageBean;
    private ImageBean iconImageBean;

    public ImageBean getRealImageBean() {
        return realImageBean;
    }

    public void setRealImageBean(ImageBean realImageBean) {
        this.realImageBean = realImageBean;
    }

    public ImageBean getStandardImageBean() {
        return standardImageBean;
    }

    public void setStandardImageBean(ImageBean standardImageBean) {
        this.standardImageBean = standardImageBean;
    }

    public ImageBean getSimpleImageBean() {
        return simpleImageBean;
    }

    public void setSimpleImageBean(ImageBean simpleImageBean) {
        this.simpleImageBean = simpleImageBean;
    }

    public ImageBean getIconImageBean() {
        return iconImageBean;
    }

    public void setIconImageBean(ImageBean iconImageBean) {
        this.iconImageBean = iconImageBean;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }
}
