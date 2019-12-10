package com.test.params;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.enums.BookActivity;
import com.test.util.Utils;

public class BookParamBuilder {

	public <T> T buildParams(Object o, BookActivity act) {
		Object oParam = null; 
		int iIndex = 1;
		Map<Integer,Object> mParam = null;
		Map<String,Object> mBookData = null;
		List<Map<String, Object>> lJsonData = null;
		SimpleDateFormat format = new SimpleDateFormat("MMMM dd, yyyy");
		List<Map<Integer,Object>> lData = new ArrayList<Map<Integer,Object>>();
		switch(act) {
			case INSERT:
				lJsonData = (List<Map<String, Object>>) o;
				for( Map<String,Object> mData : lJsonData) {
					iIndex = 1;
					mParam = new HashMap<Integer,Object>();
					mParam.put(iIndex++, Utils.getValue(mData, "BOOK_TITLE", ""));
					mParam.put(iIndex++, Utils.getValue(mData, "BOOK_AUTHOR", ""));
					mParam.put(iIndex++, Utils.getValue(mData, "BOOK_AMOUNT", ""));
					Date date = new Date();
					try {
						date = format.parse(Utils.getValue(mData, "BOOK_PUBLISH_DATE", "Jan 1, 2019"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					mParam.put(iIndex++, date);	
					lData.add(mParam);
				}
				oParam = lData;
				break;
			case UPDATE:
				lJsonData = (List<Map<String, Object>>) o;
				for(Map<String,Object> mData : lJsonData) {
					iIndex = 1;
					mParam = new HashMap<Integer,Object>();
					mParam.put(iIndex++, Utils.getValue(mData, "BOOK_TITLE", ""));
					mParam.put(iIndex++, Utils.getValue(mData, "BOOK_AUTHOR", "")); 
					mParam.put(iIndex++, Utils.getValue(mData, "BOOK_AMOUNT", ""));
					Date date = new Date();
					try { 
						date = format.parse(Utils.getValue(mData, "BOOK_PUBLISH_DATE", "Jan 1, 2019"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					mParam.put(iIndex++, date);	
					mParam.put(iIndex++, Utils.getValue(mData, "BOOK_ID", ""));	
					lData.add(mParam);
				}
				oParam = lData;
				break;
			case DELETE:
				mBookData = (Map<String, Object>) o;
				mParam = new HashMap<Integer,Object>();
				mParam.put(iIndex++, Utils.getValue(mBookData, "BOOK_ID", ""));
				mParam.put(iIndex++, Utils.getValue(mBookData, "BOOK_TITLE", ""));
				oParam = mParam;
				break;
		}
		return (T) oParam;
	}

}
