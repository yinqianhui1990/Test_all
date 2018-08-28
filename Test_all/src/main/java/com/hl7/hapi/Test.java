package com.hl7.hapi;

import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.Terser;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/1/18.
 */
public class Test {
    public static void main(String[] args) throws Exception{
        Message message;
        Terser terser;
            String m = "MSH|^~\\&|hl7Integration|hl7Integration|||||ADT^A01|||2.3|\r" +
                    "EVN|A01|20130617154644\r" +
                    "PID|1|465 306 5961||407623|Wood^Patrick^^^MR||19700101|1|||High Street^^Oxford^^Ox1 4DP~George St^^Oxford^^Ox1 5AP|||||||\r" +
                    "NK1|1|Wood^John^^^MR|Father||999-9999\r"+
                    "NK1|2|Jones^Georgie^^^MSS|MOTHER||999-9999\r"+
                    "PV1|1||Location||||||||||||||||261938_6_201306171546|||||||||||||||||||||||||20130617134644|||||||||";
            //Parse the message
            String t="MSH|^~\\&|HIS||EAI||20150707103020||ADT^A01|40226923|P|2.4|||AL|AL|CHN\r" +
                    "EVN|A01|20150707103020|20150707103020|01|004003^余春联|20150707103020|HIS\r" +
                    "PID|1|0001193538|0001193538^^^^IDCard~0000356202^^^^PatientNO~^^^^IdentifyNO||周子辰||20150425000000|M|||广东省深圳市龙华新区^^^^518000^^H~无^^^^518000^^O~湖北省咸宁市市辖区^^^^518000^^N||^^^^^^^^15999551305|^^^^^^^^无||S^未婚||||||1^汉族|湖北省咸宁市市辖区|||||156^中国|||||||湖北省咸宁市市辖区|||1^自费\r" +
                    "NK1|1|曾丽燕|21^其他|同上|^^^^^^^^同上|^^^^^^^^无||||无|12\r" +
                    "PV1|1|I|9700^^^4700^儿科|1|||||||||2|1||0|005112|01|112996027|||||||||||||||||||||||||20150707103020\r" +
                    "DG1|||^肺炎|肺炎||11||||||||||005112";
            PipeParser pipeParser = new PipeParser();
           message = pipeParser.parse(t);
           terser = new Terser(message);
        //消息类型
           System.out.println("消息类型:"+terser.get("/MSH-9-2"));
        //消息id
           System.out.println("消息id:"+terser.get("/MSH-10"));
        //患者id
        System.out.println("患者id:"+terser.get("/PID-2"));

        System.out.println("诊疗卡号："+terser.get("/PID-3(0)-1"));
        System.out.println("诊疗卡:"+terser.get("/PID-3(0)-5"));

        System.out.println("住院号:"+terser.get("/PID-3(1)-1"));
        System.out.println("住院卡"+terser.get("/PID-3(1)-5"));

        System.out.println("身份证号:"+terser.get("/PID-3(2)-1"));
        System.out.println("身份证"+terser.get("/PID-3(2)-5"));
        System.out.println("姓名："+terser.get("/PID-5"));
        System.out.println("出生日期："+terser.get("/PID-7"));
        System.out.println("地址："+terser.get("/PID-11(0)-1"));
        System.out.println("邮政编码："+terser.get("/PID-11(0)-5"));
        System.out.println("电话号码："+terser.get("/PID-13-9"));
        System.out.println("是否结婚："+terser.get("/PID-13"));

    }
}
