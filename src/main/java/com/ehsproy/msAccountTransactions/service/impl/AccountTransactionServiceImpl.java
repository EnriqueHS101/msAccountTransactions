package com.ehsproy.msAccountTransactions.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ehsproy.msAccountTransactions.client.model.AccountData;
import com.ehsproy.msAccountTransactions.model.AccountTransaction;
import com.ehsproy.msAccountTransactions.repository.IAccountTransactionRepository;
import com.ehsproy.msAccountTransactions.service.IAccountTransactionService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AccountTransactionServiceImpl implements IAccountTransactionService {

	private final IAccountTransactionRepository transactionRepo;

	@Autowired
	private WebClient webClient;
	
	public Mono<AccountTransaction> save(Mono<AccountTransaction> at) {
		return at.flatMap(acTr ->{
			return transactionRepo.save(acTr);
		});
		
	}

	public Flux<AccountTransaction> findByIdAccount(String idAccount) {
		return transactionRepo.findByIdAccount(idAccount);
	}

	
	public Mono<AccountData> getAccount(String idAccount){
		return webClient.get().uri("/account/{idAccount}",idAccount)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(AccountData.class);
	}
	
	public Mono<AccountData> updateBalance(Mono<AccountData> accountData){
//		System.out.println("en el Impl Balance");
//		Mono<AccountData> account = this.getAccount(idAccount);
		
		return accountData.flatMap(balance ->{
//			AccountData ac = new AccountData();
//			ac = balance;
//			ac.setBalance(ac.getBalance() +amount);
//			balance.setBalance(balance.getBalance() + amount);
//			System.out.println("en Balance");
//			System.out.println(balance.getBalance());
//			System.out.println(balance.getId());
			
			return webClient.put().uri("/account")
									.body(balance,AccountData.class)				
									.retrieve()
									.bodyToMono(AccountData.class);
		});
		
//	public Mono<AccountData> updateBalance(String idAccount, Double amount){
//		System.out.println("en el Impl Balance");
//		Mono<AccountData> account = this.getAccount(idAccount);
//		
//		return account.flatMap(balance ->{
//			AccountData ac = new AccountData();
//			ac = balance;
//			ac.setBalance(ac.getBalance() +amount);
//			balance.setBalance(balance.getBalance() + amount);
//			System.out.println("en Balance");
//			System.out.println(balance.getBalance());
//			System.out.println(balance.getId());
//			return webClient.put().uri("/account/balance/"+ ac.getId())
//									.body(Mono.just(ac),AccountData.class)				
//									.retrieve()
//									.bodyToMono(AccountData.class);
//			
////			return Mono.just(balance);
//		});
//		System.out.println(account);
		
//		return webClient.put().uri(uriBuilder -> uriBuilder
//									.path("/account/balance")
//									.queryParam("id",idAccount)
//									.queryParam("amount",amount)
//									.build(idAccount))
//				.retrieve()
//				.bodyToMono(AccountData.class);
		
//		return webClient.get().uri("/account/balance/{idAccount}",idAccount)
//				.accept(MediaType.APPLICATION_JSON)
//				.retrieve()
//				.bodyToMono(AccountData.class);
	}
	
//	public Flux<AccountTransaction> findByAccountNumber(String accountNumber) {
//		return transactionRepo.findByAccountNumber(accountNumber);
//	}

}
