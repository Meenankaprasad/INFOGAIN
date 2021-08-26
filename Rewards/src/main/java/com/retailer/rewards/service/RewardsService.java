package com.retailer.rewards.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.retailer.rewards.entities.Transactions;
import com.retailer.rewards.jpa.TransactionsRepository;
import com.retailer.rewards.model.MonthlyData;
import com.retailer.rewards.model.ResponseObject;

@Service
public class RewardsService {

	@Autowired
	private TransactionsRepository transactionsRepository;
	
	public ResponseEntity<ResponseObject> getRewardsByUserId(Integer userId) {
		List<Transactions> transactionsByUserId = transactionsRepository.findByUserID(userId);
		
		Map<String, Long> resultSet = transactionsByUserId.stream()
                .collect(Collectors.groupingBy(t -> t.getTransactionTime().getMonth().toString(),
                               Collectors.summingLong(
                            		   (t) -> calculateRewardPoints(t.getTransactionAmount())
                            		   )));
		
		Iterator<String> months = resultSet.keySet().iterator();
		List<MonthlyData> monthlyDataList = new ArrayList<>();
		Long totalRewards = 0L;
		while(months.hasNext()) {
			String month = months.next();
			totalRewards += resultSet.get(month);
			MonthlyData md = new MonthlyData().builder().month(month).rewardPoints(resultSet.get(month)).build();
			monthlyDataList.add(md);
		}
		ResponseObject response = new ResponseObject().builder().totalRewardPoints(totalRewards).monthlyData(monthlyDataList).build();
		return new ResponseEntity<ResponseObject>(response, HttpStatus.OK);
	}
	
	public static Integer calculateRewardPoints(Long transactionAmount) {
		if(transactionAmount < 50) {
			return 0;
		} else if (transactionAmount > 100) {
			return (int) (50 + 2*(transactionAmount - 100));
		} else {
			return (int) (transactionAmount - 50);
		}
	}
	
}
