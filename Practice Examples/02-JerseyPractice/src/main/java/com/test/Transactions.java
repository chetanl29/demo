package com.test;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonSetter;
import org.codehaus.jackson.map.annotate.JsonRootName;

@XmlRootElement(name = "TRANSACTIONS")
@XmlType(propOrder = {"sBankName","sClientCode","sPayMode","transaction"})
public class Transactions {
	
	private String sBankName;
	
	private String sClientCode;
	
	private String sPayMode;
	
	private List<Transaction> transaction;
	
	public Transactions() {
		
	}
	
	public Transactions(String sBankName, String sClientCode, String sPayMode, List<Transaction> transaction) {
		super();
		this.sBankName = sBankName;
		this.sClientCode = sClientCode;
		this.sPayMode = sPayMode;
		this.transaction = transaction;
	}

	@XmlElement(name = "BANK_NAME")
	@JsonSetter("BANK_NAME")
	public String getsBankName() {
		return sBankName;
	}

	public void setsBankName(String sBankName) {
		this.sBankName = sBankName;
	}

	@XmlElement(name = "CLIENT_CODE")
	@JsonSetter("CLIENT_CODE")
	public String getsClientCode() {
		return sClientCode;
	}

	public void setsClientCode(String sClientCode) {
		this.sClientCode = sClientCode;
	}

	@XmlElement(name = "PAY_MODE")
	@JsonSetter("PAY_MODE")
	public String getsPayMode() {
		return sPayMode;
	}

	public void setsPayMode(String sPayMode) {
		this.sPayMode = sPayMode;
	}

	@XmlElement(name = "TRANSACTION")
	@JsonSetter("TRANSACTION")
	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "Transactions [sBankName=" + sBankName + ", sClientCode=" + sClientCode + ", sPayMode=" + sPayMode
				+ ", transaction=" + transaction + "]";
	}

}

@XmlRootElement(name = "TRANSACTION")
@XmlType(propOrder = {"sTwRefNo","sAmount"})
@JsonRootName("TRANSACTION")
class Transaction {
	
	private String sTwRefNo;
	
	private String sAmount;
	
	public Transaction() {
		
	}
	
	public Transaction(String sTwRefNo, String sAmount) {
		super();
		this.sTwRefNo = sTwRefNo;
		this.sAmount = sAmount;
	}

	@XmlElement(name = "TW_REF_NO")
	@JsonSetter("TW_REF_NO")
	public String getsTwRefNo() {
		return sTwRefNo;
	}

	public void setsTwRefNo(String sTwRefNo) {
		this.sTwRefNo = sTwRefNo;
	}

	@XmlElement(name = "AMOUNT")
	@JsonSetter("TW_REF_NO")
	public String getsAmount() {
		return sAmount;
	}

	public void setsAmount(String sAmount) {
		this.sAmount = sAmount;
	}

	@Override
	public String toString() {
		return "Transaction [sTwRefNo=" + sTwRefNo + ", sAmount=" + sAmount + "]";
	}
	
}
