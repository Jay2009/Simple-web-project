package org.zerock.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO {

  @Inject
  private SqlSession boardsession;

  private static String namespace = "org.zerock.mappers.boardMapper";

  @Override
  public void create(BoardVO vo) throws Exception {
    boardsession.insert(namespace + ".create", vo);
  }

  @Override
  public BoardVO read(Integer bno) throws Exception {
    return boardsession.selectOne(namespace + ".read", bno);
  }

  @Override
  public void update(BoardVO vo) throws Exception {
    boardsession.update(namespace + ".update", vo);
  }

  @Override
  public void delete(Integer bno) throws Exception {
    boardsession.delete(namespace + ".delete", bno);
  }

  @Override
  public List<BoardVO> listAll() throws Exception {
    return boardsession.selectList(namespace + ".listAll");
  }

  @Override
  public List<BoardVO> listPage(int page) throws Exception {

    if (page <= 0) {
      page = 1;
    }

    page = (page - 1) * 10;

    return boardsession.selectList(namespace + ".listPage", page);
  }

  @Override
  public List<BoardVO> listCriteria(Criteria cri) throws Exception {

    return boardsession.selectList(namespace + ".listCriteria", cri);
  }

  @Override
  public int countPaging(Criteria cri) throws Exception {

    return boardsession.selectOne(namespace + ".countPaging", cri);
  }

  @Override
  public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {
	  
    return boardsession.selectList(namespace + ".listSearch", cri);
  }

  @Override
  public int listSearchCount(SearchCriteria cri) throws Exception {

    return boardsession.selectOne(namespace + ".listSearchCount", cri);
  }

@Override
public void updateViewCnt(Integer bno) throws Exception {
	boardsession.update(namespace+".updateViewCnt",bno);
	
}

@Override
public void updateReplyCnt(Integer bno, int amount) throws Exception {
	Map<String, Object> paramMap = new HashMap<String, Object>();
	paramMap.put("bno", bno);
	paramMap.put("amount", amount);
	
	boardsession.update(namespace+ ".updateReplyCnt",paramMap);
	
}


@Override
public void addAttach(BoardVO vo) throws Exception {
	
	boardsession.insert(namespace+".addAttach",vo);
	System.out.println("addAttach after  insert SQL statement!!!!!");
}

@Override
public List<String> getAttach(Integer bno) throws Exception {
	System.out.println("getAttach in boardDAOIMPL @@@@@@@@@@@@@@");
	return boardsession.selectList(namespace+".getAttach", bno);
}

@Override
public void deleteAttach(Integer bno) throws Exception {
	boardsession.delete(namespace+".deleteAttach", bno);
	
}

@Override
public void replaceAttach(String fullName, Integer bno) throws Exception {
	Map<String, Object> paramMap = new HashMap<String, Object>();
	
	paramMap.put("bno",bno);
	paramMap.put("fullName",fullName);
	
	boardsession.insert(namespace+".replaceAttach", paramMap);
	
}

@Override
public int bnoKey() throws Exception {
	
	return boardsession.selectOne(namespace + ".bnoKey" );
}



}
