
package com.lx.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="getResultInfoResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="flag" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="msg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="risCount" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="labCount" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "getResultInfoResult",
    "flag",
    "msg",
    "risCount",
    "labCount"
})
@XmlRootElement(name = "getResultInfoResponse")
public class GetResultInfoResponse {

    protected String getResultInfoResult;
    protected int flag;
    protected String msg;
    protected int risCount;
    protected int labCount;

    /**
     * ��ȡgetResultInfoResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetResultInfoResult() {
        return getResultInfoResult;
    }

    /**
     * ����getResultInfoResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetResultInfoResult(String value) {
        this.getResultInfoResult = value;
    }

    /**
     * ��ȡflag���Ե�ֵ��
     * 
     */
    public int getFlag() {
        return flag;
    }

    /**
     * ����flag���Ե�ֵ��
     * 
     */
    public void setFlag(int value) {
        this.flag = value;
    }

    /**
     * ��ȡmsg���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsg() {
        return msg;
    }

    /**
     * ����msg���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsg(String value) {
        this.msg = value;
    }

    /**
     * ��ȡrisCount���Ե�ֵ��
     * 
     */
    public int getRisCount() {
        return risCount;
    }

    /**
     * ����risCount���Ե�ֵ��
     * 
     */
    public void setRisCount(int value) {
        this.risCount = value;
    }

    /**
     * ��ȡlabCount���Ե�ֵ��
     * 
     */
    public int getLabCount() {
        return labCount;
    }

    /**
     * ����labCount���Ե�ֵ��
     * 
     */
    public void setLabCount(int value) {
        this.labCount = value;
    }

}
