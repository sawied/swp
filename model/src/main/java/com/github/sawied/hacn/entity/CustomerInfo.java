
package com.github.sawied.hacn.entity;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for CustomerInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomerInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="companyType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contactCheckPhoneTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="customerBirthday" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="customerBuyType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerCarNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="customerCertiNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerCertiType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerEmail" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerHouseAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerHouseHold" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerHouseNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="customerHouseStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerLiveAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerMarriageStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerMinorChildrenNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="customerMobile" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerMonthAfterTaxIncome" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="customerName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerNation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerSex" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerSpouseCertiNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerSpouseHouseHold" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerSpouseLiveAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerSpouseMobile" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerSpouseName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerSpouseWorkPhone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerWorkAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerWorkPosition" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerWorkUnit" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerYearAfterTaxIncome" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="customerYearsOfWorking" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="customerhomePhone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cutomerWorkPhone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="educationLevelOther" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="emergencyContactCheck" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="emergencyContactCheckPhone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="emergencyContactCheckUser" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="emergencyContactPerson" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="emergencyContactPhone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isDrivingLicense" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isHavaCar" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isHaveAccFund" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isHaveSocialSecurity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isInHacn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isReceiveEmail" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isReceiveSms" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isSpouseDrivingLicense" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="loanAppNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="relationship" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="relativeName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="systemType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerInfo", propOrder = {
    "companyType",
    "contactCheckPhoneTime",
    "customerBirthday",
    "customerBuyType",
    "customerCarNum",
    "customerCertiNo",
    "customerCertiType",
    "customerEmail",
    "customerHouseAddress",
    "customerHouseHold",
    "customerHouseNum",
    "customerHouseStatus",
    "customerLiveAddress",
    "customerMarriageStatus",
    "customerMinorChildrenNum",
    "customerMobile",
    "customerMonthAfterTaxIncome",
    "customerName",
    "customerNation",
    "customerSex",
    "customerSpouseCertiNo",
    "customerSpouseHouseHold",
    "customerSpouseLiveAddress",
    "customerSpouseMobile",
    "customerSpouseName",
    "customerSpouseWorkPhone",
    "customerWorkAddress",
    "customerWorkPosition",
    "customerWorkUnit",
    "customerYearAfterTaxIncome",
    "customerYearsOfWorking",
    "customerhomePhone",
    "cutomerWorkPhone",
    "educationLevelOther",
    "emergencyContactCheck",
    "emergencyContactCheckPhone",
    "emergencyContactCheckUser",
    "emergencyContactPerson",
    "emergencyContactPhone",
    "isDrivingLicense",
    "isHavaCar",
    "isHaveAccFund",
    "isHaveSocialSecurity",
    "isInHacn",
    "isReceiveEmail",
    "isReceiveSms",
    "isSpouseDrivingLicense",
    "loanAppNo",
    "relationship",
    "relativeName",
    "systemType"
},namespace="http://entity.hangseng.com")
public class CustomerInfo {

