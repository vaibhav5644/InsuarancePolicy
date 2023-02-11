package com.sasken.insurance.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sasken.insurance.model.Policy;
import com.sasken.insurance.service.PolicyService;

@RestController
@RequestMapping("/policy")
public class PolicyController {

	@Autowired
	private PolicyService policyService;

	// save data === Post mapping

	@PostMapping("/save")
	public ResponseEntity<Policy> Save(@RequestBody Policy policy) {
		Policy newPolicy = policyService.save(policy);

		return ResponseEntity.ok().body(newPolicy);
	}

	// update data == Put Mapping
	@PutMapping("/update/{id}")
	public ResponseEntity<Policy> update(@RequestBody Policy policy, @PathVariable("id") int Id) {

		this.policyService.update(policy, Id);

		return ResponseEntity.ok().body(policy);

	}

	// get all data == GetMapping

	@GetMapping("/getAll")
	public @ResponseBody Iterable<Policy> getAllPolicy() {

		return policyService.getAllPolicy();
	}

	@GetMapping("/getid/{id}")
	public ResponseEntity<Policy> getId(@PathVariable("id") int Id) {

		Policy policy = policyService.getById(Id);

		return ResponseEntity.ok().body(policy);

	}

	@DeleteMapping("/delete/{id}")
	public void DeletePolicyById(@PathVariable("id") int Id) {

		policyService.DeletePolicy(Id);

	}

}
