package org.zerock.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.ProjectCriteria;
import org.zerock.domain.ProjectPageMaker;
import org.zerock.domain.ProjectReplyVO;
import org.zerock.service.ProjectReplyService;

@RestController
@RequestMapping("/projectreplies")
public class ProjectReplyController {

	 @Inject
	  private ProjectReplyService service;

	  @RequestMapping(value = "", method = RequestMethod.POST)
	  public ResponseEntity<String> register(@RequestBody ProjectReplyVO vo) {

	    ResponseEntity<String> entity = null;
	    try {
	      service.addReply(vo);
	      entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	    } catch (Exception e) {
	      e.printStackTrace();
	      entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	    return entity;
	  }

	  @RequestMapping(value = "/all/{bno}", method = RequestMethod.GET)
	  public ResponseEntity<List<ProjectReplyVO>> list(@PathVariable("bno") Integer bno) {

	    ResponseEntity<List<ProjectReplyVO>> entity = null;
	    try {
	      entity = new ResponseEntity<>(service.listReply(bno), HttpStatus.OK);

	    } catch (Exception e) {
	      e.printStackTrace();
	      entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }

	    return entity;
	  }

	  @RequestMapping(value = "/{rno}", method = { RequestMethod.PUT, RequestMethod.PATCH })
	  public ResponseEntity<String> update(@PathVariable("rno") Integer rno, @RequestBody ProjectReplyVO vo) {

	    ResponseEntity<String> entity = null;
	    try {
	      vo.setRno(rno);
	      service.modifyReply(vo);

	      entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	    } catch (Exception e) {
	      e.printStackTrace();
	      entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	    return entity;
	  }

	  @RequestMapping(value = "/{rno}", method = RequestMethod.DELETE)
	  public ResponseEntity<String> remove(@PathVariable("rno") Integer rno) {

	    ResponseEntity<String> entity = null;
	    try {
	      service.removeReply(rno);
	      entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	    } catch (Exception e) {
	      e.printStackTrace();
	      entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	    return entity;
	  }

	  @RequestMapping(value = "/{bno}/{page}", method = RequestMethod.GET)
	  public ResponseEntity<Map<String, Object>> listPage(
	      @PathVariable("bno") Integer bno,
	      @PathVariable("page") Integer page, HttpSession session, Model model) {

	    ResponseEntity<Map<String, Object>> entity = null;
	    
	    try {
	      ProjectCriteria cri = new ProjectCriteria();
	      cri.setPage(page);

	      ProjectPageMaker projectpageMaker = new ProjectPageMaker();
	      projectpageMaker.setCri(cri);

	      Map<String, Object> map = new HashMap<String, Object>();
	      List<ProjectReplyVO> list = service.listReplyPage(bno, cri);

	      map.put("list", list);
	      
	      

	      int replyCount = service.count(bno);
	      model.addAttribute("replyCount", session.getAttribute("replyCount"));
	      projectpageMaker.setTotalCount(replyCount);
	      model.addAttribute("replyCount after", session.getAttribute("replyCount"));
	      System.out.println("reply total count :: "+ replyCount);
	      
	      map.put("projectpageMaker", projectpageMaker);

	      entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

	      System.out.println("list::"+list);
	      
	    } catch (Exception e) {
	      e.printStackTrace();
	      entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
	    }
	    
	    
	    
	    return entity;
	  }
}
