package com.test.dao;

import java.util.List;
import java.util.Map;

import com.test.datasource.BookDataSource;
import com.test.datasource.BookDataSource.Type;
import com.test.enums.BookActivity;
import com.test.params.BookParamBuilder;


/*CREATE TABLE BOOKS(
BOOK_ID INTEGER GENERATED BY DEFAULT AS IDENTITY,
BOOK_TITLE VARCHAR(50), 
BOOK_AUTHOR VARCHAR(50),
BOOK_PUBLISH_DATE DATE,
BOOK_AMOUNT DOUBLE)*/
public class BookDao {

	private BookDataSource dataSource;
	
	private BookParamBuilder paramBuilder;
	
	public BookDao() {
		this.dataSource = new BookDataSource();
		this.paramBuilder = new BookParamBuilder();
	}
	
	public List<Map<String,Object>> getBooks() {
		String sqlQuery = "SELECT * FROM BOOKS";
		return dataSource.exequteSql(sqlQuery, Type.LIST_MAP);
	}
	
	public boolean addBook(List<Map<String,Object>> lBook) {
		int iResut[] = new int[0];
		String sqlQuery = "INSERT INTO BOOKS(BOOK_TITLE,BOOK_AUTHOR,BOOK_AMOUNT,BOOK_PUBLISH_DATE) VALUES(?,?,?,?)";
		List<Map<Integer,Object>> lData = paramBuilder.buildParams(lBook, BookActivity.INSERT);
		System.out.println("lData ::="+lData );
		iResut = dataSource.exequteSql(sqlQuery, Type.INTEGER, lData);
		return iResut.length >  0;
	}
	
	public boolean updateBook(List<Map<String,Object>> lBook) {
		int iResut[] = new int[0];
		String sqlQuery = "UPDATE BOOKS SET BOOK_TITLE = ? ,BOOK_AUTHOR = ? ,BOOK_AMOUNT = ? ,BOOK_PUBLISH_DATE = ? WHERE BOOK_ID = ?";
		List<Map<Integer,Object>> lData = paramBuilder.buildParams(lBook, BookActivity.UPDATE);
		System.out.println("lData in Update Book ::="+lData);
		iResut = dataSource.exequteSql(sqlQuery, Type.INTEGER, lData);
		return iResut.length >  0;
	}
	
	public boolean deleteBook(Map<String,Object> mBookData) {
		Map<Integer,Object> mParam = paramBuilder.buildParams(mBookData, BookActivity.DELETE);
		StringBuilder sBQuery = new StringBuilder("DELETE FROM BOOKS WHERE BOOK_ID = ? AND BOOK_TITLE = ?");
		int iCount = dataSource.exequteSql(sBQuery.toString(), Type.INTEGER,mParam);
		return iCount > 0;
	}
	
}
