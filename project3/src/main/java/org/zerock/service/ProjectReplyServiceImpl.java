package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.ProjectCriteria;
import org.zerock.domain.ProjectReplyVO;
import org.zerock.persistence.ProjectDAO;
import org.zerock.persistence.ProjectReplyDAO;

@Service
public class ProjectReplyServiceImpl implements ProjectReplyService{

	@Inject
	  private ProjectReplyDAO dao;
	  
	  @Inject
	  private ProjectDAO projectDAO;

	  @Transactional
	  @Override
	  public void addReply(ProjectReplyVO vo) throws Exception {

	    dao.create(vo);
	    projectDAO.updateReplyCnt(vo.getBno(), 1);
	  }

	  @Override
	  public List<ProjectReplyVO> listReply(Integer bno) throws Exception {

	    return dao.list(bno);
	  }

	  @Override
	  public void modifyReply(ProjectReplyVO vo) throws Exception {

	    dao.update(vo);
	  }
	  
	  @Transactional
	  @Override
	  public void removeReply(Integer rno) throws Exception {
		
		int bno = dao.getBno(rno);
	    dao.delete(rno);
	    projectDAO.updateReplyCnt(bno, -1);
	  }

	  @Override
	  public List<ProjectReplyVO> listReplyPage(Integer bno, ProjectCriteria cri) 
	      throws Exception {

	    return dao.listPage(bno, cri);
	  }

	  @Override
	  public int count(Integer bno) throws Exception {

	    return dao.count(bno);
	  }
	
}
