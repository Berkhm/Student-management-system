package com.ogrenciyonetim.controller;

public class RestBaseController {
	
	
	public<T> RootEntity<T> ok(T paylod) {
		return RootEntity.ok(paylod);
	}
	
	
	public<T> RootEntity<T> error(String errorMessage){
		return RootEntity.error(errorMessage);
	}

}
