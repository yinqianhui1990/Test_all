
package com.lx.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Image complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Image"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.bsoft.com.cn/webservices/}MarshalByRefObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Tag" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *         &lt;element name="Palette" type="{http://www.bsoft.com.cn/webservices/}ColorPalette" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Image", propOrder = {
    "tag",
    "palette"
})
public abstract class Image
    extends MarshalByRefObject
{

    @XmlElement(name = "Tag")
    protected Object tag;
    @XmlElement(name = "Palette")
    protected ColorPalette palette;

    /**
     * 获取tag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getTag() {
        return tag;
    }

    /**
     * 设置tag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setTag(Object value) {
        this.tag = value;
    }

    /**
     * 获取palette属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ColorPalette }
     *     
     */
    public ColorPalette getPalette() {
        return palette;
    }

    /**
     * 设置palette属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ColorPalette }
     *     
     */
    public void setPalette(ColorPalette value) {
        this.palette = value;
    }

}
