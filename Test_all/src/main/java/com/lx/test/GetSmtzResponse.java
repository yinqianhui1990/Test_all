
package com.lx.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Get_SmtzResult" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getSmtzResult"
})
@XmlRootElement(name = "Get_SmtzResponse")
public class GetSmtzResponse {

    @XmlElement(name = "Get_SmtzResult")
    protected int getSmtzResult;

    /**
     * ��ȡgetSmtzResult���Ե�ֵ��
     * 
     */
    public int getGetSmtzResult() {
        return getSmtzResult;
    }

    /**
     * ����getSmtzResult���Ե�ֵ��
     * 
     */
    public void setGetSmtzResult(int value) {
        this.getSmtzResult = value;
    }

}
