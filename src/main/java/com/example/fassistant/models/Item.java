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
@Table(	name = "items")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "short_code")
	private String shortCode;

	@Column(name = "category")
	private String category;

	@Column(name = "sub_category")
	private String subCategory;

	@Column(name = "name")
	private String name;
	
	@Column(name = "detail")
	private String detail;

	@Column(name = "price", precision = 19, scale = 4)
	private BigDecimal price;

	@Column(name = "discount_rate")
	private BigDecimal discountRate;

	@Column(name = "discount_type")
	private String discountType;

	@Column(name = "supp_tax_rate")
	private BigDecimal suppTaxRate;

	@Column(name = "supp_tax_amt", precision = 19, scale = 4)
	private BigDecimal suppTaxAmt;

	@Column(name = "vat_rate")
	private BigDecimal vatRate;

	@Column(name = "vat_amt", precision = 19, scale = 4)
	private BigDecimal vatAmt;

	@Column(name = "type")
	private String type;

	@Column(name = "is_set")
	private String isSet;

	@Column(name = "is_set_item")
	private String isSetItem;

	@Column(name = "image")
	private String image;

	@Column(name = "business_id")
	private String businessId;

	@Column(name = "division")
	private String division;

	@Column(name = "shop")
	private String shop;

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

	@CreatedBy
	@Column(name = "user_created")
	private String userCreated;

	@LastModifiedBy
	@Column(name = "user_updated")
	private String userUpdated;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(BigDecimal discountRate) {
		this.discountRate = discountRate;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIsSet() {
		return isSet;
	}

	public void setIsSet(String isSet) {
		this.isSet = isSet;
	}

	public String getIsSetItem() {
		return isSetItem;
	}

	public void setIsSetItem(String isSetItem) {
		this.isSetItem = isSetItem;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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