
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
 *         &lt;element name="Pacs_GetReportInfo_MzResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "pacsGetReportInfoMzResult"
})
@XmlRootElement(name = "Pacs_GetReportInfo_MzResponse")
public class PacsGetReportInfoMzResponse {

    @XmlElement(name = "Pacs_GetReportInfo_MzResult")
    protected String pacsGetReportInfoMzResult;

    /**
     * ��ȡpacsGetReportInfoMzResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPacsGetReportInfoMzResult() {
        return pacsGetReportInfoMzResult;
    }

    /**
     * ����pacsGetReportInfoMzResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPacsGetReportInfoMzResult(String value) {
        this.pacsGetReportInfoMzResult = value;
    }

}
