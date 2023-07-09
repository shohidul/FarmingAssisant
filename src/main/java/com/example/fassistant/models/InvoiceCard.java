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
@Table(	name = "invoice_cards")
public class InvoiceCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "invoice_id")
	private String invoiceId;

	@Column(name = "card_index")
	private Integer cardIndex;

	@Column(name = "generic_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date genericDate;

	@Column(name = "name")
	private String name;

	@Column(name = "card_no")
	private String cardNo;

	@Column(name = "card_amt")
	private BigDecimal cardAmt;

	@Column(name = "business_id")
	private String businessId;

	@Column(name = "division")
	private String division;

	@Column(name = "shift")
	private String shift;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Integer getCardIndex() {
		return cardIndex;
	}

	public void setCardIndex(Integer cardIndex) {
		this.cardIndex = cardIndex;
	}

	public Date getGenericDate() {
		return genericDate;
	}

	public void setGenericDate(Date genericDate) {
		this.genericDate = genericDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public BigDecimal getCardAmt() {
		return cardAmt;
	}

	public void setCardAmt(BigDecimal cardAmt) {
		this.cardAmt = cardAmt;
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

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
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

}