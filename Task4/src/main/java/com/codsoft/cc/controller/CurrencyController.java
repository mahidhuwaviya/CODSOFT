package com.codsoft.cc.controller;

import java.util.Currency;

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
			Currency curFrom= Currency.getInstance(from);
			String symbolFrom=curFrom.getSymbol();
			Currency curTo= Currency.getInstance(to);
			String symbolTo=curTo.getSymbol();
			Double rate= currencyService.getExchangeRate(from, to);
			Double convertedAmt= amt*rate;
			
			return ResponseEntity.ok().body("Original Amount:"+amt+symbolFrom+"\n Exchange Rate:"+rate+"\nConverted Amount:"+convertedAmt+symbolTo);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body("Exception occured: "+e.getMessage());
		}
	}
}
