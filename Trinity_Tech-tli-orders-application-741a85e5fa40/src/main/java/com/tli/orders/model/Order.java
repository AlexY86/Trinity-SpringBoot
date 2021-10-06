package com.tli.orders.model;

import java.util.Date;

import javax.persistence.*;

//   domain entity doubling as a DTO

@Entity
@Table(name = "orders")
public class Order {

	private long id;
	private Integer number;
	private Integer orderId;
	private String name;
	private Integer price;
	private Integer quantity;
	private Date createdDate;
	private Integer createdBy;
	private Date modifiedDate;
	private Integer modifiedBy;
	private Integer statusId;
	private String orderStatusName;

	public Order() {

	}

	public Order(Integer number, Integer orderId, String name, Integer price, Integer quantity, Date createdDate,
			Integer createdBy, Date modifiedDate, Integer modifiedBy, Integer statusId, String orderStatusName) {
		this.number = number;
		this.orderId = orderId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
		this.statusId = statusId;
		this.orderStatusName = orderStatusName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "number")
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Column(name = "orderId")
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "price")
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Column(name = "quantity")
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Column(name = "created_date")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "created_by")
	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "modified_date")
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifieDate) {
		this.modifiedDate = modifieDate;
	}

	@Column(name = "modified_by")
	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Column(name = "status_id")
	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	@Column(name = "order_status_name")
	public String getOrderStatusName() {
		return orderStatusName;
	}

	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}

	// @Override
	// public int hashCode() {
	// return Objects.hash( number, orderId, name, price, quantity);
	// }

	// @Override
	// public String toString() {
	// return "Order [number=" + number + ", orderId=" + orderId + ", name=" + name
	// + ", price="
	// + price + ", quantity=" + quantity + "]";
	// }

}