    @XmlElement(required = true, nillable = true)
    protected String companyType;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar contactCheckPhoneTime;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar customerBirthday;
    @XmlElement(required = true, nillable = true)
    protected String customerBuyType;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer customerCarNum;
    @XmlElement(required = true, nillable = true)
    protected String customerCertiNo;
    @XmlElement(required = true, nillable = true)
    protected String customerCertiType;
    @XmlElement(required = true, nillable = true)
    protected String customerEmail;
    @XmlElement(required = true, nillable = true)
    protected String customerHouseAddress;
    @XmlElement(required = true, nillable = true)
    protected String customerHouseHold;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer customerHouseNum;
    @XmlElement(required = true, nillable = true)
    protected String customerHouseStatus;
    @XmlElement(required = true, nillable = true)
    protected String customerLiveAddress;
    @XmlElement(required = true, nillable = true)
    protected String customerMarriageStatus;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer customerMinorChildrenNum;
    @XmlElement(required = true, nillable = true)
    protected String customerMobile;
    @XmlElement(required = true, nillable = true)
    protected BigDecimal customerMonthAfterTaxIncome;
    @XmlElement(required = true, nillable = true)
    protected String customerName;
    @XmlElement(required = true, nillable = true)
    protected String customerNation;
    @XmlElement(required = true, nillable = true)
    protected String customerSex;
    @XmlElement(required = true, nillable = true)
    protected String customerSpouseCertiNo;
    @XmlElement(required = true, nillable = true)
    protected String customerSpouseHouseHold;
    @XmlElement(required = true, nillable = true)
    protected String customerSpouseLiveAddress;
    @XmlElement(required = true, nillable = true)
    protected String customerSpouseMobile;
    @XmlElement(required = true, nillable = true)
    protected String customerSpouseName;
    @XmlElement(required = true, nillable = true)
    protected String customerSpouseWorkPhone;
    @XmlElement(required = true, nillable = true)
    protected String customerWorkAddress;
    @XmlElement(required = true, nillable = true)
    protected String customerWorkPosition;
    @XmlElement(required = true, nillable = true)
    protected String customerWorkUnit;
    @XmlElement(required = true, nillable = true)
    protected BigDecimal customerYearAfterTaxIncome;
    @XmlElement(required = true, nillable = true)
    protected BigDecimal customerYearsOfWorking;
    @XmlElement(required = true, nillable = true)
    protected String customerhomePhone;
    @XmlElement(required = true, nillable = true)
    protected String cutomerWorkPhone;
    @XmlElement(required = true, nillable = true)
    protected String educationLevelOther;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar emergencyContactCheck;
    @XmlElement(required = true, nillable = true)
    protected String emergencyContactCheckPhone;
    @XmlElement(required = true, nillable = true)
    protected String emergencyContactCheckUser;
    @XmlElement(required = true, nillable = true)
    protected String emergencyContactPerson;
    @XmlElement(required = true, nillable = true)
    protected String emergencyContactPhone;
    @XmlElement(required = true, nillable = true)
    protected String isDrivingLicense;
    @XmlElement(required = true, nillable = true)
    protected String isHavaCar;
    @XmlElement(required = true, nillable = true)
    protected String isHaveAccFund;
    @XmlElement(required = true, nillable = true)
    protected String isHaveSocialSecurity;
    @XmlElement(required = true, nillable = true)
    protected String isInHacn;
    @XmlElement(required = true, nillable = true)
    protected String isReceiveEmail;
    @XmlElement(required = true, nillable = true)
    protected String isReceiveSms;
    @XmlElement(required = true, nillable = true)
    protected String isSpouseDrivingLicense;
    @XmlElement(required = true, nillable = true)
    protected String loanAppNo;
    @XmlElement(required = true, nillable = true)
    protected String relationship;
    @XmlElement(required = true, nillable = true)
    protected String relativeName;
    @XmlElement(required = true, nillable = true)
    protected String systemType;

