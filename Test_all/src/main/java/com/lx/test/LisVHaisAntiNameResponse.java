
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
 *         &lt;element name="Lis_V_Hais_AntiNameResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "lisVHaisAntiNameResult"
})
@XmlRootElement(name = "Lis_V_Hais_AntiNameResponse")
public class LisVHaisAntiNameResponse {

    @XmlElement(name = "Lis_V_Hais_AntiNameResult")
    protected String lisVHaisAntiNameResult;

    /**
     * ��ȡlisVHaisAntiNameResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLisVHaisAntiNameResult() {
        return lisVHaisAntiNameResult;
    }

    /**
     * ����lisVHaisAntiNameResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLisVHaisAntiNameResult(String value) {
        this.lisVHaisAntiNameResult = value;
    }

}
