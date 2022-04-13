package com.ehsproy.msAccountTransactions.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.ehsproy.msAccountTransactions.model.TypeOperation;

import reactor.core.publisher.Mono;

public interface ITypeOperationRepository extends ReactiveCrudRepository<TypeOperation,String> {

	Mono<TypeOperation> findByCodeTypeOperation(String codeType);
}
