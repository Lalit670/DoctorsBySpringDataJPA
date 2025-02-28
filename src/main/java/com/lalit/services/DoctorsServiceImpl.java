package com.lalit.services;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lalit.entity.Doctors;
import com.lalit.repository.IDoctorsRepository;

@Component("doctor_service")
public class DoctorsServiceImpl implements IDoctorsService 
{

	 @Autowired
	  private IDoctorsRepository repository;
	@Override
	public String registerDoctors(Doctors doctor) throws Exception 
	{
		  Doctors doc=   repository.save(doctor);
         Integer doctor_Id = doc.getDoctor_Id();
		return "Doctor data stored successfully with id ::  "+doctor_Id+" ";
	}

	 @Override
	public String countAllDoctores() throws Exception 
	 {
		  long countDoctors = repository.count();
		return "Total Doctors Count :: "+countDoctors;
	}
	 
	 @Override
	public String addGroupOfDoctors(List<Doctors> list) throws Exception 
	 {
		 // Down casting
		  /*Iterable<Doctors> addGroupOfDoctor = repository.saveAll(list);
		  List<Doctors> listOfDoctors=(List<Doctors>)addGroupOfDoctor;
		  int count = listOfDoctors.size();
		return count+" Doctors added successfully with id : "+listOfDoctors;*/
         
		 // use stream API
		   Iterable<Doctors> saveAll = repository.saveAll(list);
		   List<Integer> lsitOfDoctor = StreamSupport.stream(saveAll.spliterator(), false).map(Doctors::getDoctor_Id).collect(Collectors.toList());
		 
		   return lsitOfDoctor.size()+" Doctors stored successfully.. with Ids :: "+lsitOfDoctor;
	 }
	 
}
