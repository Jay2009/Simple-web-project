package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.ProjectCriteria;
import org.zerock.domain.ProjectSearchCriteria;
import org.zerock.domain.ProjectVO;
import org.zerock.persistence.ProjectDAO;

@Service
public class ProjectServiceImpl implements ProjectService  {

	@Inject
	  private ProjectDAO dao;
	


	  @Transactional
	  @Override
	  public void regist(ProjectVO board) throws Exception {
	    dao.create(board);
	    
	    int bnoKey = dao.bnoKey();
	    
	    board.setBno(bnoKey);
	    System.out.println(" count bno :::::::" + bnoKey);
	    System.out.println("daodsdsdsd"+board);
	    String[] files = board.getFiles();
	    System.out.println("regist  files in for loop::"+files);
	    if(files == null) {return;}
	    for (String fileName : files) {
	    	
	    	board.setFileName(fileName);
	    	
	    	dao.addAttach(board);
	    	System.out.println("regist  filename in for loop::"+fileName);
	    }
	    
	  }

	  @Transactional(isolation=Isolation.READ_COMMITTED)
	  @Override
	  public ProjectVO read(Integer bno) throws Exception {
		dao.updateViewCnt(bno);
	    return dao.read(bno);
	  }
	  @Transactional
	  @Override
	  public void modify(ProjectVO board) throws Exception {
	    dao.update(board);
	    
	    Integer bno = board.getBno();
	    
	    dao.deleteAttach(bno);
	    
	    String[] files = board.getFiles();
	    
	    if(files == null) { return; }
	    
	    for(String fileName : files) {
	    	dao.replaceAttach(fileName, bno);
	    }
	  }

	  @Override
	  public void remove(Integer bno) throws Exception {
		  dao.deleteAttach(bno);
		  dao.delete(bno);
		
	  }
	  
	 
	  

	  @Override
	  public List<ProjectVO> listAll() throws Exception {
	    return dao.listAll();
	  }

	  @Override
	  public List<ProjectVO> listCriteria(ProjectCriteria cri) throws Exception {

	    return dao.listCriteria(cri);
	  }

	  @Override
	  public int listCountCriteria(ProjectCriteria cri) throws Exception {

	    return dao.countPaging(cri);
	  }

	  @Override
	  public List<ProjectVO> listSearchCriteria(ProjectSearchCriteria cri) throws Exception {

	    return dao.listSearch(cri);
	  }

	  @Override
	  public int listSearchCount(ProjectSearchCriteria cri) throws Exception {

	    return dao.listSearchCount(cri);
	  }
	  
	  @Override
	  public List<String> getAttach(Integer bno) throws Exception {
	  	
	  	return dao.getAttach(bno);
	  	
	  }

	  @Override
	  public int bnoKey() throws Exception {
	  	return dao.bnoKey();
	  }
	  
}
