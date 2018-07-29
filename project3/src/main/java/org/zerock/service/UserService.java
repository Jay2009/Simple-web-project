package org.zerock.service;

import javax.servlet.http.HttpSession;

import org.zerock.domain.UserVO;

public interface UserService {

	
	public void regist(UserVO user)throws Exception;
	
	public UserVO userinforead(UserVO user)throws Exception;
	
	public void remove(Integer usernum)throws Exception;
	
	public void update(UserVO user)throws Exception;
	
	 // 01_01. 회원 로그인 체크
    public boolean loginCheck(UserVO vo, HttpSession session);

    // 01_02. 회원 로그인 정보
    public UserVO viewMember(UserVO vo);
	
    // 02. 회원 로그아웃
    public void logout(HttpSession session);

	//--------------------------------------- id duplication @@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int checkSignup(String id);
	
	public int balanceCheck(String id);
	
	public int winmoney(String id);

	public Integer gamecnt(String id);

	public Integer gamecntzero(String id);

	public Integer checkgamecnt(String id);
	

	
	
//	public UserVO winmoney(UserVO vo);

	
    
}

