package com.codsoft.cc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codsoft.cc.service.CurrencyService;

@RestController
public class CurrencyController {
	
	@Autowired
	private CurrencyService currencyService;

	@GetMapping("/getCurrencyVal")
	public ResponseEntity<?> showCurrencyVal(
			@RequestParam(value = "from")String from,
			@RequestParam(value = "to")String to,
			@RequestParam(value="amt")Double amt
			){
		try {
			Double rate= currencyService.getExchangeRate(from, to);
			Double convertedAmt= amt*rate;
			
			return ResponseEntity.ok().body("Original Amount:"+amt+"\n Exchange Rate:"+rate+"\nConverted Amount:"+convertedAmt);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body("Exception occured: "+e.getMessage());
		}
	}
}
