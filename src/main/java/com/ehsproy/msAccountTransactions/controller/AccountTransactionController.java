package com.ehsproy.msAccountTransactions.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ehsproy.msAccountTransactions.client.model.AccountData;
import com.ehsproy.msAccountTransactions.model.AccountTransaction;
import com.ehsproy.msAccountTransactions.service.IAccountTransactionService;
import com.ehsproy.msAccountTransactions.service.ITypeOperationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/atransaction")
public class AccountTransactionController {

	private final IAccountTransactionService transactionService;
	
	private final ITypeOperationService typeService;
	
	@GetMapping("/{idAccount}")
	public ResponseEntity<Flux<AccountTransaction>> getByIdAccount(@PathVariable("idAccount") String idAccount){
		Flux<AccountTransaction> transaction = transactionService.findByIdAccount(idAccount);
		return ResponseEntity.ok(transaction);
	}
	
	
	@PostMapping("/{codeType}")
	public Mono<Void> createTransaction(@RequestBody AccountTransaction transac, @PathVariable("codeType") String codeType){
		
		Mono<AccountTransaction> transactionNew = typeService.findByCodeTypeOperation(codeType)
													.switchIfEmpty(Mono.error(new Exception()))
													.flatMap(type -> {
														transac.setAmount(transac.getAmount() * type.getSignTypeOperation());
														return Mono.just(transac);
													});
		Mono<AccountData> accountUpdt = transactionService.getAccount(transac.getIdAccount())
										.switchIfEmpty(Mono.error(new Exception()))
										.flatMap(acc -> {
											acc.setBalance(acc.getBalance() + transac.getAmount());
											return Mono.just(acc);
										});
		
		return Mono.when(transactionService.save(transactionNew), transactionService.updateBalance(accountUpdt));

						
		
//		Mono<AccountTransaction> tr = 
//		
//		Mono.just(transac).flatMap(transaction -> typeService.findByCodeTypeOperation(codeType).flatMap(type -> {
//			transaction.setIdTypeOperation(type.getId());
//			transaction.setAmount(transaction.getAmount()*type.getSignTypeOperation());
//			log.info("antes de updateBalance");
////			transactionService.updateBalance(transaction.getIdAccount(), transaction.getAmount()).toString();
////			log.info("despues de updateBalance");
//			return transactionService.save(transaction)
//					.map(tra ->  {
//						transactionService.updateBalance(tra.getIdAccount(), tra.getAmount());
//						return tra;
//					});
//		}));
//
//		if (tr != null) {
//			return ResponseEntity.ok(tr);
//		}else {
//			return ResponseEntity.notFound().build();
//		}
////		.defaultIfEmpty(ResponseEntity.notFound().build()));
//
////		return ResponseEntity.ok(tr) ;
	}
	
	@GetMapping("/account/{idAccount}")
    public ResponseEntity<Mono<AccountData>> getAccounts(@PathVariable("idAccount") String idAccount) {
		log.info("Aqui en account de client");
        
        Mono<AccountData> account= transactionService.getAccount(idAccount);
        return ResponseEntity.ok(account);
    }
	
//	@GetMapping("/{accountNumber}")
//	public Flux<AccountTransaction> findByAccountNumber(@PathVariable String accountNumber){
//		return transactionService.findByAccountNumber(accountNumber);
//	}
}
