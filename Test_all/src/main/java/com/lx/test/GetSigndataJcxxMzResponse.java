
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
 *         &lt;element name="Get_Signdata_Jcxx_MzResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "getSigndataJcxxMzResult"
})
@XmlRootElement(name = "Get_Signdata_Jcxx_MzResponse")
public class GetSigndataJcxxMzResponse {

    @XmlElement(name = "Get_Signdata_Jcxx_MzResult")
    protected String getSigndataJcxxMzResult;

    /**
     * ��ȡgetSigndataJcxxMzResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetSigndataJcxxMzResult() {
        return getSigndataJcxxMzResult;
    }

    /**
     * ����getSigndataJcxxMzResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetSigndataJcxxMzResult(String value) {
        this.getSigndataJcxxMzResult = value;
    }

}
