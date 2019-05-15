package com.demo.dingsheng.util;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * created by tea9 at 2018/11/24
 * 解析生成的xml文件
 */
public class DOMTest {
    public static void main(String[] args) {

//        Map<String, Integer> coordinateWithResourceId = getCoordinateWithResourceId("com.tencent.mm:id/hv", "/Users/shaomiao/Desktop/zz.xml");
//        Map<String, Map<String, Integer>> coordinateWithResourceId = getCoordinateListWithResourceId("cn.youth.news:id/tv_home_tab", "/Users/shaomiao/Desktop/aaa.xml");
//        Map<String, Integer> coordinateWithResourceId = getCoordinateWithText("1");

//        Map<String, Integer> coordinateWithResourceId = getCoordinateWithText("二维码已失效，请使用其他付款\n" +
//                "方式。","/Users/shaomiao/Desktop/dd.xml");

//        System.out.println(coordinateWithResourceId);

//        /Users/shaomiao/Desktop/mmm.xml

//        getXY("cn.youth.news:id/tv_article_title","/Users/shaomiao/Desktop/mmm.xml");

//        System.out.println(getCoordinateWithResourceId("cn.youth.news:id/tv_article_title","/Users/shaomiao/Desktop/mmm.xml"));

//        Map<String, Integer> xx = getCoordinateWithContentDesc("立即签到","/Users/shaomiao/Desktop/shaomiao.xml");
//        System.out.println(xx);


//        Map<String, Map<String, Integer>> coordinateWithResourceId = getCoordinateWithTextDongFang("com.songheng.eastnews:id/nu", "/Users/shaomiao/Desktop/sss.xml");
//        System.out.println(coordinateWithResourceId);
        getCoordinateWithText("抱歉","/Users/shaomiao/Desktop/dump.xml");

    }

    private static void getXY(String resourceID, String fileUrl) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            File file = new File(fileUrl);
            Document document = db.parse(file);
            System.out.println("document:" + document.getDocumentElement().getTagName());
            System.out.println("document:" + document.getNodeValue());

            NodeList node = document.getElementsByTagName("node");

