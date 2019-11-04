package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner {

	@Autowired
	private DataScript dataScript;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//dataScript.createApprover();
		//dataScript.createPrivilege();
		//dataScript.createRole();
		//dataScript.project();
		//dataScript.createUser();
		//dataScript.vendorType();
		//dataScript.vendor();
		dataScript.unit();
		dataScript.grade();
		dataScript.item();
		dataScript.requisitionItem();
		dataScript.requisition();
		//dataScript.updateUser();
		// dataScript.getUser();

		

	}

}
