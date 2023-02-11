package com.sasken.insurance.service;

import com.sasken.insurance.model.Policy;

public interface PolicyService {

	public Policy save(Policy policy);

	public Policy update(Policy policy, Integer Id);

	public Iterable<Policy> getAllPolicy();

	public Policy getById(Integer Id);
	
	public void DeletePolicy(Integer Id);

	
}
