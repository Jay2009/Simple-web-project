package org.zerock.controller;

import java.util.Calendar;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.UserVO;
import org.zerock.service.UserService;

@Controller
@RequestMapping("/user/")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Inject
	private UserService service;
	
	
	
	@RequestMapping(value ="/mkidbtn", method = RequestMethod.GET)
	public void createGET(UserVO user, Model model) throws Exception {
		logger.info("createGet ...........");
		
	}//createGET
	
	@RequestMapping(value = "/mkidbtn", method = RequestMethod.POST)
	public String createPOST(UserVO user, Model model) throws Exception {
		logger.info("createPost..........");
		logger.info(user.toString());
		
		return "/user/register";
		} // createPOST
	
	@RequestMapping(value ="/success", method = RequestMethod.GET)
	public void successGET(UserVO user, Model model) throws Exception {
		logger.info("successGET ...........");
		
	}//createGET
	
	@RequestMapping(value = "/success", method = RequestMethod.POST)
	public void successPOST(UserVO user, Model model) throws Exception {
		logger.info("successPOST.............");
		logger.info(user.toString());
		
		} // createPOST
	
	@RequestMapping(value ="/jaeminkim", method = RequestMethod.GET)
	public void jaeminkimGET(UserVO user, Model model) throws Exception {
		logger.info("successGET ...........");
		
	}//jaeminkimGET
	
	@RequestMapping(value ="/customerservice", method = RequestMethod.GET)
	public void customerserviceGET(UserVO user, Model model) throws Exception {
		logger.info("successGET ...........");
		
	}//jaeminkimGET
	

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void mainGET(UserVO user, HttpSession session, Model model) throws Exception {
		logger.info("mainPOST.............");
		logger.info(user.toString());
	
		model.addAttribute("username", session.getAttribute("username"));
		model.addAttribute("balance", session.getAttribute("balance"));
		} // createPOST
	
	
	//--------------------------------------- id duplication @@@@@@@@@@@@@@@@@@@@@@@@@@@
	 	@ResponseBody
	    @RequestMapping(value = "/checkSignup", method = RequestMethod.POST)
	    public String checkSignup(HttpServletRequest request, Model model , @RequestParam("id") String idfromdb) {
	        String id = request.getParameter("id");
	        int rowcount = service.checkSignup(id);
	        
	        System.out.println(" ID from user input ::"+id);
	        System.out.println(" ID from database   ::"+idfromdb);
	        
	        model.addAttribute("rowcount",rowcount);
	        
        	return String.valueOf(rowcount);
	 	}   
	        
	        
	        
