package com.project.staragile.insureme;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PolicyService {
	
	@Autowired
	PolicyRepository policyRepository;
	
	
	public Policy CreatePolicy() {
		
		Policy policy = generateDummyPolicy();
		
		return policyRepository.save(policy);
		
			
	}
	
	public Policy searchPolicy() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Policy generateDummyPolicy() {
		return new Policy(1, "Swamy", "Individual" , 10000, "10-Sep-2021", "10-Sep-2022");
	}

	public Policy registerPolicy(Policy policy) {
		// TODO Auto-generated method stub
		return policyRepository.save(policy);
	}

	public Policy getPolicyDetails(int policyId) {
		// TODO Auto-generated method stub
		return policyRepository.findById(policyId).get();
	}
	
	public Policy updatePolicy(int policyId, Policy policyDetails) {
		// TODO Auto-generated method stub
		
		Policy policy = policyRepository.findById(policyId).get();
		policy.setPolicyPrice(policyDetails.getPolicyPrice());
		policy.setPolicyStartDate(policyDetails.getPolicyStartDate()); 
		policy.setPolicyEndDate(policyDetails.getPolicyEndDate());
		policy.setPolicyHolderName(policyDetails.getPolicyHolderName());
				
		return policyRepository.save(policy);
	}
	
	public List<Policy> viewPolicy(int policyId) {
		// TODO Auto-generated method stub
		return policyRepository.findAll();
	}
	
	public void deletePolicy(int policyId) {
		// TODO Auto-generated method stub
		policyRepository.deleteById(policyId);
	}

}
