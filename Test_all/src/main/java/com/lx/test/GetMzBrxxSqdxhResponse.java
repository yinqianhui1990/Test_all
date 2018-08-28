
package com.lx.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="GetMzBrxx_sqdxhResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "getMzBrxxSqdxhResult"
})
@XmlRootElement(name = "GetMzBrxx_sqdxhResponse")
public class GetMzBrxxSqdxhResponse {

    @XmlElement(name = "GetMzBrxx_sqdxhResult")
    protected String getMzBrxxSqdxhResult;

    /**
     * 获取getMzBrxxSqdxhResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetMzBrxxSqdxhResult() {
        return getMzBrxxSqdxhResult;
    }

    /**
     * 设置getMzBrxxSqdxhResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetMzBrxxSqdxhResult(String value) {
        this.getMzBrxxSqdxhResult = value;
    }

}
