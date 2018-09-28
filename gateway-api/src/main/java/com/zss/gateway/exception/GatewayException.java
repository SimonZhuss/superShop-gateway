package com.zss.gateway.exception;

import com.zss.gateway.contants.GatewayRespEnum;
import com.zss.gateway.response.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
public class GatewayException extends RuntimeException{

	private static final long serialVersionUID = 5584943755890277011L;

	protected String code;
	protected String msg;
    
    public GatewayException(ResponseEntity baseResEntity){
        if(baseResEntity == null){
            this.code = GatewayRespEnum.SYSTEM_ERROR.getCode();
            this.msg = GatewayRespEnum.SYSTEM_ERROR.getMessage();
        }else{
            this.code = baseResEntity.getCode();
            this.msg = baseResEntity.getMessage();
        }
    }

    public GatewayException(GatewayRespEnum marketRespEnum){
        if(marketRespEnum == null){
            this.code = GatewayRespEnum.SYSTEM_ERROR.getCode();
            this.msg = GatewayRespEnum.SYSTEM_ERROR.getMessage();
        }else{
            this.code = marketRespEnum.getCode();
            this.msg = marketRespEnum.getMessage();
        }
    }

    public GatewayException(GatewayRespEnum marketRespEnum, String msg){
        if(marketRespEnum == null){
            this.code = GatewayRespEnum.SYSTEM_ERROR.getCode();
            this.msg = GatewayRespEnum.SYSTEM_ERROR.getMessage();
        }else{
            this.code = marketRespEnum.getCode();
            this.msg = marketRespEnum.getMessage() + msg;
        }
    }

    public GatewayException(String msg){
        this.code = GatewayRespEnum.BUSINESS_ERROR.getCode();
        this.msg = msg;
    }
}
