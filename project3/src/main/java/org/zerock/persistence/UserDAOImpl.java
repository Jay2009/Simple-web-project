package org.zerock.persistence;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {


@Inject
private SqlSession session;

private static String namespace = "org.zerock.mappers.userMapper"; 

@Override
public void create(UserVO vo) throws Exception {
	session.insert(namespace+".create", vo);
	
}


@Override
public void delete(Integer usernum) throws Exception {
	session.delete(namespace+".delete", usernum);
	
}

@Override
public boolean loginCheck(UserVO vo) {

//	vo.setId("jay");
//	vo.setPw("jay12");
	
	vo.setUsername( (session.selectOne(namespace+".loginCheck", vo)));
	vo.setBalance(0);
	
	System.out.println("********* UserDAO.loginCheck's vo: " + vo);
	System.out.println("@@@@@@@@@ name@@@@@@@ :" + vo.getUsername());
	System.out.println("$$$$$$$$$ balance$$$$$$ ::" + vo.getBalance());
    return (vo.getUsername() == null ) ? false : true;
}

@Override
public UserVO viewMember(UserVO vo) {
	
	 System.out.println("************ UserDAO.viewMember vo: " + vo);
	 
	 
//	 return session.selectList(namespace+".viewMember", vo);
	 return vo;
	
}


@Override
public void logout(HttpSession session) {
		
}

@Override
public void update(UserVO vo) throws Exception {
	session.update(namespace + ".update", vo);
	
}


@Override
public UserVO read(UserVO vo) throws Exception {

	return session.selectOne(namespace+".read", vo);
}

//--------------------------------------- id duplication @@@@@@@@@@@@@@@@@@@@@@@@@@@

@Override
public int idDuplication(String id) {
	return session.selectOne(namespace+".idduplication", id);
}


@Override
public int balancecheck(String id) {
	return session.selectOne(namespace+".balanceCheck", id);
}


@Override
public int winmoney(String id) {
	
	return session.update(namespace+".winmoney", id);
}


@Override
public Integer gamecnt(String id) {
	return session.update(namespace+".gamecnt", id);
}


@Override
public Integer gamecntzero(String id) {
	return session.update(namespace+".gamecntzero", id);
}


@Override
public Integer checkgamecnt(String id) {
	return session.selectOne(namespace+".checkgamecnt", id); 
}


//@Override
//public void winmoney(Integer balance) {
//	return session.update(namespace+".idduplication", balance);
//	
//}




}