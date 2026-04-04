package com.codsoft.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.codsoft.daoImpl.AccountDaoImpl;
import com.codsoft.pojo.Account;
@Controller
public class AccountController {

	@Autowired
	private AccountDaoImpl daoimpl;
	
	@GetMapping("/amdaccount")
	public String admAccPage()
	{
		return "amdaccount";
	}
	
	@GetMapping("/home")
	public String getHomePage()
	{
		return "home";
	}
	
	@PostMapping("/saveaccount")
	public ModelAndView saveAcc(Account a, @RequestParam("b1")String op) {
		ModelAndView mv= null;
		if(op.equals("Open Acc")) {
			if(daoimpl.openAcc(a)) {
				mv= new ModelAndView("amdaccount","msg","Account Opened Successfully!!");
			}
			else {
				mv= new ModelAndView("amdaccount","msg","Account Couldn't be Opened !!");

			}
		}
		
		if(op.equals("Update Acc")) {
			if(daoimpl.updateAcc(a)) {
				mv= new ModelAndView("amdaccount","msg","Account Updated Successfully!!");
			}
			else {
				mv= new ModelAndView("amdaccount","msg","Account Couldn't be Updated !!");

			}
			
		}
		
		if(op.equals("Close Acc")) {
			if(daoimpl.deleteAcc(a)) {
				mv= new ModelAndView("amdaccount","msg","Account Deleted Successfully!!");
			}
			else {
				mv= new ModelAndView("amdaccount","msg","Account Couldn't be Deleted !!");

			}
		}
		return mv;
	}
	
	@GetMapping("/listofaccounts")
	public ModelAndView listOfAllPage() {
		ModelAndView mv= null;
		List<Account> lst= daoimpl.getAllAccount();
		mv= new ModelAndView("listOfAllAccounts","allacc",lst);
		return mv;
	}
	
	@GetMapping("/search")
	public String searchAcc(Model m)
	{
		List<Account>lst = daoimpl.getAllAccount() ;
		m.addAttribute("allacc",lst);
		return "search";
		
	}
	
	@PostMapping("/accoperation")
	public String getAction(@RequestParam("s1")String no,
			@RequestParam("action")String op,Model m)
	{
		int accno = Integer.parseInt(no);
		Account a = daoimpl.searchAcc(accno);
		m.addAttribute("account",a);
		if(op.equals("Withdraw"))
			return "withdraw";
		else
			return "deposite";
			
	}
	
	@PostMapping("/accaction")
	public String accaction(
			Account a,@RequestParam("amt")String amt,
			@RequestParam("b1")String op,Model m)
	{
		double amount = Double.parseDouble(amt);
	
		if(op.equals("Withdraw"))
		{
			Account afterWihdraw= daoimpl.withdraw(a.getAccno(), amount);
			if(afterWihdraw!=null) {
				m.addAttribute("curamt",afterWihdraw.getBal());
				if(daoimpl.updateAcc(afterWihdraw)){
					m.addAttribute("msg","Amount Withdraw Successfully");
				    return "withdraw";
				}
				else{
					m.addAttribute("msg","error occured, check bal!! ");
				 	return "withdraw";
				}
			}
			else{
				m.addAttribute("msg","error occured, check bal!! ");
			 	return "withdraw";
			}
		}
		if(op.equals("deposite"))
		{
			Account afterDep= daoimpl.deposit(a.getAccno(), amount);
			m.addAttribute("curamt",afterDep.getBal());
			if(daoimpl.updateAcc(afterDep)){
				m.addAttribute("msg","Amount Deposited Successfully");
			    return "deposite";
			}
			else{
				m.addAttribute("msg","Deposite failed");
			 	return "deposite";
			}
		}
		m.addAttribute("msg","error occur");
		return "accoperation";
		
	}
	
}