//	        if(id.equals(idfromdb)) {
//	        	System.out.println("!!!!!!!!   PK confliction   !!!!!!!!!!!!!!!" );
//	        		return String.valueOf(rowcount);
//	        }else {
//	        	model.addAttribute("rowcount",rowcount);
//	        	System.out.println("checkSignup ::::  row count =" + rowcount);
//	        	return String.valueOf(rowcount);
//	        }
	 	
	  
		//--------------------------------------- id duplication @@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	@RequestMapping(value ="/register", method = RequestMethod.GET)
	public void registerGET(UserVO user, Model model) throws Exception {
		logger.info("registerGET ...........");
		
	}//registerGET

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(UserVO user, Model model) throws Exception {
		logger.info("registPOST..........");
		logger.info("user.toString()::"+user.toString());
		
		service.regist(user);
		
//		model.addAttribute("result", "success");
		
		return "redirect:/user/login.do";
		} // registPOST
	
	
	// 01. 로그인 화면 
    @RequestMapping("login.do")
    public String login(){
        return "user/login";    // views/user/login.jsp로 포워드
    }
    
 // 02. 로그인 처리
    @RequestMapping("/loginCheck.do")
   public ModelAndView loginCheck(@ModelAttribute UserVO vo, HttpSession session){
    	
    	System.out.println("ffff::"+vo.toString());
    	System.out.println("zzzz::"+session);
    	System.out.println("idididididid::"+session.getId());
        boolean result = service.loginCheck(vo, session);
        
        vo.setBalance(service.balanceCheck(vo.getId()));

        ModelAndView mav = new ModelAndView();
        

        if (result == true) { // 로그인 성공
            // main.jsp로 이동
            mav.setViewName("user/success");
            mav.addObject("msg", "success");
            mav.addObject("username", vo.getUsername());
            mav.addObject("id", vo.getId());
            mav.addObject("balance", vo.getBalance());
            
            session.setAttribute("id", vo.getId());
            session.setAttribute("username", vo.getUsername());
            session.setAttribute("balance", vo.getBalance());
            System.out.println("logincheck sessions ::"+ vo);
        } else {    // 로그인 실패
            // login.jsp로 이동
            mav.setViewName("user/login");
            mav.addObject("msg", "failure");
        }
        return mav;
    }
    
    
    // 03. 로그아웃 처리
    @RequestMapping("logout.do")
    public ModelAndView logout(HttpSession session){
        service.logout(session);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/login");
        mav.addObject("msg", "logout");
        return mav;
    }
    
    
    @RequestMapping(value = "/mypage", method = RequestMethod.GET)
	  public void mypageGET(HttpSession session, Model model) throws Exception {
    	
        model.addAttribute("id", session.getAttribute("id"));// jay@gmail.com
           
        String id = (String)session.getAttribute("id");
        System.out.println("id::"+id);
        UserVO user = new UserVO();
        user.setId(id);
        
       model.addAttribute(service.userinforead(user));
//        model.addAttribute(service.userinforead(user));
        
        
        System.out.println(" mypage id in session ==="+ model.addAttribute("id", session.getAttribute("id")));
	  }

	  
	  @RequestMapping(value = "/mypagemodify", method = RequestMethod.GET)
	    public void mypagemodifyGET(Model model, HttpSession session) throws Exception {
		  model.addAttribute("id", session.getAttribute("id"));// jay@gmail.com
		
	      String id = (String)session.getAttribute("id");
	      UserVO user = new UserVO();
	      user.setId(id);
	      
	      model.addAttribute(service.userinforead(user));
		  System.out.println("mypagemodify ID in session"+id);
		  System.out.println("@@@modifypage GET @@@@@@@");
	    }
	
	  @RequestMapping(value = "/mypagemodify", method = RequestMethod.POST)
	  	public String mypagemodifyPOST(Model model, UserVO user, RedirectAttributes rttr, HttpSession session) throws Exception{
		  
		    System.out.println("user:::::"+user);
	        String id = (String)session.getAttribute("id");
	        user.setId(id);
	        
	        service.update(user); 
	     	
		    System.out.println("------modifypage POST--------- ");   
//		 rttr.addFlashAttribute("msg", "SUCCESS");  
	    
		  return "redirect:/user/mypage";
	  }
	 
		@RequestMapping(value ="/boom", method = RequestMethod.GET)
		public void boomGET( Model model, HttpSession session) throws Exception {
			logger.info("boomGET ...........");
			model.addAttribute("username", session.getAttribute("username"));
			
			String id = (String)session.getAttribute("id");
			UserVO vo = new UserVO();
	        vo.setId(id);
			
	        vo.setGamecnt(service.checkgamecnt(vo.getId()));
			System.out.println("check game count ::"+ vo.getGamecnt());
			 model.addAttribute("overtoday",vo.getGamecnt());
					
			
			String inTime = new java.text.SimpleDateFormat("HHmmss").format(new java.util.Date());
		    int timeint = Integer.parseInt(inTime);  // the time from the class "DATE" is String type so.
			System.out.println("current Time !!! ::"+ timeint);
			
			
			if( timeint >= 220000 && timeint <= 220500) { // game time .
				UserVO gamecntzero = new UserVO();
				gamecntzero.setId(id);
				gamecntzero.setGamecnt(service.gamecntzero(gamecntzero.getId()));
			}
			
		}//boomGET
		
		
		@RequestMapping(value ="/gameover", method = RequestMethod.POST)
		public void gameoverGET( Model model, HttpSession session, HttpServletRequest request) throws Exception {
			logger.info("boomGET ...........");
			model.addAttribute("username", session.getAttribute("username"));
			String btnjsp = request.getParameter("btn1");
			System.out.println("-- just to check btn value from button "+ btnjsp);
			
			String id = (String)session.getAttribute("id");
		    UserVO gamecnt = new UserVO();
		    gamecnt.setId(id); 
			gamecnt.setGamecnt(service.gamecnt(gamecnt.getId()));  // update
			System.out.println("check game cnt  in controller :: "+ gamecnt);
			
			

		}//gameoverGET
		
		
		
		@RequestMapping(value ="/congratulations", method = RequestMethod.GET)
		public void congratulationGET( Model model, HttpSession session) throws Exception {
			
			model.addAttribute("id", session.getAttribute("id"));
			model.addAttribute("username", session.getAttribute("username"));// username
			model.addAttribute("balance", session.getAttribute("balance"));
			
			String id = (String)session.getAttribute("id");
		    UserVO gamecnt = new UserVO();
		    gamecnt.setId(id); 
			gamecnt.setGamecnt(service.gamecnt(gamecnt.getId()));  // update
			System.out.println("congratulationsPOST winmony after adding up :: "+ gamecnt);
	     
			
			System.out.println("\t balance :: "+session.getAttribute("balance"));
		}//registerGET
		
		@RequestMapping(value ="/congratulations", method = RequestMethod.POST)
		public String congratulationPOST( Model model, HttpSession session) throws Exception {
		
			System.out.println("congratulationPOST");
			model.addAttribute("username", session.getAttribute("username"));// id
			model.addAttribute("balance", session.getAttribute("balance"));
			model.addAttribute("id", session.getAttribute("id"));
			
			String id = (String)session.getAttribute("id");
		    UserVO userbalance = new UserVO();
		    userbalance.setId(id);
		      
			System.out.println("id in congrates :: " + userbalance.getId());
			userbalance.setBalance(service.winmoney(userbalance.getId()));  // update
			System.out.println("congratulationsPOST winmony after adding up :: "+ userbalance);
			
			
			
			
			return "redirect:/user/main";
			
		}//registerGET
		
		
		 
	  
	  
	  
	  
	  
	  
//	    @ResponseBody
//	    @RequestMapping(value = "/boom", method = RequestMethod.POST)
//	    public int boom(HttpServletRequest request, Model model, @RequestParam("num") int num  ) {
//	       
//	     Random rand = new Random();
//		
//	     int i;
//	     for(i = 0; i >0 ; i++) {
//	    	 // need something before if statement
//	    	 if(num == rand.nextInt(9)) {
//	    		 
//	    		 break;
//	    	 }
//	    	
//	     }
//		 
//
//	     
//	     model.addAttribute("num",num);   
//      	return num;
//	    }

	  
	  
	  
}

		





