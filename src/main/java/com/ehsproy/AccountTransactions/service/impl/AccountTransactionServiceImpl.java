package com.ehsproy.AccountTransactions.service.impl;

import org.springframework.stereotype.Service;

import com.ehsproy.AccountTransactions.model.AccountTransaction;
import com.ehsproy.AccountTransactions.repository.IAccountTransactionRepository;
import com.ehsproy.AccountTransactions.service.IAccountTransactionService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AccountTransactionServiceImpl implements IAccountTransactionService {

	private final IAccountTransactionRepository transactionRepo;

	public Mono<AccountTransaction> save(AccountTransaction at) {
		return transactionRepo.save(at);
	}

	public Flux<AccountTransaction> findByAccountNumber(String accountNumber) {
		return transactionRepo.findByAccountNumber(accountNumber);
	}

}
