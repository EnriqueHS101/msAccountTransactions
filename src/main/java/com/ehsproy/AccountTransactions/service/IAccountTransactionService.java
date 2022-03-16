package com.ehsproy.AccountTransactions.service;

import com.ehsproy.AccountTransactions.model.AccountTransaction;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAccountTransactionService {

	public Mono<AccountTransaction> save(AccountTransaction at);
	
	public Flux<AccountTransaction> findByAccountNumber(String accountNumber);
}
