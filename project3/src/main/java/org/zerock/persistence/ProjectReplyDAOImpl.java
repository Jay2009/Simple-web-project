package org.zerock.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.ProjectCriteria;
import org.zerock.domain.ProjectReplyVO;

@Repository
public class ProjectReplyDAOImpl implements ProjectReplyDAO{

	  @Inject
	  private SqlSession session;

	  private static String namespace = "org.zerock.mappers.projectreplyMapper";
	 

	  @Override
	  public List<ProjectReplyVO> list(Integer bno) throws Exception {

	    return session.selectList(namespace + ".list", bno);
	  }

	  @Override
	  public void create(ProjectReplyVO vo) throws Exception {

	    session.insert(namespace + ".create", vo);
	  }

	  @Override
	  public void update(ProjectReplyVO vo) throws Exception {

	    session.update(namespace + ".update", vo);
	  }

	  @Override
	  public void delete(Integer rno) throws Exception {

	    session.update(namespace + ".delete", rno);
	  }

	  @Override
	  public List<ProjectReplyVO> listPage(Integer bno, ProjectCriteria cri)
	      throws Exception {

	    Map<String, Object> paramMap = new HashMap<>();

	    paramMap.put("bno", bno);
	    paramMap.put("cri", cri);

	    return session.selectList(namespace + ".listPage", paramMap);
	  }

	  @Override
	  public int count(Integer bno) throws Exception {

	    return session.selectOne(namespace + ".count", bno);
	  }

	@Override
	public int getBno(Integer rno) throws Exception {
		
		return session.selectOne(namespace + ".getBno",rno);
	}

	@Override
	public void deleteAll(Integer rno) {
		session.delete(namespace + ".deleteAll",rno);
		
	}



}
