package com.example.demo;




import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.Map.Entry;

import javax.validation.Valid;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;


@RestController
@RequestMapping("/calculate")
public class CalculatorController {


	@GetMapping(value="/add")
	public BigDecimal topla(@RequestParam BigDecimal number1,@RequestParam BigDecimal number2)
	{
		return number1.add(number2);
	}
	@PostMapping(value="/add")
	@ResponseBody
	public BigDecimal topla2(@RequestBody Calculator cal)throws Exception
	{

		return cal.getNumber1().add(cal.getNumber2());

	}
	@PostMapping(value="/multipleadd",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public CalculateNumber multipleadd(@RequestBody String numbers)throws Exception
	{  
		CalculateNumber madd=new CalculateNumber();
		Integer result =0;
		JsonParser jsonParser=new JsonParser();

		JsonObject j=(JsonObject) jsonParser.parse(numbers);
		
		for(Map.Entry<String, JsonElement> entry : j.entrySet()) {
			JsonArray ss=entry.getValue().getAsJsonArray();
			for (int i = 0; i < ss.size(); i++) {
				result +=ss.get(i).getAsInt();

			}
		}
	//	System.out.println(result);
		
		madd.setResult(result.toString());



		return madd;
	}
 

	
 
	@PostMapping(value="/multiplemultiply",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public CalculateNumber multiplemultiply(@RequestBody String numbers)throws Exception
	{  
		CalculateNumber mmultiply=new CalculateNumber();
		Integer result = 1;
		JsonParser jsonParser=new JsonParser();

		JsonObject j=(JsonObject) jsonParser.parse(numbers);
		
		for(Map.Entry<String, JsonElement> entry : j.entrySet()) {
			JsonArray ss=entry.getValue().getAsJsonArray();
			for (int i = 0; i < ss.size(); i++) {
				result =result * ss.get(i).getAsInt();

			}
		}
		System.out.println(result);
		
		mmultiply.setResult(result.toString());



		return mmultiply;
	}
	
	
	@PostMapping(value="/multiplesubtract",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public CalculateNumber multiplesubtract(@RequestBody String numbers)throws Exception
	{  
		CalculateNumber msubtract=new CalculateNumber();
		Integer result = 0;
		JsonParser jsonParser=new JsonParser();

		JsonObject j=(JsonObject) jsonParser.parse(numbers);
		
		for(Map.Entry<String, JsonElement> entry : j.entrySet()) {
			JsonArray ss=entry.getValue().getAsJsonArray();
			for (int i = 0; i < ss.size(); i++) {
				result =result - ss.get(i).getAsInt();

			}
		}
		System.out.println(result);
		
		msubtract.setResult(result.toString());



		return msubtract;
	}
	
	
	
	//burada bir sıkıntı var???
	@PostMapping(value="/multipledivide",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public CalculateNumber multipledivide(@RequestBody String numbers)throws Exception
	{  
		CalculateNumber mdivide=new CalculateNumber();
		Integer result = 0;
		Integer result_init=0;
		JsonParser jsonParser=new JsonParser();

		JsonObject j=(JsonObject) jsonParser.parse(numbers);
		
		for(Map.Entry<String, JsonElement> entry : j.entrySet()) {
			JsonArray ss=entry.getValue().getAsJsonArray();
			for (int i = 0; i < ss.size()-1; i++) {
				
				result_init =  ss.get(i).getAsInt()/ss.get(i+1).getAsInt();
				result=result_init/ss.get(i+2).getAsInt();
				System.out.print(result);
			}
		}
		System.out.println("result is :"+ result);
		
	mdivide.setResult(result.toString());



		return mdivide;
	}
	@GetMapping(value="/subtract")
	public BigDecimal cikarma(@RequestParam BigDecimal number1,@RequestParam BigDecimal number2)
	{
		return number1.subtract(number2);
	}
	@PostMapping(value="/subtract")
	@ResponseBody
	public BigDecimal cıkarma2(@RequestBody Calculator cal)throws Exception
	{

		return cal.getNumber1().subtract(cal.getNumber2());

	}

	@GetMapping(value="/divide")
	public BigDecimal bolme(@RequestParam BigDecimal number1,@RequestParam BigDecimal number2)
	{
		return number1.divide(number2,2,RoundingMode.HALF_EVEN);
	}
	@PostMapping(value="/divide")
	@ResponseBody
	public BigDecimal bolme2(@RequestBody Calculator cal)throws Exception
	{

		return cal.getNumber1().divide(cal.getNumber2(),2,RoundingMode.HALF_EVEN);

	}



	@GetMapping(value="/multiply")
	public BigDecimal carpma(@RequestParam BigDecimal number1,@RequestParam BigDecimal number2)
	{
		return number1.multiply(number2);
	}
	@PostMapping(value="/multiply")
	@ResponseBody
	public BigDecimal carpma2(@RequestBody Calculator cal)throws Exception
	{

		return cal.getNumber1().multiply(cal.getNumber2());

	}

}
