
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
 *         &lt;element name="as_pubkey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="as_qmjg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="as_qmyw" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="inXML" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="imimage" type="{http://www.bsoft.com.cn/webservices/}Image" minOccurs="0"/&gt;
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
    "asPubkey",
    "asQmjg",
    "asQmyw",
    "inXML",
    "imimage"
})
@XmlRootElement(name = "SzCa_ValidSign_1")
public class SzCaValidSign1 {

    @XmlElement(name = "as_pubkey")
    protected String asPubkey;
    @XmlElement(name = "as_qmjg")
    protected String asQmjg;
    @XmlElement(name = "as_qmyw")
    protected String asQmyw;
    protected String inXML;
    protected Image imimage;

    /**
     * 获取asPubkey属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAsPubkey() {
        return asPubkey;
    }

    /**
     * 设置asPubkey属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAsPubkey(String value) {
        this.asPubkey = value;
    }

    /**
     * 获取asQmjg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAsQmjg() {
        return asQmjg;
    }

    /**
     * 设置asQmjg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAsQmjg(String value) {
        this.asQmjg = value;
    }

    /**
     * 获取asQmyw属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAsQmyw() {
        return asQmyw;
    }

    /**
     * 设置asQmyw属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAsQmyw(String value) {
        this.asQmyw = value;
    }

    /**
     * 获取inXML属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInXML() {
        return inXML;
    }

    /**
     * 设置inXML属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInXML(String value) {
        this.inXML = value;
    }

    /**
     * 获取imimage属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Image }
     *     
     */
    public Image getImimage() {
        return imimage;
    }

    /**
     * 设置imimage属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Image }
     *     
     */
    public void setImimage(Image value) {
        this.imimage = value;
    }

}
