package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.ProjectCriteria;
import org.zerock.domain.ProjectReplyVO;

public interface ProjectReplyDAO {

	public List<ProjectReplyVO> list(Integer bno) throws Exception;

	  public void create(ProjectReplyVO vo) throws Exception;

	  public void update(ProjectReplyVO vo) throws Exception;

	  public void delete(Integer rno) throws Exception;
	  

	  public List<ProjectReplyVO> listPage(
	      Integer bno, ProjectCriteria cri) throws Exception;

	  public int count(Integer bno) throws Exception;
	  
	  public int getBno(Integer rno) throws Exception;

	public void deleteAll(Integer rno);
	
	
}
