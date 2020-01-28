package com.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Path("/hello")
public class Hello {
	
	@Path("/sayHello")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello World!";
	}
	
	@Path("/sayHelloXML")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String sayHelloUsingXML() {
		return "<hello>Hello World!!</hello>";
	}
	
	@Path("/sayHelloHtml")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHelloUsingHtml() {
		return "<html><head><title>Jersey Example</title></head><h1>Hello World!!!!</h1></html>";
	}
	
	@Path("/emp")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHelloJson() {	
		Employee emp = new Employee("Chetan", 100000);
		Gson gson = new Gson();
		String str = gson.toJson(emp);
		return str;
	}
	
	@GET
	@Path("/{sayHello}/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello(@PathParam("name") String sName) {
		return "Hello "+sName;
	}
	
	@POST
	@Path("/setData")
	@Produces(MediaType.APPLICATION_XML)
	public String setData(String sData) {

		try {
			JAXBContext jaxbContent = JAXBContext.newInstance(Transactions.class);
			Unmarshaller unMarshaller = jaxbContent.createUnmarshaller();
			Transactions transactions = (Transactions) unMarshaller.unmarshal(new StringReader(sData));
			System.out.println("Details ::= "+transactions.getsBankName());
		}
		catch (JAXBException e) {
			e.printStackTrace();
		}
		return "<TRANSACTIONS>SUCESS</TRANSACTIONS>";
	}
	
	@POST
	@Path("/setJsonData")
	@Produces(MediaType.APPLICATION_JSON)
	public String setJsonData(String sData) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			//mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			Transactions transaction = mapper.readValue(sData , Transactions.class);
			System.out.println("Transaction ::= "+transaction);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "{\"TRANSACTION\":\"SUCCESS\"}";
		//return Response.status(200).entity(transaction).build().toString();
	}

	public static void main1(String[] args) {
		String sData = "<TRANSACTIONS><BANK_NAME>AXIS</BANK_NAME><CLIENT_CODE>NORTHMCD</CLIENT_CODE><PAY_MODE>NEFT</PAY_MODE><TRANSACTION><TW_REF_NO>12TU5Y4045358810981</TW_REF_NO><AMOUNT>1</AMOUNT></TRANSACTION></TRANSACTIONS>";
		try {
			JAXBContext jaxbContent = JAXBContext.newInstance(Transactions.class);
			Unmarshaller unMarshaller = jaxbContent.createUnmarshaller();
			Transactions transactions = (Transactions) unMarshaller.unmarshal(new StringReader(sData));
			System.out.println("Details ::= "+transactions.getsBankName());

			Transaction transaction = new Transaction("TEST123","10.00");
			List<Transaction> list = new ArrayList<Transaction>();
			list.add(transaction);
			Transactions trans = new Transactions("AXIS", "KARNATAKA", "RTGS", list);

			Marshaller marshaller = jaxbContent.createMarshaller();
			marshaller.marshal(trans, new FileOutputStream("F:\\MARSHAL_UNMARSHAL\\test.xml"));

		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		String sData = "{\"TRANSACTIONS\": {\"BANK_NAME\": \"AXIS\",\"CLIENT_CODE\": \"NORTHMCD\",\"PAY_MODE\": \"NEFT\",\"TRANSACTION\": {\"TW_REF_NO\": \"12TU5Y4045358810981\",\"AMOUNT\": \"1\"}}}";
		Hello hello = new Hello();
		hello.setJsonData(sData);
		
	}
	
	
}
