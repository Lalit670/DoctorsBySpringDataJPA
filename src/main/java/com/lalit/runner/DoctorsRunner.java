package com.lalit.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lalit.entity.Doctors;
import com.lalit.services.DoctorsServiceImpl;

@Component
public class DoctorsRunner implements CommandLineRunner {

	@Autowired
	private DoctorsServiceImpl service;

	@Override
	public void run(String... args) throws Exception {

		/*  try
		  {
		 	 Doctors  doc=new Doctors("Mahesh",96231.0, "Cordiologist", "Hyderabad",9898851234L);
			
			String result=service.registerDoctors(doc);
			
			System.out.println(result);
		  }catch(Exception e)
		  {
		 	 e.printStackTrace();
		  }*/

		/*try
		{
			String count=service.countAllDoctores();
			
			System.out.println(count);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/

		try
		{
			Doctors  doc1=new Doctors("Mahesh",99231.0, "Cordiologist", "Hyderabad",9898851234L);
		 	 Doctors  doc2=new Doctors("Bharat",88231.0, "Cardio", "Nagpur",7878751234L);
		 	 Doctors  doc3=new Doctors("Ganesh",77231.0, "MD", "Bhopal",8888851234L);
		
		 	 List<Doctors> list=List.of(doc1,doc2,doc3);
		 	 
		 	 String result=service.addGroupOfDoctors(list);
		  System.err.println(result);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
