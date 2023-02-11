package com.sasken.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sasken.insurance.model.Policy;
import com.sasken.insurance.repository.PolicyRepository;

@Service

public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private PolicyRepository policyRepository;

	@Override
	public Policy save(Policy policy) {

		return policyRepository.save(policy);
	}

	@Override
	public Policy update(Policy policy, Integer Id) {

		policy.setId(Id);

		return policyRepository.save(policy);
	}

	@Override
	public Iterable<Policy> getAllPolicy() {

		return policyRepository.findAll();
	}

	@Override
	public Policy getById(Integer Id) {

		Policy policy = policyRepository.findById(Id);
		return policy;
	}

	@Override
	public void DeletePolicy(Integer Id) {
	
		policyRepository.deleteById(Id);
		
	}



}
