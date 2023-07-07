package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product extends BaseEntity{
	@Column(name="Prod_name",length=20)
	private String pname;
	@Column(name="Quantity")
	private int qty;
	@Column(name="Price")
	private double price;
	@Column(name="Description",length=50)
	private String desc;
}
