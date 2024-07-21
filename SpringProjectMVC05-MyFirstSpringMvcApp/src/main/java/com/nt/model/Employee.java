package com.nt.model;

import org.hibernate.annotations.SQLDelete;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="emp_details_for_MVC")
public class Employee {
	@Id
	@SequenceGenerator(name="empSeq", sequenceName = "SequenceOne", initialValue =1, allocationSize = 100 )
	@GeneratedValue(generator = "empSeq", strategy=GenerationType.SEQUENCE)
	private int emp_id;
	private String emp_name;
	private String emp_add;
	private double emp_sal;
}
