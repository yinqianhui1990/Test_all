
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
 *         &lt;element name="GetITFDrug_Classify_RelationResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "getITFDrugClassifyRelationResult"
})
@XmlRootElement(name = "GetITFDrug_Classify_RelationResponse")
public class GetITFDrugClassifyRelationResponse {

    @XmlElement(name = "GetITFDrug_Classify_RelationResult")
    protected String getITFDrugClassifyRelationResult;

    /**
     * ��ȡgetITFDrugClassifyRelationResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetITFDrugClassifyRelationResult() {
        return getITFDrugClassifyRelationResult;
    }

    /**
     * ����getITFDrugClassifyRelationResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetITFDrugClassifyRelationResult(String value) {
        this.getITFDrugClassifyRelationResult = value;
    }

}