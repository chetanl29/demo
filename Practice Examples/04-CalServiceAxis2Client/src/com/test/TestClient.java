package com.test;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import com.test.CalServiceStub.AddResponse;
import com.test.CalServiceStub.SubResponse;

public class TestClient {

	public static void main(String[] args) throws RemoteException {

		CalServiceStub stub = new CalServiceStub();
		CalServiceStub.Add add = new CalServiceStub.Add();
		add.setI(10);
		add.setJ(20);
		
		AddResponse addRes = stub.add(add);
		System.out.println("Add ::= "+addRes.get_return());
		
		CalServiceStub.Sub sub = new CalServiceStub.Sub();
		sub.setI(20);
		sub.setJ(10);
		
		SubResponse subRes = stub.sub(sub);
		System.out.println("Sub ::= "+subRes.get_return());
	}

}
