
package com.lx.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取getResultInfoResult属性的值。
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
     * 设置getResultInfoResult属性的值。
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
     * 获取flag属性的值。
     * 
     */
    public int getFlag() {
        return flag;
    }

    /**
     * 设置flag属性的值。
     * 
     */
    public void setFlag(int value) {
        this.flag = value;
    }

    /**
     * 获取msg属性的值。
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
     * 设置msg属性的值。
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
     * 获取risCount属性的值。
     * 
     */
    public int getRisCount() {
        return risCount;
    }

    /**
     * 设置risCount属性的值。
     * 
     */
    public void setRisCount(int value) {
        this.risCount = value;
    }

    /**
     * 获取labCount属性的值。
     * 
     */
    public int getLabCount() {
        return labCount;
    }

    /**
     * 设置labCount属性的值。
     * 
     */
    public void setLabCount(int value) {
        this.labCount = value;
    }

}
