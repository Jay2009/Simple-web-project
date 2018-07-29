package org.zerock.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.ProjectPageMaker;
import org.zerock.domain.ProjectSearchCriteria;
import org.zerock.domain.ProjectVO;
import org.zerock.service.ProjectService;


@Controller
@RequestMapping("/projectboard/*")
public class ProjectController {

	  private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

	  @Inject
	  private ProjectService projectservice;
	  
	 

	  @RequestMapping(value = "/projectlist", method = RequestMethod.GET)
	  public void listPage(@ModelAttribute("projectcri") ProjectSearchCriteria projectcri, Model model, HttpSession session) throws Exception {

	    logger.info(projectcri.toString());

	    // model.addAttribute("list", service.listCriteria(cri));
	    model.addAttribute("projectlist", projectservice.listSearchCriteria(projectcri));

	    ProjectPageMaker projectpageMaker = new ProjectPageMaker(); 
	    projectpageMaker.setCri(projectcri);

	    // pageMaker.setTotalCount(service.listCountCriteria(cri));
	    projectpageMaker.setTotalCount(projectservice.listSearchCount(projectcri));

	    model.addAttribute("projectpageMaker", projectpageMaker);
	    model.addAttribute("id", session.getAttribute("id"));
	    model.addAttribute("username", session.getAttribute("username"));
	    
	    System.out.println("\t*** username in session: "+session.getAttribute("username"));
	    
	  }// listPage
	  

	  @RequestMapping(value = "/readPage", method = RequestMethod.GET)
	  public void read(@RequestParam("bno") int bno, @ModelAttribute("projectcri") ProjectSearchCriteria projectcri, Model model, HttpSession session)
	      throws Exception {

	    model.addAttribute(projectservice.read(bno));
	    model.addAttribute("id", session.getAttribute("id"));
//	    model.addAttribute("replyCount", session.getAttribute("replyCount"));
//	    System.out.println("readPage replyCount in session"+ session.getAttribute("replyCount"));
	    System.out.println("readPage id in  session"+ session.getAttribute("id"));
	    System.out.println("readPage id in  vo"+ projectservice.read(bno));
	    System.out.println("readPage id in  id"+ session.getAttribute("id"));

	  }

	  @RequestMapping(value = "/removePage", method = RequestMethod.POST)
	  public String remove(@RequestParam("bno") int bno, ProjectSearchCriteria projectcri, RedirectAttributes rttr) throws Exception {

	    projectservice.remove(bno);
	  
	    

	    rttr.addAttribute("page", projectcri.getPage());
	    rttr.addAttribute("PageNum", projectcri.getPerPageNum());
	    rttr.addAttribute("searchType", projectcri.getSearchType());
	    rttr.addAttribute("tkeyword", projectcri.getKeyword());

	    rttr.addFlashAttribute("msg", "SUCCESS");

	    return "redirect:/projectboard/projectlist";
	  }

	  @RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	  public void modifyPagingGET(int bno, @ModelAttribute("projectcri") ProjectSearchCriteria projectcri, Model model) throws Exception {

	    model.addAttribute(projectservice.read(bno));
	  }

	  @RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	  public String modifyPagingPOST(ProjectVO board, ProjectSearchCriteria projectcri, RedirectAttributes rttr) throws Exception {

	    logger.info(projectcri.toString());
	    projectservice.modify(board);

	    rttr.addAttribute("page", projectcri.getPage());
	    rttr.addAttribute("perPageNum", projectcri.getPerPageNum());
	    rttr.addAttribute("searchType", projectcri.getSearchType());
	    rttr.addAttribute("keyword", projectcri.getKeyword());

	    rttr.addFlashAttribute("msg", "SUCCESS");

	    logger.info(rttr.toString());

	    return "redirect:/projectboard/projectlist";
	  }

	  @RequestMapping(value = "/register", method = RequestMethod.GET)
	  public void registGET(Model model,HttpSession session) throws Exception {
		  model.addAttribute("id", session.getAttribute("id"));
	    logger.info("regist get ...........");
	    
	  }

	  @RequestMapping(value = "/register", method = RequestMethod.POST)
	  public String registPOST(ProjectVO board, RedirectAttributes rttr) throws Exception {

	    logger.info("regist post ...........");
	    logger.info(board.toString());

	    projectservice.regist(board);

	    rttr.addFlashAttribute("msg", "SUCCESS");
	    System.out.println("registPost :: "+board);
	    return "redirect:/projectboard/projectlist";
	  }

	  @RequestMapping("/getAttach/{bno}")
	  @ResponseBody
	  public List<String> getAttach(@PathVariable("bno")Integer bno)throws Exception{
	    
		  
		  System.out.println("getAttach@@@@@@@@@@@@@@@@@@@");
	    return projectservice.getAttach(bno);
	  }  
	  
	  
	  // @RequestMapping(value = "/list", method = RequestMethod.GET)
	  // public void listPage(@ModelAttribute("cri") SearchCriteria cri,
	  // Model model) throws Exception {
	  //
	  // logger.info(cri.toString());
	  //
	  // model.addAttribute("list", service.listCriteria(cri));
	  //
	  // PageMaker pageMaker = new PageMaker();
	  // pageMaker.setCri(cri);
	  //
	  // pageMaker.setTotalCount(service.listCountCriteria(cri));
	  //
	  // model.addAttribute("pageMaker", pageMaker);
	  // }
}
