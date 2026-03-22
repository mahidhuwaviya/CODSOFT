package com.codsoft.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class GuessTheNumberController {
	
	@GetMapping("/")
	public String landingPage(HttpSession session, Model m) {
		if(session.getAttribute("TargetGuessNumber")==null) {
			startNewRound(session);
		}
		updateModel(session,m);
		return "Landing";
	}

	@PostMapping("/resetGame")
	public String resetGame(HttpSession s) {
		startNewRound(s);
		return "redirect:/";
	}
	
	@PostMapping ("/startGame")
	public String gameStarts(
			@RequestParam ("userGuess") int UserGusess,
			@RequestParam (value="maxAttempts",required = false) Integer maxAttempts,
			HttpSession session,
			Model m){
		if (session.getAttribute("remainingGuesses")==null && maxAttempts!=null) {
			session.setAttribute("remainingGuesses", maxAttempts);
		}
		int target= (int)session.getAttribute("targetNumber");
		int remainingGuesses=(int)session.getAttribute("remainingGuesses")-1;
		int currentPoints=(int)session.getAttribute("points");
		session.setAttribute("remainingGuesses",remainingGuesses);
		if(remainingGuesses<=0) {
			session.setAttribute("points", currentPoints+(remainingGuesses*10));
			m.addAttribute("message", "You Coudln't Guess It :( The Number Was:"+target);
			m.addAttribute("gameOver", true);
		}
		else if(UserGusess==target) {
			session.setAttribute("points", currentPoints+(remainingGuesses*10)+10);
			m.addAttribute("message", "You Guesssed It RIGHT!!! The Number Was:"+target);
			m.addAttribute("gameOver", true);
		}else if(UserGusess<target) {
			m.addAttribute("message", "GO Higher");
		}else {
			m.addAttribute("message", "Go Lower");
		}
		
		
		updateModel(session,m);
		return "Landing";
		
	}
	private void startNewRound(HttpSession session) {
		session.setAttribute("targetNumber", new Random().nextInt(100)+1);
		session.removeAttribute("remainingGuesses");
		if(session.getAttribute("points")==null) {
			session.setAttribute("points", 0);
		}
	}
	private void updateModel(HttpSession session,Model m) {
		m.addAttribute("points",session.getAttribute("points"));
		m.addAttribute("remainingGuesses",session.getAttribute("remainingGuesses"));
	}
	
}
