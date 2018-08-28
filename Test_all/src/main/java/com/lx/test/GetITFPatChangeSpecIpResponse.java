
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
 *         &lt;element name="GetITFPat_Change_Spec_IpResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "getITFPatChangeSpecIpResult"
})
@XmlRootElement(name = "GetITFPat_Change_Spec_IpResponse")
public class GetITFPatChangeSpecIpResponse {

    @XmlElement(name = "GetITFPat_Change_Spec_IpResult")
    protected String getITFPatChangeSpecIpResult;

    /**
     * 获取getITFPatChangeSpecIpResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetITFPatChangeSpecIpResult() {
        return getITFPatChangeSpecIpResult;
    }

    /**
     * 设置getITFPatChangeSpecIpResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetITFPatChangeSpecIpResult(String value) {
        this.getITFPatChangeSpecIpResult = value;
    }

}
