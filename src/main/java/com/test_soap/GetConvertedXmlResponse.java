
package com.test_soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="convertedXmlText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "convertedXmlText"
})
@XmlRootElement(name = "getConvertedXmlResponse")
public class GetConvertedXmlResponse {

    @XmlElement(required = true)
    protected String convertedXmlText;

    /**
     * Gets the value of the convertedXmlText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConvertedXmlText() {
        return convertedXmlText;
    }

    /**
     * Sets the value of the convertedXmlText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConvertedXmlText(String value) {
        this.convertedXmlText = value;
    }

}
