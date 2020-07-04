package com.test.params;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.enums.MovieActivity;
import com.test.util.Utils;

public class MovieParamBuilder {
	
	public MovieParamBuilder() {
		super();
	}

	@SuppressWarnings("unchecked")
	public <T> T buildParams(Object o , MovieActivity activity) {
		Object oParam = null; 
		int iIndex = 1;
		Map<Integer,Object> mParam = null;
		Map<String,Object> mMovieData = null;
		List<Map<String, Object>> lJsonData = null;
		SimpleDateFormat format = new SimpleDateFormat("MMMM dd, yyyy");
		List<Map<Integer,Object>> lData = new ArrayList<Map<Integer,Object>>();

		switch(activity) {
		case INSERT:
			lJsonData = (List<Map<String, Object>>) o;
			for( Map<String,Object> mData : lJsonData) {
				iIndex = 1;
				mParam = new HashMap<Integer,Object>();
				mParam.put(iIndex++, Utils.getValue(mData, "MOVIE_NAME", ""));
				mParam.put(iIndex++, Utils.getValue(mData, "MOVIE_LANGUAGE", ""));
				Date date = new Date();
				try {
					date = format.parse(Utils.getValue(mData, "MOVIE_RELEASE_DATE", "Jan 1, 2019"));
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
				mParam.put(iIndex++, Utils.getValue(mData, "MOVIE_NAME", ""));
				mParam.put(iIndex++, Utils.getValue(mData, "MOVIE_LANGUAGE", ""));
				Date date = new Date();
				try { 
					date = format.parse(Utils.getValue(mData, "MOVIE_RELEASE_DATE", "Jan 1, 2019"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				mParam.put(iIndex++, date);	
				mParam.put(iIndex++, Utils.getValue(mData, "MOVIE_ID", ""));	
				lData.add(mParam);
			}
			oParam = lData;
			break;
		case DELETE:
			mMovieData = (Map<String, Object>) o;
			mParam = new HashMap<Integer,Object>();
			mParam.put(iIndex++, Utils.getValue(mMovieData, "MOVIE_ID", ""));
			mParam.put(iIndex++, Utils.getValue(mMovieData, "MOVIE_NAME", ""));
			oParam = mParam;
			break;
		default:
			break;
		}
		return (T) oParam;
	}

}
