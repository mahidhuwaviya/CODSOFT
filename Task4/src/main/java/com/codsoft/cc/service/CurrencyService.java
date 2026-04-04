package com.codsoft.cc.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codsoft.cc.DTO.ExchagneRateResponse;

@Service
public class CurrencyService {

	@Value("${EXCHANGE_RATE_API_KEY}")
	private String EXCHANGE_RATE_API_KEY;
	
	@Value("${EXCHANGE_RATE_BASE_URL}")
	private String EXCHANGE_RATE_BASE_URL;
	
	public Double getExchangeRate (String from , String to) {
		RestTemplate restTemplate= new RestTemplate();
		String url = EXCHANGE_RATE_BASE_URL+ EXCHANGE_RATE_API_KEY+"/latest/"+from;
		ExchagneRateResponse response= restTemplate.getForObject(url, ExchagneRateResponse.class);
		if(response!=null && response.getConversion_rates()!=null) {
			return response.getConversion_rates().get(to);
		}
		return null;
	}
}
