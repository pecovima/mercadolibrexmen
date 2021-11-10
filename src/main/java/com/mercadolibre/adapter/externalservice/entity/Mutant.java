package com.mercadolibre.adapter.externalservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name = "MUTANT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mutant {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="dna")
	private String firstName;
	
	@Column(name="mutant")
	private boolean isMutant;
	
	
}