            int bookCnt = node.getLength();
            for (int i = 0; i < bookCnt; i++) {
                Node book = node.item(i);
                System.out.println("node:" + book.getNodeValue());
                NamedNodeMap attrs = book.getAttributes();
                if (attrs.getNamedItem("resource-id").getNodeValue().equals(resourceID)) {

                    System.out.println("reid" + attrs.getNamedItem("bounds").getNodeValue());
//                    return getChildCoordnate(attrs.getNamedItem("bounds").getNodeValue());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
//        return null;
    }

    /**
     * 根据资源id获取坐标
     */
//    public static Map<String, Integer> getCoordinateWithResourceId(String resourceID, String fileUrl) {
//        Map<String, Integer> childCoordnate = new HashMap<>();
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        try {
//            DocumentBuilder db = dbf.newDocumentBuilder();
////            File file = new File(Environment.getExternalStorageDirectory(), fileUrl);
//            File file = new File(fileUrl);
//            Document document = db.parse(file);
//            NodeList node = document.getElementsByTagName("node");
//            int bookCnt = node.getLength();
//            for (int i = 0; i < bookCnt; i++) {
//                Node book = node.item(i);
//                NamedNodeMap attrs = book.getAttributes();
//
//                for (int j = 0; j < attrs.getLength(); j++) {
//                    Node attr = attrs.item(j);
//                    if ("bounds".equals(attr.getNodeName())) {
//                        childCoordnate = getChildCoordnate(attr.getNodeValue());
//                    }
//                    if (resourceID.equals(attr.getNodeValue())) {
//                        return childCoordnate;
//                    }
//                }
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    public static Map<String, Integer> getCoordinateWithResourceId(String resourceID, String fileUrl) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            File file = new File(fileUrl);
            Document document = db.parse(file);
            NodeList node = document.getElementsByTagName("node");
            int bookCnt = node.getLength();

            for (int i = 0; i < bookCnt; i++) {
                Node book = node.item(i);
                NamedNodeMap attrs = book.getAttributes();
                if (attrs.getNamedItem("resource-id").getNodeValue().equals(resourceID)) {
                    return getChildCoordnate(attrs.getNamedItem("bounds").getNodeValue());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据资源id获取坐标 返回集合List
     */
    public static Map<String, Map<String, Integer>> getCoordinateListWithResourceId(String resourceID, String fileUrl) {
        int index = 0;
        Map<String, Map<String, Integer>> childCoordnate = new HashMap<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();

            File file = new File(fileUrl);
            Document document = db.parse(file);
            NodeList node = document.getElementsByTagName("node");
            int bookCnt = node.getLength();
            for (int i = 0; i < bookCnt; i++) {
                Node book = node.item(i);
                NamedNodeMap attrs = book.getAttributes();
                for (int j = 0; j < attrs.getLength(); j++) {
                    if (attrs.getNamedItem("resource-id").getNodeValue().equals(resourceID)) {
                        childCoordnate.put(index + "", getChildCoordnate(attrs.getNamedItem("bounds").getNodeValue()));
                        index++;
                        break;
                    }
                }
            }
            return childCoordnate;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Integer> getCoordinateWithText(String text, String fileUrl) {
        Map<String, Integer> childCoordnate = new HashMap<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder db = dbf.newDocumentBuilder();
            File file = new File(fileUrl);
            Document document = db.parse(file);
            NodeList node = document.getElementsByTagName("node");
            int bookCnt = node.getLength();

            for (int i = 0; i < bookCnt; i++) {
                Node book = node.item(i);
                NamedNodeMap attrs = book.getAttributes();
                for (int j = 0; j < attrs.getLength(); j++) {
                    Node attr = attrs.item(j);
                    if ("bounds".equals(attr.getNodeName())) {
                        childCoordnate = getChildCoordnate(attr.getNodeValue());
                    }
                    if ("text".equals(attr.getNodeName())) {
                        //equals换成contains应该就可以了
                        if (text.equals(attr.getNodeValue())) {
                            return childCoordnate;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Integer> getCoordinateWithContentDesc(String text, String fileUrl) {
        Map<String, Integer> childCoordnate = new HashMap<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder db = dbf.newDocumentBuilder();
            File file = new File(fileUrl);
            Document document = db.parse(file);
            NodeList node = document.getElementsByTagName("node");
            int bookCnt = node.getLength();

            for (int i = 0; i < bookCnt; i++) {
                Node book = node.item(i);
                NamedNodeMap attrs = book.getAttributes();
                for (int j = 0; j < attrs.getLength(); j++) {
                    Node attr = attrs.item(j);
                    if ("bounds".equals(attr.getNodeName())) {
                        childCoordnate = getChildCoordnate(attr.getNodeValue());
                    }
                    if ("content-desc".equals(attr.getNodeName())) {
                        //equals换成contains应该就可以了
                        if (text.equals(attr.getNodeValue())) {
                            return childCoordnate;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据坐标字符串获取精确坐标
     *
     * @param nodeValue
     * @return
     */
    public static Map<String, Integer> getChildCoordnate(String nodeValue) {
        Map<String, Integer> map = new HashMap<>();
        int x1, x2, y1, y2;

        x1 = Integer.parseInt(nodeValue.substring(1, nodeValue.indexOf(",")));
        y1 = Integer.parseInt(nodeValue.substring(nodeValue.indexOf(",") + 1, nodeValue.indexOf("]")));

        x2 = Integer.parseInt(nodeValue.substring(nodeValue.indexOf("]") + 2, nodeValue.lastIndexOf(",")));
        y2 = Integer.parseInt(nodeValue.substring(nodeValue.lastIndexOf(",") + 1, nodeValue.lastIndexOf("]")));

        map.put("x1", x1);

        map.put("x2", x2);

        map.put("y1", y1);

        map.put("y2", y2);

        return map;
    }

    /**
     * 去广告
     *
     * @param text
     * @param fileUrl
     * @return
     */
    public static Map<String, Integer> getCoordinateWithTextDongFangTouTiao(String text, String fileUrl) {
        Map<String, Integer> childCoordnate = new HashMap<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder db = dbf.newDocumentBuilder();
            File file = new File(fileUrl);
            Document document = db.parse(file);
            NodeList node = document.getElementsByTagName("node");
            int bookCnt = node.getLength();

            for (int i = 0; i < bookCnt; i++) {
                Node book = node.item(i);
                NamedNodeMap attrs = book.getAttributes();
                for (int j = 0; j < attrs.getLength(); j++) {
                    Node attr = attrs.item(j);
                    if ("bounds".equals(attr.getNodeName())) {
                        childCoordnate = getChildCoordnate(attr.getNodeValue());
                    }
                    if ("content-desc".equals(attr.getNodeName())) {
                        if (text.equals(attr.getNodeValue())) {
                            return childCoordnate;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 蚂蚁头条去广告
     *
     * @param id      com.ldzs.zhangxin:id/tv_article_title
     * @param fileUrl E:\\uidump.xml
     * @return
     */
    public static Map<String, Integer> getCoordinateWithTextMayi(String id, String fileUrl) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder db = dbf.newDocumentBuilder();
            File file = new File(fileUrl);
            Document document = db.parse(file);
            NodeList node = document.getElementsByTagName("node");
            int bookCnt = node.getLength();

            for (int i = 0; i < bookCnt; i++) {
                Node book = node.item(i);
                NamedNodeMap attrs = book.getAttributes();
                if (attrs.getNamedItem("resource-id").getNodeValue().equals(id)) {
                    NamedNodeMap attributes = node.item(i + 4).getAttributes();
                    if (!attributes.getNamedItem("text").getNodeValue().equals("广告")) {
                        return getChildCoordnate(attrs.getNamedItem("bounds").getNodeValue());
                    }
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Map<String, Integer>> getCoordinateWithTextDongFang(String id, String fileUrl) {
        int index = 0;
        Map<String, Map<String, Integer>> childCoordnate = new HashMap<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();

            File file = new File(fileUrl);
            Document document = db.parse(file);
            NodeList node = document.getElementsByTagName("node");
            int bookCnt = node.getLength();
            for (int i = 0; i < bookCnt; i++) {
                Node book = node.item(i);
                NamedNodeMap attrs = book.getAttributes();
                for (int j = 0; j < attrs.getLength(); j++) {
                    if (attrs.getNamedItem("resource-id").getNodeValue().equals(id)) {
                        System.out.println( String.valueOf(getChildCoordnate(attrs.getNamedItem("bounds").getNodeValue())));
                        NamedNodeMap attributes = node.item(i+11).getAttributes();
                        if (!attributes.getNamedItem("text").getNodeValue().equals("广告")) {
                            childCoordnate.put(index + "", getChildCoordnate(attrs.getNamedItem("bounds").getNodeValue()));
                            index++;
                        }
                        break;
                    }
                }
            }
            return childCoordnate;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
