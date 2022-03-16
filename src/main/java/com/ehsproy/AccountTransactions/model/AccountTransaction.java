package com.ehsproy.AccountTransactions.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("movimientoBancario")
public class AccountTransaction {

	@Id
	private String id;
	private String docNumberClient;
	private String accountNumber;
	private LocalDate dateTransaction;
	private Double amount;
	private String typeOperation;
	private Boolean status;
	
	
}