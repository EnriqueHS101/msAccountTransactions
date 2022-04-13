package com.ehsproy.msAccountTransactions.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ehsproy.msAccountTransactions.model.TypeOperation;
import com.ehsproy.msAccountTransactions.repository.ITypeOperationRepository;
import com.ehsproy.msAccountTransactions.service.ITypeOperationService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TypeOperationServiceImpl implements ITypeOperationService {

	private final ITypeOperationRepository typeOperationRepo;
	
	@Override
	public Flux<TypeOperation> findAll() {
		return typeOperationRepo.findAll();
	}

	@Override
	public Mono<TypeOperation> findByCodeTypeOperation(String codeType) {
		return typeOperationRepo.findByCodeTypeOperation(codeType);
	}

	@Override
	public Mono<TypeOperation> save(TypeOperation typeOperation) {
		return typeOperationRepo.save(typeOperation);
	}

}
