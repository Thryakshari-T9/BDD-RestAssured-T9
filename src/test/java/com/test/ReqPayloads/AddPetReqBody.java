package com.test.ReqPayloads;

import java.util.LinkedHashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AddPetReqBody {

	
public static JSONObject ReturnAddPetRequestPayload(int id, String Name, String Status, String NameCtg, String PhotoUrls, String TagName ) {
		
		
		JSONObject obj =  new JSONObject();
	
		obj.put("id", id);
		obj.put("name", Name);
		obj.put("status", Status);
	
		
		LinkedHashMap category  =  new LinkedHashMap();
		
		category.put("id", 0);
		category.put("name", NameCtg);
		obj.put("category", category);
		
		
		JSONArray photoUrls = new JSONArray();
		photoUrls.add(PhotoUrls);
		obj.put("photoUrls", photoUrls);
		
		
		JSONArray tags = new JSONArray();
		LinkedHashMap map  =  new LinkedHashMap();
		map.put("id", 0);
		map.put("name", TagName);
		tags.add(map);
		obj.put("tags", tags);
		
		
		System.out.println(obj);
		return obj;
		
	}		
	
	
}