    /**
     * Gets the value of the companyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyType() {
        return companyType;
    }

    /**
     * Sets the value of the companyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyType(String value) {
        this.companyType = value;
    }

    /**
     * Gets the value of the contactCheckPhoneTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getContactCheckPhoneTime() {
        return contactCheckPhoneTime;
    }

    /**
     * Sets the value of the contactCheckPhoneTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setContactCheckPhoneTime(XMLGregorianCalendar value) {
        this.contactCheckPhoneTime = value;
    }

    /**
     * Gets the value of the customerBirthday property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCustomerBirthday() {
        return customerBirthday;
    }

    /**
     * Sets the value of the customerBirthday property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCustomerBirthday(XMLGregorianCalendar value) {
        this.customerBirthday = value;
    }

    /**
     * Gets the value of the customerBuyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerBuyType() {
        return customerBuyType;
    }

    /**
     * Sets the value of the customerBuyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerBuyType(String value) {
        this.customerBuyType = value;
    }

    /**
     * Gets the value of the customerCarNum property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCustomerCarNum() {
        return customerCarNum;
    }

    /**
     * Sets the value of the customerCarNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCustomerCarNum(Integer value) {
        this.customerCarNum = value;
    }

    /**
     * Gets the value of the customerCertiNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerCertiNo() {
        return customerCertiNo;
    }

    /**
     * Sets the value of the customerCertiNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerCertiNo(String value) {
        this.customerCertiNo = value;
    }

    /**
     * Gets the value of the customerCertiType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerCertiType() {
        return customerCertiType;
    }

    /**
     * Sets the value of the customerCertiType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerCertiType(String value) {
        this.customerCertiType = value;
    }

    /**
     * Gets the value of the customerEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerEmail() {
        return customerEmail;
    }

    /**
     * Sets the value of the customerEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerEmail(String value) {
        this.customerEmail = value;
    }

    /**
     * Gets the value of the customerHouseAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerHouseAddress() {
        return customerHouseAddress;
    }

    /**
     * Sets the value of the customerHouseAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerHouseAddress(String value) {
        this.customerHouseAddress = value;
    }

    /**
     * Gets the value of the customerHouseHold property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerHouseHold() {
        return customerHouseHold;
    }

    /**
     * Sets the value of the customerHouseHold property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerHouseHold(String value) {
        this.customerHouseHold = value;
    }

    /**
     * Gets the value of the customerHouseNum property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCustomerHouseNum() {
        return customerHouseNum;
    }

    /**
     * Sets the value of the customerHouseNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCustomerHouseNum(Integer value) {
        this.customerHouseNum = value;
    }

    /**
     * Gets the value of the customerHouseStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerHouseStatus() {
        return customerHouseStatus;
    }

    /**
     * Sets the value of the customerHouseStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerHouseStatus(String value) {
        this.customerHouseStatus = value;
    }

    /**
     * Gets the value of the customerLiveAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerLiveAddress() {
        return customerLiveAddress;
    }

    /**
     * Sets the value of the customerLiveAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerLiveAddress(String value) {
        this.customerLiveAddress = value;
    }

    /**
     * Gets the value of the customerMarriageStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerMarriageStatus() {
        return customerMarriageStatus;
    }

    /**
     * Sets the value of the customerMarriageStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerMarriageStatus(String value) {
        this.customerMarriageStatus = value;
    }

    /**
     * Gets the value of the customerMinorChildrenNum property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCustomerMinorChildrenNum() {
        return customerMinorChildrenNum;
    }

    /**
     * Sets the value of the customerMinorChildrenNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCustomerMinorChildrenNum(Integer value) {
        this.customerMinorChildrenNum = value;
    }

    /**
     * Gets the value of the customerMobile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerMobile() {
        return customerMobile;
    }

    /**
     * Sets the value of the customerMobile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerMobile(String value) {
        this.customerMobile = value;
    }

    /**
     * Gets the value of the customerMonthAfterTaxIncome property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCustomerMonthAfterTaxIncome() {
        return customerMonthAfterTaxIncome;
    }

    /**
     * Sets the value of the customerMonthAfterTaxIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCustomerMonthAfterTaxIncome(BigDecimal value) {
        this.customerMonthAfterTaxIncome = value;
    }

    /**
     * Gets the value of the customerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the value of the customerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerName(String value) {
        this.customerName = value;
    }

    /**
     * Gets the value of the customerNation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerNation() {
        return customerNation;
    }

    /**
     * Sets the value of the customerNation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerNation(String value) {
        this.customerNation = value;
    }

    /**
     * Gets the value of the customerSex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerSex() {
        return customerSex;
    }

    /**
     * Sets the value of the customerSex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerSex(String value) {
        this.customerSex = value;
    }

    /**
     * Gets the value of the customerSpouseCertiNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerSpouseCertiNo() {
        return customerSpouseCertiNo;
    }

    /**
     * Sets the value of the customerSpouseCertiNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerSpouseCertiNo(String value) {
        this.customerSpouseCertiNo = value;
    }

    /**
     * Gets the value of the customerSpouseHouseHold property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerSpouseHouseHold() {
        return customerSpouseHouseHold;
    }

    /**
     * Sets the value of the customerSpouseHouseHold property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerSpouseHouseHold(String value) {
        this.customerSpouseHouseHold = value;
    }

    /**
     * Gets the value of the customerSpouseLiveAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerSpouseLiveAddress() {
        return customerSpouseLiveAddress;
    }

    /**
     * Sets the value of the customerSpouseLiveAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerSpouseLiveAddress(String value) {
        this.customerSpouseLiveAddress = value;
    }

    /**
     * Gets the value of the customerSpouseMobile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerSpouseMobile() {
        return customerSpouseMobile;
    }

    /**
     * Sets the value of the customerSpouseMobile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerSpouseMobile(String value) {
        this.customerSpouseMobile = value;
    }

    /**
     * Gets the value of the customerSpouseName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerSpouseName() {
        return customerSpouseName;
    }

    /**
     * Sets the value of the customerSpouseName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerSpouseName(String value) {
        this.customerSpouseName = value;
    }

    /**
     * Gets the value of the customerSpouseWorkPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerSpouseWorkPhone() {
        return customerSpouseWorkPhone;
    }

    /**
     * Sets the value of the customerSpouseWorkPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerSpouseWorkPhone(String value) {
        this.customerSpouseWorkPhone = value;
    }

    /**
     * Gets the value of the customerWorkAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerWorkAddress() {
        return customerWorkAddress;
    }

    /**
     * Sets the value of the customerWorkAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerWorkAddress(String value) {
        this.customerWorkAddress = value;
    }

    /**
     * Gets the value of the customerWorkPosition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerWorkPosition() {
        return customerWorkPosition;
    }

    /**
     * Sets the value of the customerWorkPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerWorkPosition(String value) {
        this.customerWorkPosition = value;
    }

    /**
     * Gets the value of the customerWorkUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerWorkUnit() {
        return customerWorkUnit;
    }

    /**
     * Sets the value of the customerWorkUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerWorkUnit(String value) {
        this.customerWorkUnit = value;
    }

    /**
     * Gets the value of the customerYearAfterTaxIncome property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCustomerYearAfterTaxIncome() {
        return customerYearAfterTaxIncome;
    }

    /**
     * Sets the value of the customerYearAfterTaxIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCustomerYearAfterTaxIncome(BigDecimal value) {
        this.customerYearAfterTaxIncome = value;
    }

    /**
     * Gets the value of the customerYearsOfWorking property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCustomerYearsOfWorking() {
        return customerYearsOfWorking;
    }

    /**
     * Sets the value of the customerYearsOfWorking property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCustomerYearsOfWorking(BigDecimal value) {
        this.customerYearsOfWorking = value;
    }

    /**
     * Gets the value of the customerhomePhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerhomePhone() {
        return customerhomePhone;
    }

    /**
     * Sets the value of the customerhomePhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerhomePhone(String value) {
        this.customerhomePhone = value;
    }

    /**
     * Gets the value of the cutomerWorkPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCutomerWorkPhone() {
        return cutomerWorkPhone;
    }

    /**
     * Sets the value of the cutomerWorkPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCutomerWorkPhone(String value) {
        this.cutomerWorkPhone = value;
    }

    /**
     * Gets the value of the educationLevelOther property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEducationLevelOther() {
        return educationLevelOther;
    }

    /**
     * Sets the value of the educationLevelOther property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEducationLevelOther(String value) {
        this.educationLevelOther = value;
    }

    /**
     * Gets the value of the emergencyContactCheck property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEmergencyContactCheck() {
        return emergencyContactCheck;
    }

    /**
     * Sets the value of the emergencyContactCheck property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEmergencyContactCheck(XMLGregorianCalendar value) {
        this.emergencyContactCheck = value;
    }

    /**
     * Gets the value of the emergencyContactCheckPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmergencyContactCheckPhone() {
        return emergencyContactCheckPhone;
    }

    /**
     * Sets the value of the emergencyContactCheckPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmergencyContactCheckPhone(String value) {
        this.emergencyContactCheckPhone = value;
    }

    /**
     * Gets the value of the emergencyContactCheckUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmergencyContactCheckUser() {
        return emergencyContactCheckUser;
    }

    /**
     * Sets the value of the emergencyContactCheckUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmergencyContactCheckUser(String value) {
        this.emergencyContactCheckUser = value;
    }

    /**
     * Gets the value of the emergencyContactPerson property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmergencyContactPerson() {
        return emergencyContactPerson;
    }

    /**
     * Sets the value of the emergencyContactPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmergencyContactPerson(String value) {
        this.emergencyContactPerson = value;
    }

    /**
     * Gets the value of the emergencyContactPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    /**
     * Sets the value of the emergencyContactPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmergencyContactPhone(String value) {
        this.emergencyContactPhone = value;
    }

    /**
     * Gets the value of the isDrivingLicense property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsDrivingLicense() {
        return isDrivingLicense;
    }

    /**
     * Sets the value of the isDrivingLicense property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsDrivingLicense(String value) {
        this.isDrivingLicense = value;
    }

    /**
     * Gets the value of the isHavaCar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsHavaCar() {
        return isHavaCar;
    }

    /**
     * Sets the value of the isHavaCar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsHavaCar(String value) {
        this.isHavaCar = value;
    }

    /**
     * Gets the value of the isHaveAccFund property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsHaveAccFund() {
        return isHaveAccFund;
    }

    /**
     * Sets the value of the isHaveAccFund property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsHaveAccFund(String value) {
        this.isHaveAccFund = value;
    }

    /**
     * Gets the value of the isHaveSocialSecurity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsHaveSocialSecurity() {
        return isHaveSocialSecurity;
    }

    /**
     * Sets the value of the isHaveSocialSecurity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsHaveSocialSecurity(String value) {
        this.isHaveSocialSecurity = value;
    }

    /**
     * Gets the value of the isInHacn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsInHacn() {
        return isInHacn;
    }

    /**
     * Sets the value of the isInHacn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsInHacn(String value) {
        this.isInHacn = value;
    }

    /**
     * Gets the value of the isReceiveEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsReceiveEmail() {
        return isReceiveEmail;
    }

    /**
     * Sets the value of the isReceiveEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsReceiveEmail(String value) {
        this.isReceiveEmail = value;
    }

    /**
     * Gets the value of the isReceiveSms property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsReceiveSms() {
        return isReceiveSms;
    }

    /**
     * Sets the value of the isReceiveSms property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsReceiveSms(String value) {
        this.isReceiveSms = value;
    }

    /**
     * Gets the value of the isSpouseDrivingLicense property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsSpouseDrivingLicense() {
        return isSpouseDrivingLicense;
    }

    /**
     * Sets the value of the isSpouseDrivingLicense property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsSpouseDrivingLicense(String value) {
        this.isSpouseDrivingLicense = value;
    }

    /**
     * Gets the value of the loanAppNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoanAppNo() {
        return loanAppNo;
    }

    /**
     * Sets the value of the loanAppNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoanAppNo(String value) {
        this.loanAppNo = value;
    }

    /**
     * Gets the value of the relationship property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelationship() {
        return relationship;
    }

    /**
     * Sets the value of the relationship property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelationship(String value) {
        this.relationship = value;
    }

    /**
     * Gets the value of the relativeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelativeName() {
        return relativeName;
    }

    /**
     * Sets the value of the relativeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelativeName(String value) {
        this.relativeName = value;
    }

    /**
     * Gets the value of the systemType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystemType() {
        return systemType;
    }

    /**
     * Sets the value of the systemType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystemType(String value) {
        this.systemType = value;
    }

}
