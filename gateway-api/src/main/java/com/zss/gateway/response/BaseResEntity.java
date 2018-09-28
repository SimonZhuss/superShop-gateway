package com.zss.gateway.response;

import com.zss.gateway.contants.GatewayRespEnum;
import com.zss.gateway.exception.GatewayException;

public class BaseResEntity {
    private String code;
    private String message;

    public BaseResEntity() {
        this.code = GatewayRespEnum.SUCCESS.getCode();
        this.message = GatewayRespEnum.SUCCESS.getMessage();
    }

    public BaseResEntity(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static BaseResEntity failure() {
        return new BaseResEntity(GatewayRespEnum.BUSINESS_ERROR.getCode(), GatewayRespEnum.BUSINESS_ERROR.getMessage());
    }
    
    public static BaseResEntity failure(String message) {
        return new BaseResEntity(GatewayRespEnum.BUSINESS_ERROR.getCode(), message);
    }
    
    public static BaseResEntity failure(GatewayRespEnum message) {
        return new BaseResEntity(message.getCode(), message.getMessage());
    }

    public static BaseResEntity failure(GatewayException e) {
        return new BaseResEntity(e.getCode(), e.getMsg());
    }

    public static BaseResEntity success() {
        return new BaseResEntity(GatewayRespEnum.SUCCESS.getCode(), GatewayRespEnum.SUCCESS.getMessage());
    }

}
