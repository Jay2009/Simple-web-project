package org.zerock.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.zerock.domain.UserVO;
import org.zerock.persistence.UserDAO;


@Service
public class UserServiceImpl implements UserService{


	@Inject
	private UserDAO dao;

	
	
	@Override
	public void regist(UserVO user) throws Exception {
		dao.create(user);
		
	}

	

	@Override
	public void remove(Integer usernum) throws Exception {
		 dao.delete(usernum);
		
	}


	@Override
	public boolean loginCheck(UserVO vo, HttpSession session) {
		 boolean result = dao.loginCheck(vo);
		 
		 System.out.println("result::"+result);
	        if (result) { // If it is true then,
//	            UserVO vo2 = viewMember(vo);
	            // register a session
	            session.setAttribute("id", vo.getId());
	            session.setAttribute("username", vo.getUsername());
	          
	            System.out.println("balance :::: in userserviceimpl"+ vo);
	        }
	        return result;
	}
	


	@Override
	public UserVO viewMember(UserVO vo) {
		return dao.viewMember(vo);
	}


	@Override
	public void logout(HttpSession session) {
		// 세션 변수 개별 삭제
        // session.removeAttribute("userId");
        // 세션 정보를 초기화 시킴
        session.invalidate();
	}

	@Override
	public void update(UserVO user) throws Exception {
		
		 dao.update(user);
		
	}



	@Override
	public UserVO userinforead(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		return dao.read(user);
	}



	@Override
	public int checkSignup(String id) {
		return dao.idDuplication(id);

	}



	@Override
	public int balanceCheck(String id) {
		return dao.balancecheck(id);
	}



	@Override
	public int winmoney(String id) {
		return dao.winmoney(id);
	}



	@Override
	public Integer gamecnt(String id) {
		return dao.gamecnt(id);
	}



	@Override
	public Integer gamecntzero(String id) {
		return dao.gamecntzero(id);
	}

	@Override
	public Integer checkgamecnt(String id) {
		return dao.checkgamecnt(id);
	}

//	@Override
//	public UserVO winmoney(UserVO balance) {
//		 
//		return dao.winmoney(balance);
//		}
	

}
