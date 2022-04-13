package com.ehsproy.msAccountTransactions.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.ehsproy.msAccountTransactions.model.AccountTransaction;

import reactor.core.publisher.Flux;

public interface IAccountTransactionRepository extends ReactiveCrudRepository<AccountTransaction, String> {

//	Flux<AccountTransaction> findByAccountNumber (String accountNumber);
	Flux<AccountTransaction> findByIdAccount(String idAccount);
}
