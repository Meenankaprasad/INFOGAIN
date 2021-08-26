package com.retailer.rewards.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.retailer.rewards.service.RewardsService;

@RestController
public class RewardsRestController {
	
	@Autowired
	private RewardsService rewardsService;

	@GetMapping(value = "/rewards/{userId}")
	public ResponseEntity<?> calculateRewards(@PathVariable("userId") Integer userId) {
		try {
			return new ResponseEntity<>(rewardsService.getRewardsByUserId(userId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
