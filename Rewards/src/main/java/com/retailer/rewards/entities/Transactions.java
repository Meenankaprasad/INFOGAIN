package com.retailer.rewards.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "transactions", indexes = @Index(columnList = "userID"))
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transactionId;
	
	private Integer userID;
	
	private Long transactionAmount;
	
	@CreationTimestamp
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDateTime transactionTime;
	
}
