package com.ehsproy.msAccountTransactions.service;

import com.ehsproy.msAccountTransactions.client.model.AccountData;
import com.ehsproy.msAccountTransactions.model.AccountTransaction;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAccountTransactionService {

	
	public Flux<AccountTransaction> findByIdAccount(String idAccount);
	
	public Mono<AccountTransaction> save(Mono<AccountTransaction> at);
	
	public Mono<AccountData> getAccount(String idAccount);
	
//	public Mono<AccountData> updateBalance(String idAccount, Double amount);
//	public Flux<AccountTransaction> findByAccountNumber(String accountNumber);
	
	public Mono<AccountData> updateBalance(Mono<AccountData> accountData);
}
