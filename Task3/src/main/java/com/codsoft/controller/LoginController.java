package com.codsoft.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.codsoft.daoImpl.UserInfoDaoImpl;
import com.codsoft.pojo.UserInfo;




@Controller
public class LoginController {

    private final AccountController accountController;

	@Autowired
	private UserInfoDaoImpl daoimpl;
	


    LoginController(AccountController accountController) {
        this.accountController = accountController;
    }
	
	
	
	@GetMapping("/")
	public String indexPage()
	{
		return "index";
	}

	@GetMapping("/reg")
	public String regPage()
	{
		return "reg";
	}

	@RequestMapping(value = "/checkUser",method = RequestMethod.POST)
	public String checkUser(UserInfo u,Model m,HttpServletRequest request)
	{
		UserInfo user= daoimpl.checkUserCredential(u);
		
		if(user!=null)
		{
			HttpSession session= request.getSession();
			if(session!=null) {
				m.addAttribute("msg","Welcome To Universal Informatics");
				m.addAttribute("dp",user.getDp());
				
				return "home";
			}
			return "index";
		}
		else
		{
			m.addAttribute("msg","Invelid Username / Password");
			return "index";
		}
	
	}
	
//	@RequestParam("dp")MultipartFile file)throws Exception

	
	@PostMapping("/addNewUser")
	public ModelAndView addNew(HttpServletRequest request,
			@RequestParam("username")String user,
			@RequestParam("password")String password,
            @RequestParam("b1") String op,
            HttpSession session)
	{
		
		System.out.println("heeijfie");
		ModelAndView mv=null;
		
		try {
			
			
			UserInfo u= new UserInfo();
			u.setUsername(user);
			u.setPassword(password);		
			String otp1 ;
			
			 if(op.equals("signUp")) {
				
					if(daoimpl.addNewUser(u)) {
						mv = new ModelAndView("index","msg","User Register Successfully, Can login here");
					}
					else {
						mv = new ModelAndView("reg","msg","User Could Not Be Register");
					}
			
			}
				else {
					mv = new ModelAndView("reg","msg","User Could Not Be Register");
				}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			mv = new ModelAndView("reg","msg"," somehing went wrong");
		}
		return mv;
	}
}
