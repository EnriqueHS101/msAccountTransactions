package com.ehsproy.msAccountTransactions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ehsproy.msAccountTransactions.model.TypeOperation;
import com.ehsproy.msAccountTransactions.service.ITypeOperationService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/operation")
public class TypeOperationController {

	private final ITypeOperationService typeService;
	
	@GetMapping
	public Flux<TypeOperation> getAll(){
		return typeService.findAll();
	}

	@GetMapping("/code/{codeType}")
	public Mono<TypeOperation> getByCodeTypeOperation(@PathVariable("codeType") String codeType) {
		return typeService.findByCodeTypeOperation(codeType);
	}

	@PostMapping
	public Mono<TypeOperation> save(@RequestBody TypeOperation typeOperation) {
		return typeService.save(typeOperation);
	}
	
}
