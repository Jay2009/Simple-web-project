package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.ProjectCriteria;
import org.zerock.domain.ProjectSearchCriteria;
import org.zerock.domain.ProjectVO;

public interface ProjectDAO {

	 public void create(ProjectVO vo) throws Exception;

	  public ProjectVO read(Integer bno) throws Exception;

	  public void update(ProjectVO vo) throws Exception;

	  public void delete(Integer bno) throws Exception;

	  public List<ProjectVO> listAll() throws Exception;

	  public List<ProjectVO> listPage(int page) throws Exception;

	  public List<ProjectVO> listCriteria(ProjectCriteria cri) throws Exception;

	  public int countPaging(ProjectCriteria cri) throws Exception;
	  
	  //use for dynamic sql
	  
	  public List<ProjectVO> listSearch(ProjectSearchCriteria cri)throws Exception;
	  
	  public int listSearchCount(ProjectSearchCriteria cri)throws Exception;
	   
	  public void updateViewCnt(Integer bno) throws Exception;
	  
	  public void updateReplyCnt(Integer bno, int amount)throws Exception;
	  
	  public void addAttach(ProjectVO vo) throws Exception;
	  
	  public List<String> getAttach(Integer bno)throws Exception;

	  public void deleteAttach(Integer bno)throws Exception;
	  
	  public void replaceAttach(String fullName, Integer bno) throws Exception;
	  
	  public int bnoKey() throws Exception; 

}
