package com.retailer.rewards.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ResponseObject {

	private Long totalRewardPoints;
	private List<MonthlyData> monthlyData;
	
}
