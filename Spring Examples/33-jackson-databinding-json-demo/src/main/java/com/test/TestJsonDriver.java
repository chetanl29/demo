package com.test;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.jackson.json.demo.Address;
import com.test.jackson.json.demo.Student;

public class TestJsonDriver {

	public static void main(String[] args) {
		try {
			
			ObjectMapper mapper = new ObjectMapper();
			
			Student theStudent = 
					mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			System.out.println("First name::= "+theStudent.getFirstName());
			System.out.println("Last name:= "+theStudent.getLastName());
			
			Address tempAddress = theStudent.getAddress();
			
			System.out.println("Street::= "+tempAddress.getStreet());
			System.out.println("City::= "+tempAddress.getCity());
			
			for(String tempLang : theStudent.getLanguages()) {
				System.out.println(tempLang);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
