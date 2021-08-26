package com.retailer.rewards.jpa;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retailer.rewards.entities.Transactions;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Serializable>{
	
	List<Transactions> findByUserID(Integer userID);
	
}
