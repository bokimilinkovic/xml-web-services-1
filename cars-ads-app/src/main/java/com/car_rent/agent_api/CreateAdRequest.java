//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
<<<<<<< HEAD
// Generated on: 2020.07.12 at 06:56:02 AM CEST 
=======
// Generated on: 2020.07.12 at 04:49:14 AM CEST 
>>>>>>> master
//


package com.car_rent.agent_api;

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
 *         &lt;element name="adDetails" type="{http://car-rent.com/agent-api}AdFormDetails"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "adDetails",
    "email"
})
@XmlRootElement(name = "createAdRequest")
public class CreateAdRequest {

    @XmlElement(required = true)
    protected AdFormDetails adDetails;
    @XmlElement(required = true)
    protected String email;

    /**
     * Gets the value of the adDetails property.
     * 
     * @return
     *     possible object is
     *     {@link AdFormDetails }
     *     
     */
    public AdFormDetails getAdDetails() {
        return adDetails;
    }

    /**
     * Sets the value of the adDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdFormDetails }
     *     
     */
    public void setAdDetails(AdFormDetails value) {
        this.adDetails = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

}
