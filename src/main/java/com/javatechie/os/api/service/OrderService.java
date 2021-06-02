package com.javatechie.os.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.javatechie.os.api.common.Payment;
import com.javatechie.os.api.common.TransactionRequest;
import com.javatechie.os.api.common.TransactionResponse;
import com.javatechie.os.api.entity.Order;
import com.javatechie.os.api.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private RestTemplate template;
	
	public TransactionResponse saveOrder(TransactionRequest request) {
		String response;
		Order order=request.getOrder();
		Payment payment=request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		//rest call
		Payment paymentResponse=template.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment, Payment.class);
		response=paymentResponse.getPaymentStatus().equals("success")?"Payment processing successful and order has placed":"Payment Processing Failed";
		repository.save(order);
		return new TransactionResponse(order,paymentResponse.getTransactionId(),paymentResponse.getAmount(),response);
	}

}
