package com.ehsproy.msAccountTransactions.service;

import com.ehsproy.msAccountTransactions.model.TypeOperation;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITypeOperationService {

	Flux<TypeOperation> findAll();
	Mono<TypeOperation> findByCodeTypeOperation(String codeType);
	
	Mono<TypeOperation> save(TypeOperation typeOperation);
}
