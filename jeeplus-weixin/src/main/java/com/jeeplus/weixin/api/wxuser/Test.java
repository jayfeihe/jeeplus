package com.jeeplus.weixin.api.wxuser;

import org.jeewx.api.core.exception.WexinReqException;
import org.jeewx.api.wxbase.wxtoken.JwTokenAPI;
import org.jeewx.api.wxuser.user.JwUserAPI;

public class Test {

	public static void main(String[] args) {
		try {
			String s = JwTokenAPI.getAccessToken("??",????");
			System.out.println(JwUserAPI.getWxuser(s, "????").getNickname());
		} catch (WexinReqException e) {
			e.printStackTrace();
		}
	}
}
