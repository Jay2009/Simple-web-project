package org.zerock.service;

import java.util.List;

import org.zerock.domain.ProjectCriteria;
import org.zerock.domain.ProjectReplyVO;

public interface ProjectReplyService {

	  public void addReply(ProjectReplyVO vo) throws Exception;

	  public List<ProjectReplyVO> listReply(Integer bno) throws Exception;

	  public void modifyReply(ProjectReplyVO vo) throws Exception;

	  public void removeReply(Integer rno) throws Exception;

	  public List<ProjectReplyVO> listReplyPage(Integer bno, ProjectCriteria cri) 
	      throws Exception;

	  public int count(Integer bno) throws Exception;	
	
}
