package com.zss.gateway.response;

import com.zss.gateway.contants.GatewayRespEnum;

/**
 * 服务返回实体公共类
 */
@SuppressWarnings("rawtypes")
public class ResponseEntity<T> extends BaseResEntity{

	/**
	 * 数据体
	 */
	private Object data;

	public ResponseEntity(String code, String message) {
		new BaseResEntity(code,message);
	}

	public ResponseEntity(GatewayRespEnum marketRespEnum) {
		new BaseResEntity(marketRespEnum.getCode(),marketRespEnum.getMessage());
	}
	
	public  ResponseEntity(GatewayRespEnum marketRespEnum, T data) {
		new BaseResEntity(marketRespEnum.getCode(),marketRespEnum.getMessage());
		this.data = data;
	}
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static ResponseEntity failure(String msg) {
		 return new ResponseEntity(GatewayRespEnum.BUSINESS_ERROR.getCode(), msg);
	}
	
	public static ResponseEntity failure() {
		return new ResponseEntity(GatewayRespEnum.BUSINESS_ERROR.getCode(), GatewayRespEnum.BUSINESS_ERROR.getMessage());
	}
	
	public static ResponseEntity failure(GatewayRespEnum e) {
		 return new ResponseEntity(e.getCode(), e.getMessage());
	}
	
	public static ResponseEntity success() {
		 return new ResponseEntity(GatewayRespEnum.SUCCESS.getCode(), GatewayRespEnum.SUCCESS.getMessage());
	}
	
	public static <T> ResponseEntity<T> success(T data) {
	   return new ResponseEntity<T>(GatewayRespEnum.SUCCESS, data);
	}
	
	public static boolean isSuccess(ResponseEntity responseEntity){
        return responseEntity != null && GatewayRespEnum.SUCCESS.getCode().equals(responseEntity.getCode()) && responseEntity.getData() != null;
    }
}
