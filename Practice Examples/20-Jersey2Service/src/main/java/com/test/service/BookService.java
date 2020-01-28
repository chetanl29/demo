package com.test.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.test.dao.BookDao;

public class BookService {
	
	private BookDao bookDao;
	
	public BookService() {
		this.bookDao = new BookDao();
	}
	
	public List<Map<String,Object>> getBooks() {
		return bookDao.getBooks();
	}
	
	public Map<String,Object> addBook(String sBook){
		Map<String,Object> mRes = new HashMap<String,Object>();
		List<Map<String,Object>> lJsonData = parseJsonData(sBook);
		System.out.println("mBookData ::= "+lJsonData);
		if(bookDao.addBook(lJsonData)) {
			mRes.put("SUCCESS", "Created Successfully");
		}else {
			mRes.put("FAILURE", "Cannot create record retry again.");
		}
		return mRes;
	}
	
	public Map<String,Object> updateBook(String sBook){
		Map<String,Object> mRes = new HashMap<String,Object>();
		List<Map<String,Object>> lJsonData = parseJsonData(sBook);
		if(bookDao.updateBook(lJsonData)) {
			mRes.put("SUCCESS", "Update Successfully");
		}else {
			mRes.put("FAILURE", "Cannot update record retry again.");
		}
		return mRes;
	}
	
	public Map<String, Object> deleteMovie(String sBook) {
		Map<String,Object> mRes = new HashMap<String,Object>();
		Map<String,Object> mBookData = parseJson(sBook);
		if(bookDao.deleteBook(mBookData)) {
			mRes.put("SUCCESS", "Deleted Successfully");
		}else {
			mRes.put("FAILURE", "Cannot delete record retry again.");
		}
		return mRes;
	}
	
	private List<Map<String,Object>> parseJsonData(String jsonString) {
		System.out.println("Parsing jsonString ::= "+jsonString);
		List<Map<String,Object>> lJsonData = new ArrayList<Map<String,Object>>();
		Object token = new JSONTokener(jsonString).nextValue();
		
		if(token instanceof JSONArray) {
			JSONArray jsonArray = new JSONArray(jsonString);
			for(int i = 0; i < jsonArray.length(); i++) {
				JSONObject obj = jsonArray.getJSONObject(i);
				lJsonData.add(parseJson(obj.toString()));
			}
		}else if(token instanceof JSONObject) {
			lJsonData.add(parseJson(jsonString));
		}
		return lJsonData;
	}	
	
	private Map<String,Object> parseJson(String json){
		Map<String,Object> decryptedResponse = new LinkedHashMap<String,Object>();
		JSONObject jsonResponse;
		try {
			jsonResponse = new JSONObject(json);
			Iterator<String> keySet = jsonResponse.keys();
			while(keySet.hasNext()){
				String key  = String.valueOf(keySet.next());
				String value = String.valueOf(jsonResponse.get(key));
				if(value.startsWith("{")){
					Map<String,Object> mData = parseJson(value);
					decryptedResponse.putAll(mData);
				}else{
					decryptedResponse.put(key, value);
				}
			}	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return decryptedResponse;
	}

}
