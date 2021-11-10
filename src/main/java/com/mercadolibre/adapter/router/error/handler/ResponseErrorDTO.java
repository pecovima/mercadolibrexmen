package com.mercadolibre.adapter.router.error.handler;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.mercadolibre.adapter.router.error.ErrorConsts.MOCK_CODE;
import static com.mercadolibre.adapter.router.error.ErrorConsts.MOCK_MENSAJE_ERROR;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseErrorDTO {
    @ApiModelProperty(example = MOCK_CODE)
    private String code;
    @ApiModelProperty(example = MOCK_MENSAJE_ERROR)
    private String message;
}
