package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.myapplication.module.AttachedDrawing;
import com.example.myapplication.module.ImageBean;
import com.example.myapplication.module.LayoutImageBean;
import com.example.myapplication.module.LayoutMap;
import com.example.myapplication.module.NewsDescription;
import com.example.myapplication.module.NewsDetail;
import com.example.myapplication.module.PdfLayout;
import com.example.myapplication.module.Vertex;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class XmlActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
//                WindowManager.LayoutParams. FLAG_FULLSCREEN);

        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(option);

        getWindow().setStatusBarColor(Color.TRANSPARENT);

        setContentView(R.layout.activity_xml);

        initView();

        xml();
    }

    private void initView() {
    }

    @Override
    public void onClick(View view) {

    }

    public void xml() {
        //1.创建Reader对象
        SAXReader reader = new SAXReader();
        //2.加载xml
        Document document = null;
        try {
            document = reader.read(getAssets().open("rmrb2019031301.xml"));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (document == null) {
            return;
        }

        PdfLayout pdfLayout = new PdfLayout();

        Element rootElement = document.getRootElement();
        Iterator iterator = rootElement.elementIterator();
        while (iterator.hasNext()) {
            Element stu = (Element) iterator.next();
            if ("大样".equals(stu.getName())) {
                pdfLayout.setNewsDescription(getNewsDescription(stu));
            } else if ("小样".equals(stu.getName())) {
                pdfLayout.addNewsDetail(getNewsDetail(stu));
            }
        }

        pdfLayout.getNewsDetails();
    }

    private NewsDetail getNewsDetail(Element stu) {
        if (stu == null) {
            return null;
        }

        NewsDetail newsDetail = new NewsDetail();

        Iterator iterator1 = stu.elementIterator();
        while (iterator1.hasNext()) {
            Element stuChild = (Element) iterator1.next();

            switch (stuChild.getName()) {
                case "发布类型":
                    newsDetail.setReleaseType(stuChild.getStringValue());
                    break;
                case "发布":
                    newsDetail.setPublish(stuChild.getStringValue());
                    break;
                case "信息ID":
                    newsDetail.setInformationID(stuChild.getStringValue());
                    break;
                case "来源":
                    newsDetail.setSource(stuChild.getStringValue());
                    break;
                case "引题":
                    newsDetail.setQuotation(stuChild.getStringValue());
                    break;
                case "标题":
                    newsDetail.setTitle(stuChild.getStringValue());
                    break;
                case "副题":
                    newsDetail.setSubtitle(stuChild.getStringValue());
                    break;
                case "摘要":
                    newsDetail.setDigest(stuChild.getStringValue());
                    break;
                case "作者":
                    newsDetail.setAuthor(stuChild.getStringValue());
                    break;
                case "通讯员":
                    newsDetail.setCorrespondent(stuChild.getStringValue());
                    break;
                case "栏目":
                    newsDetail.setColumn(stuChild.getStringValue());
                    break;
                case "图片说明":
                    newsDetail.setPhotoDescription(stuChild.getStringValue());
                    break;
                case "下转":
                    newsDetail.setDownward(stuChild.getStringValue());
                    break;
                case "上接":
                    newsDetail.setUp(stuChild.getStringValue());
                    break;
                case "序号":
                    newsDetail.setSerialNumber(stuChild.getStringValue());
                    break;
                case "分类":
                    newsDetail.setClassification(stuChild.getStringValue());
                    break;
                case "体裁":
                    newsDetail.setGenre(stuChild.getStringValue());
                    break;
                case "转载":
                    newsDetail.setTransfer(stuChild.getStringValue());
                    break;
                case "文件名":
                    newsDetail.setFileName(stuChild.getStringValue());
                    break;
                case "关联项":
                    newsDetail.setRelatedItem(stuChild.getStringValue());
                    break;
                case "字数":
                    newsDetail.setNumberOfWords(stuChild.getStringValue());
                    break;
                case "版面图映射":
                    newsDetail.setLayoutMap(getLayoutMap(stuChild));
                    break;
                case "内容":
                    newsDetail.setContent(stuChild.getStringValue());
                    break;
                case "附图":
                    newsDetail.setAttachedDrawing(getAttachedDrawing(stuChild));
                    break;
                default:
            }
        }

        return newsDetail;
    }

    private NewsDescription getNewsDescription(Element stu) {
        if (stu == null) {
            return null;
        }

        NewsDescription newsDescription = new NewsDescription();

        Iterator iterator1 = stu.elementIterator();
        while (iterator1.hasNext()) {
            Element stuChild = (Element) iterator1.next();

            switch (stuChild.getName()) {
                case "日期":
                    newsDescription.setDate(stuChild.getStringValue());
                    break;
                case "版次":
                    newsDescription.setEdition(stuChild.getStringValue());
                    break;
                case "版名":
                    newsDescription.setEditionName(stuChild.getStringValue());
                    break;
                case "组版人":
                    newsDescription.setGroupEdition(stuChild.getStringValue());
                    break;
                case "报名":
                    newsDescription.setRegistration(stuChild.getStringValue());
                    break;
                case "版面真名":
                    newsDescription.setRealName(stuChild.getStringValue());
                    break;
                case "文件名":
                    newsDescription.setFileName(stuChild.getStringValue());
                    break;
                case "签发部门":
                    newsDescription.setIssuingDepartment(stuChild.getStringValue());
                    break;
                case "签发人":
                    newsDescription.setIssuer(stuChild.getStringValue());
                    break;
                case "版面编辑":
                    newsDescription.setLayoutEditor(stuChild.getStringValue());
                    break;
                case "版面高":
                    newsDescription.setLayoutHeight(stuChild.getStringValue());
                    break;
                case "版面宽":
                    newsDescription.setLayoutWidth(stuChild.getStringValue());
                    break;
                case "文本篇数":
                    newsDescription.setNumberOfTexts(stuChild.getStringValue());
                    break;
                case "图片篇数":
                    newsDescription.setNumberOfPictures(stuChild.getStringValue());
                    break;
                case "PDF":
                    newsDescription.setPdf(getPdf(stuChild));
                    break;
                case "版面图":
                    newsDescription.setLayoutImageBean(getLayoutImageBean(stuChild));
                    break;

                default:
            }
        }

        return newsDescription;
    }

    private NewsDescription.Pdf getPdf(Element stu) {
        if (stu == null) {
            return null;
        }

        NewsDescription.Pdf pdf = new NewsDescription.Pdf();

        Iterator iterator1 = stu.elementIterator();
        while (iterator1.hasNext()) {
            Element stuChild = (Element) iterator1.next();

            switch (stuChild.getName()) {
                case "文件名":
                    pdf.setFileName(stuChild.getStringValue());
                    break;
                default:
            }
        }
        return pdf;
    }

    private LayoutImageBean getLayoutImageBean(Element stu) {
        if (stu == null) {
            return null;
        }

        LayoutImageBean layoutImageBean = new LayoutImageBean();

        Iterator iterator1 = stu.elementIterator();
        while (iterator1.hasNext()) {
            Element stuChild = (Element) iterator1.next();

            switch (stuChild.getName()) {
                case "文件名":
                    layoutImageBean.setFileName(stuChild.getStringValue());
                    break;
                case "宽":
                    layoutImageBean.setWidth(stuChild.getStringValue());
                    break;
                case "高":
                    layoutImageBean.setHeight(stuChild.getStringValue());
                    break;
                case "真图":
                    layoutImageBean.setRealImageBean(getImageBean(stuChild));
                    break;
                case "标准图":
                    layoutImageBean.setStandardImageBean(getImageBean(stuChild));
                    break;
                case "简图":
                    layoutImageBean.setSimpleImageBean(getImageBean(stuChild));
                    break;
                case "图标":
                    layoutImageBean.setIconImageBean(getImageBean(stuChild));
                    break;
                default:
            }
        }
        return layoutImageBean;
    }

    private ImageBean getImageBean(Element stu) {
        if (stu == null) {
            return null;
        }

        ImageBean imageBean = new ImageBean();

        Iterator iterator1 = stu.elementIterator();
        while (iterator1.hasNext()) {
            Element stuChild = (Element) iterator1.next();

            switch (stuChild.getName()) {
                case "文件名":
                    imageBean.setFileName(stuChild.getStringValue());
                    break;
                case "宽":
                    imageBean.setWidth(stuChild.getStringValue());
                    break;
                case "高":
                    imageBean.setHeight(stuChild.getStringValue());
                    break;
                default:
            }
        }
        return imageBean;
    }

    private LayoutMap getLayoutMap(Element stu) {
        if (stu == null) {
            return null;
        }

        LayoutMap layoutMap = new LayoutMap();

        Iterator iterator1 = stu.elementIterator();
        while (iterator1.hasNext()) {
            Element stuChild = (Element) iterator1.next();

            switch (stuChild.getName()) {
                case "顶点个数":
                    layoutMap.setNumberOfVertices(stuChild.getStringValue());
                    break;
                case "顶点":
                    String s = stuChild.getStringValue();
                    String[] strings = s.replace("%", "").split(",");

                    Vertex vertex = new Vertex();

                    try {
                        vertex.setX(Float.valueOf(strings[0]));
                        vertex.setY(Float.valueOf(strings[1]));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }

                    layoutMap.addVertex(vertex);
                    break;
                default:
            }
        }
        return layoutMap;
    }

    private AttachedDrawing getAttachedDrawing(Element stu) {
        if (stu == null) {
            return null;
        }

        AttachedDrawing attachedDrawing = new AttachedDrawing();

        Iterator iterator1 = stu.elementIterator();
        while (iterator1.hasNext()) {
            Element stuChild = (Element) iterator1.next();

            switch (stuChild.getName()) {
                case "发布类型":
                    attachedDrawing.setReleaseType(stuChild.getStringValue());
                    break;
                case "发布":
                    attachedDrawing.setPublish(stuChild.getStringValue());
                    break;
                case "信息ID":
                    attachedDrawing.setInformationID(stuChild.getStringValue());
                    break;
                case "来源":
                    attachedDrawing.setSource(stuChild.getStringValue());
                    break;
                case "引题":
                    attachedDrawing.setQuotation(stuChild.getStringValue());
                    break;
                case "标题":
                    attachedDrawing.setTitle(stuChild.getStringValue());
                    break;
                case "副题":
                    attachedDrawing.setSubtitle(stuChild.getStringValue());
                    break;
                case "摘要":
                    attachedDrawing.setDigest(stuChild.getStringValue());
                    break;
                case "作者":
                    attachedDrawing.setAuthor(stuChild.getStringValue());
                    break;
                case "通讯员":
                    attachedDrawing.setCorrespondent(stuChild.getStringValue());
                    break;
                case "栏目":
                    attachedDrawing.setColumn(stuChild.getStringValue());
                    break;
                case "图片说明":
                    attachedDrawing.setPhotoDescription(stuChild.getStringValue());
                    break;
                case "下转":
                    attachedDrawing.setDownward(stuChild.getStringValue());
                    break;
                case "上接":
                    attachedDrawing.setUp(stuChild.getStringValue());
                    break;
                case "序号":
                    attachedDrawing.setSerialNumber(stuChild.getStringValue());
                    break;
                case "分类":
                    attachedDrawing.setClassification(stuChild.getStringValue());
                    break;
                case "体裁":
                    attachedDrawing.setGenre(stuChild.getStringValue());
                    break;
                case "转载":
                    attachedDrawing.setTransfer(stuChild.getStringValue());
                    break;
                case "文件名":
                    attachedDrawing.setFileName(stuChild.getStringValue());
                    break;
                case "关联项":
                    attachedDrawing.setRelatedItem(stuChild.getStringValue());
                    break;
                case "字数":
                    attachedDrawing.setNumberOfWords(stuChild.getStringValue());
                    break;
                case "版面图映射":
                    attachedDrawing.setLayoutMap(getLayoutMap(stuChild));
                    break;
                case "真图":
                    attachedDrawing.setRealImageBean(getImageBean(stuChild));
                    break;
                case "标准图":
                    attachedDrawing.setStandardImageBean(getImageBean(stuChild));
                    break;
                case "简图":
                    attachedDrawing.setSimpleImageBean(getImageBean(stuChild));
                    break;
                case "图标":
                    attachedDrawing.setIconImageBean(getImageBean(stuChild));
                    break;
                default:
            }
        }

        return attachedDrawing;
    }

}
