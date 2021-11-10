package com.mercadolibre.domain.service.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMutantDTO {

	private Integer countHumanDNA;
	private Integer countMutantDNA;
	private Double ratio;
}
