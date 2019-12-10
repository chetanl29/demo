package com.test.dao;

import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.datasource.MovieDataSource;
import com.test.datasource.MovieDataSource.Type;
import com.test.enums.MovieActivity;
import com.test.params.MovieParamBuilder;
import com.test.util.Utils;

public class MovieDao {
	
	private MovieDataSource dataSource;
	
	private MovieParamBuilder paramBuilder;
	
	public MovieDao() {
		this.dataSource = new MovieDataSource();
		this.paramBuilder = new MovieParamBuilder();
	}

	public List<Map<String,Object>> getMovieList() {
		List<Map<String, Object>> lJsonData = dataSource.exequteSql("SELECT * FROM MOVIES ",Type.LIS_MAP);
		return lJsonData;
	}

	public boolean addMovie(List<Map<String, Object>> lJsonData) {
		int iResut[] = new int[0];
		/*List<Map<Integer,Object>> lData = buildParams(lJsonData);*/
		List<Map<Integer,Object>> lData = paramBuilder.buildParams(lJsonData, MovieActivity.INSERT);
		StringBuilder sbQuery = new StringBuilder("INSERT INTO MOVIES(MOVIE_NAME,MOVIE_LANGUAGE,MOVIE_RELEASE_DATE) VALUES (?,?,?)");
		iResut = dataSource.exequteSql(sbQuery.toString(), Type.INTEGER, lData);
		return iResut.length > 0;
	}

	/*private List<Map<Integer, Object>> buildParams(List<Map<String, Object>> lJsonData) {
		int iIndex = 1;
		List<Map<Integer,Object>> lData = new ArrayList<Map<Integer,Object>>();
		Map<Integer,Object> mParam = null;
		SimpleDateFormat format = new SimpleDateFormat("MMMM dd, yyyy");
		
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
		return lData;
	}*/

	public boolean deleteMovie(Map<String, Object> mMovieData) {
		int iIndex = 1;
		/*Map<Integer,Object> mParam = new HashMap<Integer,Object>();
		mParam.put(iIndex++, Utils.getValue(mMovieData, "MOVIE_ID", ""));
		mParam.put(iIndex++, Utils.getValue(mMovieData, "MOVIE_NAME", ""));*/
		Map<Integer,Object> mParam = paramBuilder.buildParams(mMovieData, MovieActivity.DELETE);
		StringBuilder sBQuery = new StringBuilder("DELETE FROM MOVIES WHERE MOVIE_ID = ? AND MOVIE_NAME = ?");
		int iCount = dataSource.exequteSql(sBQuery.toString(), Type.INTEGER,mParam);
		return iCount > 0;
	}

	public Map<String, Object> getMovieDetail(Map<String, Object> mMovieData) {
		int iIndex = 1;
		Map<Integer,Object> mParam = new HashMap<Integer,Object>();
		mParam.put(iIndex++, Utils.getValue(mMovieData, "MOVIE_NAME", ""));
		StringBuilder sBQuery =  new StringBuilder("SELECT * FROM MOVIES WHERE MOVIE_NAME = ? ");
		return dataSource.exequteSql(sBQuery.toString(), Type.MAP_SINGLE_ROW, mParam);
	}

	public boolean updateMovieDetails(List<Map<String, Object>> lJsonData) {
		/*List<Map<Integer,Object>> lData = buildUpdateParams(lJsonData);*/
		List<Map<Integer,Object>> lData = paramBuilder.buildParams(lJsonData, MovieActivity.UPDATE);;
		StringBuilder sbQuery = new StringBuilder("UPDATE MOVIES SET MOVIE_NAME = ? , MOVIE_LANGUAGE = ? , MOVIE_RELEASE_DATE = ? WHERE MOVIE_ID = ?");
		int[] iUpdateRes = dataSource.exequteSql(sbQuery.toString(), Type.INTEGER, lData);
		//return iUpdateRes.length > 0;
		return checkUpdateStatus(iUpdateRes);
	}
	
	public boolean checkUpdateStatus(int[] iResult) {
		boolean bRes = false;
		for(int iRes : iResult) {
			System.out.println("iRes ::= "+iRes);
			if(iRes == 1 || iRes == PreparedStatement.SUCCESS_NO_INFO) {
				bRes = true;
			}else {
				bRes = false;
				break;
			}
		}
		return bRes;
	}

	/*private List<Map<Integer, Object>> buildUpdateParams(List<Map<String, Object>> lJsonData) {
		int iIndex = 1;
		List<Map<Integer,Object>> lData = new ArrayList<Map<Integer,Object>>();
		Map<Integer,Object> mParam = null;
		SimpleDateFormat format = new SimpleDateFormat("MMMM dd, yyyy");
		
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
		return lData;
	}*/
}
