package com.ehsproy.msAccountTransactions.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("TypeOperation")
public class TypeOperation {

	private String id;
	private String codeTypeOperation;
	private String nameTypeOperation;
	private Integer signTypeOperation;
}
