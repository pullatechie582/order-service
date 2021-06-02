package com.javatechie.os.api.common;

import com.javatechie.os.api.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
	public TransactionResponse(Order order, String transactionId, double amount, String response) {
		super();
		this.order = order;
		this.transactionId = transactionId;
		this.amount = amount;
		this.response = response;
	}
	private Order order;
	private String transactionId;
	private double amount;
	private String response;
	
	/*
	 * public TransactionResponse(Order order2, String transactionId2, double
	 * amount2, String response2) { // TODO Auto-generated constructor stub }
	 */
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	
}
