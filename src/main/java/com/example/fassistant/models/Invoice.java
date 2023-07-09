package com.example.fassistant.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
@Entity
@Table(	name = "invoices")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "token_no")
	private String tokenNo;

	@Column(name = "generic_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date genericDate;

	@Column(name = "gift_amt", precision = 19, scale = 4)
	private BigDecimal giftAmt;

	@Column(name = "card_amt")
	private BigDecimal cardAmt;

	@Column(name = "cash_amt")
	private BigDecimal cashAmt;

	@Column(name = "credit_amt")
	private BigDecimal creditAmt;

	@Column(name = "change_amt")
	private BigDecimal changeAmt;

	@Column(name = "rounding_amt", precision = 19, scale = 4)
	private BigDecimal roundingAmt;

	@Column(name = "discount_rate")
	private BigDecimal discountRate;

	@Column(name = "discount_amt", precision = 19, scale = 4)
	private BigDecimal discountAmt;

	@Column(name = "discount_amt_flat")
	private BigDecimal discountAmtFlat;

	@Column(name = "service_charge_amt", precision = 19, scale = 4)
	private BigDecimal serviceChargeAmt;

	@Column(name = "supp_tax_rate")
	private BigDecimal suppTaxRate;

	@Column(name = "supp_tax_amt", precision = 19, scale = 4)
	private BigDecimal suppTaxAmt;

	@Column(name = "vat_rate")
	private BigDecimal vatRate;

	@Column(name = "vat_amt", precision = 19, scale = 4)
	private BigDecimal vatAmt;

	@Column(name = "paid_Amt")
	private BigDecimal paidAmt;

	@Column(name = "payment_type")
	private String paymentType;

	@Column(name = "total_amt", precision = 19, scale = 4)
	private BigDecimal totalAmt;

	@Column(name = "net_amt")
	private BigDecimal netAmt;

	@Column(name = "note")
	private String note;

	@Column(name = "gift_note")
	private String giftNote;

	@Column(name = "cancel_note")
	private String cancelNote;

	@Column(name = "customer")
	private String customer;

	@Column(name = "customer_id")
	private String customerId;
	
	@Column(name = "phone")
	private String phone;

	@Column(name = "status_order")
	private String statusOrder;

	@Column(name = "status_print")
	private String statusPrint;

	@Column(name = "business_id")
	private String businessId;

	@Column(name = "division")
	private String division;

	@Column(name = "shop")
	private String shop;

	@Column(name = "terminal")
	private String terminal;

	@Column(name = "status")
	private String status;

	@Column(name = "integer1")
	private Integer integer1;

	@Column(name = "integer2")
	private Integer integer2;

	@Column(name = "integer3")
	private Integer integer3;

	@Column(name = "string1")
	private String string1;

	@Column(name = "string2")
	private String string2;

	@Column(name = "string3")
	private String string3;

	@Column(name = "date_created", updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Column(name = "date_updated")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdated;

	@Column(name = "user_created")
	private String userCreated;

	@Column(name = "user_updated")
	private String userUpdated;

	@Column(name = "shift")
	private String shift;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTokenNo() {
		return tokenNo;
	}

	public void setTokenNo(String tokenNo) {
		this.tokenNo = tokenNo;
	}

	public Date getGenericDate() {
		return genericDate;
	}

	public void setGenericDate(Date genericDate) {
		this.genericDate = genericDate;
	}

	public BigDecimal getGiftAmt() {
		return giftAmt;
	}

	public void setGiftAmt(BigDecimal giftAmt) {
		this.giftAmt = giftAmt;
	}

	public BigDecimal getCardAmt() {
		return cardAmt;
	}

	public void setCardAmt(BigDecimal cardAmt) {
		this.cardAmt = cardAmt;
	}

	public BigDecimal getCashAmt() {
		return cashAmt;
	}

	public void setCashAmt(BigDecimal cashAmt) {
		this.cashAmt = cashAmt;
	}

	public BigDecimal getCreditAmt() {
		return creditAmt;
	}

	public void setCreditAmt(BigDecimal creditAmt) {
		this.creditAmt = creditAmt;
	}

	public BigDecimal getChangeAmt() {
		return changeAmt;
	}

	public void setChangeAmt(BigDecimal changeAmt) {
		this.changeAmt = changeAmt;
	}

	public BigDecimal getRoundingAmt() {
		return roundingAmt;
	}

	public void setRoundingAmt(BigDecimal roundingAmt) {
		this.roundingAmt = roundingAmt;
	}

	public BigDecimal getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(BigDecimal discountRate) {
		this.discountRate = discountRate;
	}

	public BigDecimal getDiscountAmt() {
		return discountAmt;
	}

	public void setDiscountAmt(BigDecimal discountAmt) {
		this.discountAmt = discountAmt;
	}

	public BigDecimal getDiscountAmtFlat() {
		return discountAmtFlat;
	}

	public void setDiscountAmtFlat(BigDecimal discountAmtFlat) {
		this.discountAmtFlat = discountAmtFlat;
	}

	public BigDecimal getServiceChargeAmt() {
		return serviceChargeAmt;
	}

	public void setServiceChargeAmt(BigDecimal serviceChargeAmt) {
		this.serviceChargeAmt = serviceChargeAmt;
	}

	public BigDecimal getSuppTaxRate() {
		return suppTaxRate;
	}

	public void setSuppTaxRate(BigDecimal suppTaxRate) {
		this.suppTaxRate = suppTaxRate;
	}

	public BigDecimal getSuppTaxAmt() {
		return suppTaxAmt;
	}

	public void setSuppTaxAmt(BigDecimal suppTaxAmt) {
		this.suppTaxAmt = suppTaxAmt;
	}

	public BigDecimal getVatRate() {
		return vatRate;
	}

	public void setVatRate(BigDecimal vatRate) {
		this.vatRate = vatRate;
	}

	public BigDecimal getVatAmt() {
		return vatAmt;
	}

	public void setVatAmt(BigDecimal vatAmt) {
		this.vatAmt = vatAmt;
	}

	public BigDecimal getPaidAmt() {
		return paidAmt;
	}

	public void setPaidAmt(BigDecimal paidAmt) {
		this.paidAmt = paidAmt;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public BigDecimal getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(BigDecimal totalAmt) {
		this.totalAmt = totalAmt;
	}

	public BigDecimal getNetAmt() {
		return netAmt;
	}

	public void setNetAmt(BigDecimal netAmt) {
		this.netAmt = netAmt;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getGiftNote() {
		return giftNote;
	}

	public void setGiftNote(String giftNote) {
		this.giftNote = giftNote;
	}

	public String getCancelNote() {
		return cancelNote;
	}

	public void setCancelNote(String cancelNote) {
		this.cancelNote = cancelNote;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStatusOrder() {
		return statusOrder;
	}

	public void setStatusOrder(String statusOrder) {
		this.statusOrder = statusOrder;
	}

	public String getStatusPrint() {
		return statusPrint;
	}

	public void setStatusPrint(String statusPrint) {
		this.statusPrint = statusPrint;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getInteger1() {
		return integer1;
	}

	public void setInteger1(Integer integer1) {
		this.integer1 = integer1;
	}

	public Integer getInteger2() {
		return integer2;
	}

	public void setInteger2(Integer integer2) {
		this.integer2 = integer2;
	}

	public Integer getInteger3() {
		return integer3;
	}

	public void setInteger3(Integer integer3) {
		this.integer3 = integer3;
	}

	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
	}

	public String getString2() {
		return string2;
	}

	public void setString2(String string2) {
		this.string2 = string2;
	}

	public String getString3() {
		return string3;
	}

	public void setString3(String string3) {
		this.string3 = string3;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public String getUserCreated() {
		return userCreated;
	}

	public void setUserCreated(String userCreated) {
		this.userCreated = userCreated;
	}

	public String getUserUpdated() {
		return userUpdated;
	}

	public void setUserUpdated(String userUpdated) {
		this.userUpdated = userUpdated;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

}