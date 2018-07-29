package org.zerock.service;

import java.util.List;

import org.zerock.domain.ProjectVO;
import org.zerock.domain.ProjectCriteria;
import org.zerock.domain.ProjectSearchCriteria;

public interface ProjectService {
	 
	public void regist(ProjectVO board) throws Exception;

	  public ProjectVO read(Integer bno) throws Exception;

	  public void modify(ProjectVO board) throws Exception;

	  public void remove(Integer bno) throws Exception;

	  public List<ProjectVO> listAll() throws Exception;

	  public List<ProjectVO> listCriteria(ProjectCriteria cri) throws Exception;

	  public int listCountCriteria(ProjectCriteria cri) throws Exception;

	  public List<ProjectVO> listSearchCriteria(ProjectSearchCriteria cri)  throws Exception;

	  public int listSearchCount(ProjectSearchCriteria cri) throws Exception;

	  public List<String> getAttach(Integer bno) throws Exception;
  
	  public int bnoKey() throws Exception;




  
}
