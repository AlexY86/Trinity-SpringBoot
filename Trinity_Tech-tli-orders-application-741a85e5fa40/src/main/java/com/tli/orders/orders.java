package com.tli.orders;

import java.util.Date;
import java.util.Objects;

import javax.persistence.*;


//   domain entity doubling as a DTO
 

@Entity
@Table(name = "orders")
public class orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private Integer number;

	@Column
	private Integer orderId;

	@Column
	private String name;

	@Column
	private Integer price;

	@Column
	private Integer quantity;

	@Column
	private Date created_date;

	@Column
	private Integer created_by;

	@Column
	private Date modified_date;

	@Column
	private Integer modified_by;

	@Column
	private Integer status_id;

	@Column
	private String order_status_name;

	public orders() {

	}


	public orders(Integer number, Integer orderId, String name, Integer price, 
		Integer quantity, Date createdDate, Integer createdBy, Date modifiedDate, Integer modifiedBy,
		Integer statusId, String orderStatusName ) {
		this.number = number;
		this.orderId = orderId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.created_date = createdDate;
		this.created_by = createdBy;
		this.modified_date = modifiedDate;
		this.modified_by = modifiedBy;
		this.status_id = statusId;
		this.order_status_name = orderStatusName;
	}


    public long getId() {
		return this.id;
	}

	// for tests ONLY
    public void setId(long id) {
        this.id = id;
    }

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number){
		this.number = number;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getCreatedDate() {
		return created_date;
	}

	public void setCreatedDate(Date createdDate) {
		this.created_date = createdDate;
	}

	public Integer getCreatedBy() {
		return created_by;
	}

	public void setCreatedBy(Integer createdBy) {
		this.created_by = createdBy;
	}

	public Date getModifiedDate(){
		return modified_date;
	}

	public void setModifiedDate(Date modifieDate) {
		this.modified_date = modifieDate;
	}

	public Integer getModifiedBy(){
		return modified_by;
	}

	public void setModifiedBy(Integer modifiedBy){
		this.modified_by = modifiedBy;
	}

	public Integer getStatusId(){
		return status_id;
	}

	public void setStatusId(Integer statusId) {
		this.status_id = statusId;
	}

	public String getOrderStatusName(){
		return order_status_name;
	}

	public void setOrderStatusName(String orderStatusName){
		 this.order_status_name = orderStatusName;
	}


	@Override
	public int hashCode() {
		return Objects.hash( number,  orderId,  name,  price,  quantity);
	}

	@Override
	public String toString() {
		return "orders [number=" + number + ", orderId=" + orderId + ", name=" + name + ", price="
				+ price + ", quantity=" + quantity + "]";
	}

}