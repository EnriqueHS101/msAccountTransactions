package com.ehsproy.AccountTransactions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ehsproy.AccountTransactions.model.AccountTransaction;
import com.ehsproy.AccountTransactions.service.IAccountTransactionService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accountTransac")
public class AccountTransactionController {

	private final IAccountTransactionService transactionService;
	
	@PostMapping
	public Mono<AccountTransaction> save(@RequestBody AccountTransaction transac){
		return transactionService.save(transac);
	}
	
	@GetMapping("/{accountNumber}")
	public Flux<AccountTransaction> findByAccountNumber(@PathVariable String accountNumber){
		return transactionService.findByAccountNumber(accountNumber);
	}
}
