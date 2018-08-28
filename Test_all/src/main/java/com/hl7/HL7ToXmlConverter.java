package com.hl7;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/1/18.
 */
public class HL7ToXmlConverter {
    public static String ConvertToXml(String sHL7)
    {
        Document document = ConvertToXmlObject(sHL7);
        String hl7str = document.asXML();
        return hl7str;
    }
    public static String ConvertToXml(Document document)
    {
        String hl7str = document.asXML();
        return hl7str;
    }
    public static Document ConvertToXmlObject(String sHL7)
    {
        Document document = CreateXmlDoc();
//��HL7�ֳɶ�
        String[] sHL7Lines = sHL7.split("\n");
//ȥ��XML�Ĺؼ���
        for (int i = 0; i < sHL7Lines.length; i++)
        {
            sHL7Lines[i] = sHL7Lines[i].replace("^~\\&", "").replace("MSH", "MSH|");
        }
        for (int i = 0; i < sHL7Lines.length; i++)
        {
// �ж��Ƿ����
            if (sHL7Lines[i] != null)
            {
                String sHL7Line = sHL7Lines[i];
//ͨ��/r ��/n �س����ָ�
                String[] sFields = GetMessgeFields(sHL7Line);
// Ϊ��(һ��)������һ���ڵ�
                Element el = document.getRootElement().addElement(sFields[0]);
// ѭ��ÿһ��
                Boolean isMsh=true;
                for (int a = 1; a < sFields.length; a++)
                {
//�Ƿ����HL7�����ӷ�^~\\&
                    if (sFields[a].indexOf('^')>0 || sFields[a].indexOf('~')>0 || sFields[a].indexOf('\\')>0 || sFields[a].indexOf('&')>0 )
                    {//0:�����һ������һ�ָ���
//��ʼ����~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//ͨ��~�ָ�
                        String[] sComponents = GetRepetitions(sFields[a]);
                        if (sComponents.length > 1)
                        {//1:������Էָ� 0001^����^����^EQ^AND~0002^��һ��^������^EQ^AND
                            for (int b = 0; b < sComponents.length; b++)
                            {
// Element fieldEl1 = el.addElement(sFields[0] + "." + a);
                                CreateComponents(el,sComponents[b],sFields[0],a,b);
                            }
                        }
                        else
                        {//1:������ֻ��һ��ֵ�� 0001^����^����^EQ^AND
// Ϊ�ֶδ����ڶ����ڵ�
// Element fieldEl = el.addElement(sFields[0] + "." + a);
                            CreateComponents(el,sFields[a],sFields[0],a,0);
//fieldEl.setText(sFields[a]+"11111111111111");
                        }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                    }
                    else
                    {//0:�����һ��û���κηָ���
// Ϊ�ֶδ����ڶ����ڵ�
                        Element fieldEl = el.addElement(sFields[0] + "." + a);
                        fieldEl.setText(sFields[a]);
                    }
                }
            }//end if
        }//end for
//�޸�MSH.1 �� MSH.2��ֵ
        document.selectSingleNode("HL7Message/MSH/MSH.1").setText("|");
        document.selectSingleNode("HL7Message/MSH/MSH.2").setText("~^\\&");
// document.selectNodes("MSH/MSH.1");
        return document;
    }
    @SuppressWarnings("unused")
    private static Element CreateComponents(final Element el,final String hl7Components,String sField,int a,int b)
    {
        Element componentEl = el.addElement(sField + "." + a);
// Element componentEl =el;//.addElement(sField + "." + a + "." + b);
//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
//ͨ��&�ָ�
        String[] subComponents = GetSubComponents(hl7Components);
        if (subComponents.length > 1)
        {//2.��������飬һ����û�еġ����� �ӷ��� ��&������
        }
        else
        {//2.���û���ˣ�����^����
            String[] sRepetitions = GetComponents(hl7Components);
            if (sRepetitions.length > 1)
            {
                Element repetitionEl = null;
                for (int c = 0; c < sRepetitions.length; c++)
                {
                    repetitionEl = componentEl.addElement(sField + "." + a + "." + (c+1));
                    repetitionEl.setText(sRepetitions[c]);
                }
            }
            else
            {
                componentEl.setText(hl7Components);
            }
        }
//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
        return el;
    }
    /// <summary>
/// ͨ��|�ָ� �ֶ�
/// </summary>
/// <param name="s"></param>
/// <returns></returns>
    private static String[] GetMessgeFields(String s)
    {
        return s.split("\\|");
    }
    /// <summary>
/// ͨ��^�ָ� ���ֶ�
/// </summary>
/// <param name="s"></param>
/// <returns></returns>
    private static String[] GetComponents(String s)
    {
        return s.split("\\^");
    }
    /// <summary>
/// ͨ��&�ָ� �ӷ������ֶ�
/// </summary>
/// <param name="s"></param>
/// <returns></returns>
    private static String[] GetSubComponents(String s)
    {
        return s.split("&");
    }
    /// <summary>
/// ͨ��~�ָ� �ظ�
/// </summary>
/// <param name="s"></param>
/// <returns></returns>
    private static String[] GetRepetitions(String s)
    {
        return s.split("~");
    }
    /// <summary>
/// ����XML����
/// </summary>
/// <returns></returns>
    private static Document CreateXmlDoc()
    {
        Document output = DocumentHelper.createDocument();
//����һ���ӵ�
        Element rootNode = output.addElement("HL7Message");
        return output;
    }
    public static String GetText(Document document, String path)
    {
        Node node = document.selectSingleNode("HL7Message/"+path);
        if (node != null)
        {
            return node.getText();
        }
        else
        {
            return null;
        }
    }
    public static String GetText(Document document, String path,int index)
    {
        List nodes = document.selectNodes("HL7Message/"+path);
        if(nodes!=null)
        {
            return ((Node)nodes.get(index)).getText();
        }
        else
        {
            return null;
        }
    }
    public static List GetTexts(Document document, String path)
    {
        List nodes = document.selectNodes("HL7Message/"+path);
        return nodes;
    }
    public static void writeDocument(Document document, String filepath){
        try{
//��ȡ�ļ�
// FileWriter fileWriter = new FileWriter(filepath);
            Writer writer = new OutputStreamWriter(new FileOutputStream(filepath),"utf-8");
//�����ļ�����
            OutputFormat xmlFormat = new OutputFormat();
            xmlFormat.setEncoding("utf-8");
//����д�ļ�����
            XMLWriter xmlWriter = new XMLWriter(writer,xmlFormat);
//д���ļ�
            xmlWriter.write(document);
//�ر�
            xmlWriter.close();
        }catch(IOException e){
            System.out.println("�ļ�û���ҵ�");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String myHL7string="MSH|^~\\&|455755610_0100||0200||20110624160404|000|QRY^A19^QRY_A19|0123456001|P|2.6\nQRD|||||||||0001^����^����^EQ^AND~0002^��һ��^������^EQ^AND\nQRF||20110627|20110803";
        Document document = HL7ToXmlConverter.ConvertToXmlObject(myHL7string);
//��ȡ�¼�
        String eventName = HL7ToXmlConverter.GetText(document, "MSH/MSH.9/MSH.9.3");
        System.out.println("eventName:"+eventName);
// List nodeValue = document.selectNodes("MSH.1");
        String nodeValue = document.selectSingleNode("HL7Message/MSH/MSH.1").getText();
        String nodeValue2 = document.selectSingleNode("HL7Message/MSH/MSH.3").getText();
// DocumentElement.SelectNodes(path);
        System.out.println(nodeValue+":"+nodeValue2);
        String value = HL7ToXmlConverter.GetText(document, "QRD/QRD.9/QRD.9.1",0);
        String value1 = HL7ToXmlConverter.GetText(document, "QRD/QRD.9/QRD.9.1",1);
        String value2 = HL7ToXmlConverter.GetText(document, "QRD/QRD.9/QRD.9.1");
        System.out.println(value+":"+value1+":"+value2);
        List<Node> list = HL7ToXmlConverter.GetTexts(document, "QRD/QRD.9/QRD.9.1");
        for(Node node : list)
        {
            System.out.println(":"+node.getText());
        }
        System.out.println(HL7ToXmlConverter.ConvertToXml(myHL7string));
    }
}
