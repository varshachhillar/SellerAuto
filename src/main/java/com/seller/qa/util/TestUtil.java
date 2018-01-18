package com.seller.qa.util;

import org.json.JSONArray;
import org.json.JSONObject;

import com.seller.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICT_WAIT = 10;
	public static JSONObject responsejson;
	
	//Utility to read json object
	public static String getValueByJPath(JSONObject responsejson, String jpath){
		Object obj = responsejson;
		for(String s : jpath.split("/")) 
			if(!s.isEmpty()) 
				if(!(s.contains("[") || s.contains("]")))
					obj = ((JSONObject) obj).get(s);
				else if(s.contains("[") || s.contains("]"))
					obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replace("]", "")));
		return obj.toString();
}
	
	
	
	

}
