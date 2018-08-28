package com.mobile.test;
public class TestClient {
	
	public static void main(String[] args) {

		MobileCodeWS mobileCodeWS=new MobileCodeWS();
		
		MobileCodeWSSoap soap=mobileCodeWS.getMobileCodeWSSoap();
		
		String mobile="13249099256";
		
		String info=soap.getMobileCodeInfo(mobile, null);
		
		System.out.println(info);
	}

}