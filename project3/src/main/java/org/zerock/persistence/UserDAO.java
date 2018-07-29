package org.zerock.persistence;



import javax.servlet.http.HttpSession;

import org.zerock.domain.UserVO;


public interface UserDAO {

	public void create(UserVO vo) throws Exception;
	
	public void delete(Integer usernum) throws Exception;
	
	public void update(UserVO vo) throws Exception;
	
	public UserVO read(UserVO vo) throws Exception;// ������ ������ �о� �´�.
 	
    public boolean loginCheck(UserVO vo);
    // 01_02. ȸ�� �α��� ����
    public UserVO viewMember(UserVO vo);
    // 02. ȸ�� �α׾ƿ�

    public void logout(HttpSession session);

	public int idDuplication(String id);
	
	public int balancecheck(String id);
	
	public int winmoney(String id);
//	public UserVO winmoney(UserVO balance);
	//--------------------------------------- id duplication @@@@@@@@@@@@@@@@@@@@@@@@@@@

	public Integer gamecnt(String id);

	public Integer gamecntzero(String id);

	public Integer checkgamecnt(String id);

	
	
}
