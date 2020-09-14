package com.task.openlegacy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "itemNo")
	private int itemNo;
	private String name;
	private int amount;
	private int inventoryCode;	

	public Item() {
	}
	
	public Item(String name, int amount, int inventoryCode) {
		this.name = name;
		this.amount = amount;
		this.inventoryCode = inventoryCode;
	}
	
	public Item(Item newItem) {
		super();
		this.itemNo = newItem.itemNo;
		this.name = newItem.name;
		this.amount = newItem.amount;
		this.inventoryCode = newItem.inventoryCode;
	}
	
	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getInventoryCode() {
		return inventoryCode;
	}

	public void setInventoryCode(int inventoryCode) {
		this.inventoryCode = inventoryCode;
	}

	@Override
	public String toString() {
		return "Item [itemNo=" + itemNo + ", name=" + name + ", amount=" + amount + ", inventoryCode=" + inventoryCode
				+ "]";
	}
	
	
}
