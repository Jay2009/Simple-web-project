package org.zerock.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.ProjectCriteria;
import org.zerock.domain.ProjectSearchCriteria;
import org.zerock.domain.ProjectVO;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

	@Inject
	private SqlSession projectsession;
	
	private static String namespace ="org.zerock.mappers.projectMapper";
	
	@Override
	public void create(ProjectVO vo) throws Exception {
		 projectsession.insert(namespace + ".create", vo);
		
	}

	@Override
	public ProjectVO read(Integer bno) throws Exception {
		return projectsession.selectOne(namespace + ".read", bno);
	}

	@Override
	public void update(ProjectVO vo) throws Exception {
		projectsession.update(namespace + ".update", vo);
		
	}

	@Override
	public void delete(Integer bno) throws Exception {
		projectsession.delete(namespace + ".delete", bno);
		
	}

	@Override
	public List<ProjectVO> listAll() throws Exception {
		return projectsession.selectList(namespace + ".listAll");
	}

	@Override
	public List<ProjectVO> listPage(int page) throws Exception {
		 if (page <= 0) {
		      page = 1;
		    }

		    page = (page - 1) * 10;

		    return projectsession.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<ProjectVO> listCriteria(ProjectCriteria cri) throws Exception {
		return projectsession.selectList(namespace + ".listCriteria", cri);
	}

	@Override
	public int countPaging(ProjectCriteria cri) throws Exception {
		 return projectsession.selectOne(namespace + ".countPaging", cri);
	}

	@Override
	public List<ProjectVO> listSearch(ProjectSearchCriteria cri) throws Exception {
		return projectsession.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(ProjectSearchCriteria cri) throws Exception {
		return projectsession.selectOne(namespace + ".listSearchCount", cri);
	}

	@Override
	public void updateViewCnt(Integer bno) throws Exception {
		projectsession.update(namespace+".updateViewCnt",bno);
		
	}
	
	@Override
	public void updateReplyCnt(Integer bno, int amount) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bno", bno);
		paramMap.put("amount", amount);
		
		projectsession.update(namespace+ ".updateReplyCnt",paramMap);
		
	}


	@Override
	public void addAttach(ProjectVO vo) throws Exception {
		
		projectsession.insert(namespace+".addAttach",vo);
		System.out.println("addAttach after  insert SQL statement!!!!!");
	}

	@Override
	public List<String> getAttach(Integer bno) throws Exception {
		System.out.println("getAttach in boardDAOIMPL @@@@@@@@@@@@@@");
		return projectsession.selectList(namespace+".getAttach", bno);
	}

	@Override
	public void deleteAttach(Integer bno) throws Exception {
		projectsession.delete(namespace+".deleteAttach", bno);
		
	}

	@Override
	public void replaceAttach(String fullName, Integer bno) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("bno",bno);
		paramMap.put("fullName",fullName);
		
		projectsession.insert(namespace+".replaceAttach", paramMap);
		
		
		
	}

	@Override
	public int bnoKey() throws Exception {
		
		return projectsession.selectOne(namespace + ".bnoKey" );
	}

}
