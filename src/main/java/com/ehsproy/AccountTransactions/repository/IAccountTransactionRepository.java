package com.ehsproy.AccountTransactions.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.ehsproy.AccountTransactions.model.AccountTransaction;

import reactor.core.publisher.Flux;

public interface IAccountTransactionRepository extends ReactiveCrudRepository<AccountTransaction, String> {

	Flux<AccountTransaction> findByAccountNumber (String accountNumber);
}
