
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
 *         &lt;element name="GetITFDrug_Right_LimitResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "getITFDrugRightLimitResult"
})
@XmlRootElement(name = "GetITFDrug_Right_LimitResponse")
public class GetITFDrugRightLimitResponse {

    @XmlElement(name = "GetITFDrug_Right_LimitResult")
    protected String getITFDrugRightLimitResult;

    /**
     * ��ȡgetITFDrugRightLimitResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetITFDrugRightLimitResult() {
        return getITFDrugRightLimitResult;
    }

    /**
     * ����getITFDrugRightLimitResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetITFDrugRightLimitResult(String value) {
        this.getITFDrugRightLimitResult = value;
    }

}
