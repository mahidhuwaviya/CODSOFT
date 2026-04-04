package com.codsoft.cc.DTO;

import java.util.Map;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//@Getter
//@Setter
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class ExchagneRateResponse {
	private String result;
	private String base_code;
	private Map<String,Double>conversion_rates;
	
	
	
	public ExchagneRateResponse(String result, String base_code, Map<String, Double> conversion_rates) {
		super();
		this.result = result;
		this.base_code = base_code;
		this.conversion_rates = conversion_rates;
	}
	public ExchagneRateResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getBase_code() {
		return base_code;
	}
	public void setBase_code(String base_code) {
		this.base_code = base_code;
	}
	public Map<String, Double> getConversion_rates() {
		return conversion_rates;
	}
	public void setConversion_rates(Map<String, Double> conversion_rates) {
		this.conversion_rates = conversion_rates;
	}
	@Override
	public String toString() {
		return "ExchagneRateResponse [result=" + result + ", base_code=" + base_code + ", conversion_rates="
				+ conversion_rates + "]";
	}
	

}
