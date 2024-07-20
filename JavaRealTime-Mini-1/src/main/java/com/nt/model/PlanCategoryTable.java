package com.nt.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class PlanCategoryTable {
	
	@Id
	@SequenceGenerator(sequenceName = "PlanSequence", initialValue = 1, allocationSize = 10, name = "gen1")
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE )
	private Integer planid;
	
	@Column(name="Plan_Name", length=30 )
	private String planName;
	
	@Column(name="Active_Switch", length=30 )
	private String activeSwitch;
	
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime createdOn;
}
