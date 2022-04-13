package com.ehsproy.msAccountTransactions.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("AccountTransaction")
public class AccountTransaction {

	@Id
	private String id;
	private String idAccount;
	private LocalDate dateTransaction;
	private Double amount;
	private String idTypeOperation;
	private Boolean status;
	
	
}
