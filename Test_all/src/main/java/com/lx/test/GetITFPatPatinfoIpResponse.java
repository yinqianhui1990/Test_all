
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
 *         &lt;element name="GetITFPat_Patinfo_IpResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "getITFPatPatinfoIpResult"
})
@XmlRootElement(name = "GetITFPat_Patinfo_IpResponse")
public class GetITFPatPatinfoIpResponse {

    @XmlElement(name = "GetITFPat_Patinfo_IpResult")
    protected String getITFPatPatinfoIpResult;

    /**
     * 获取getITFPatPatinfoIpResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetITFPatPatinfoIpResult() {
        return getITFPatPatinfoIpResult;
    }

    /**
     * 设置getITFPatPatinfoIpResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetITFPatPatinfoIpResult(String value) {
        this.getITFPatPatinfoIpResult = value;
    }

}
