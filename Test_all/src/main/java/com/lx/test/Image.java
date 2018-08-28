
package com.lx.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Image complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡtag���Ե�ֵ��
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
     * ����tag���Ե�ֵ��
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
     * ��ȡpalette���Ե�ֵ��
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
     * ����palette���Ե�ֵ��
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
