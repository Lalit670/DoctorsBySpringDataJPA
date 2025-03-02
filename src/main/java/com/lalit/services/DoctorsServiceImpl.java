package com.lalit.services;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
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
	public String registerDoctors(Doctors doctor) 
	{
		  Doctors doc=   repository.save(doctor);
         Integer doctor_Id = doc.getDoctor_Id();
		return "Doctor data stored successfully with id ::  "+doctor_Id+" ";
	}

	 @Override
	public String countAllDoctores() 
	 {
		  long countDoctors = repository.count();
		return "Total Doctors Count :: "+countDoctors;
	}
	 
	 @Override
	public String addGroupOfDoctors(List<Doctors> list) 
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
	 @Override
	public List<Doctors> FetchAllDoctorsData() 
	 {
		 Iterable<Doctors> allDoctors = repository.findAll();
		return StreamSupport.stream(allDoctors.spliterator(), false).toList();
	}
	 
	 @Override
	public List<Doctors> FetchAllDoctorsDataByIDs(List<Integer> list) 
	 {
		        Iterable<Doctors> allById = repository.findAllById(list);
		return StreamSupport.stream(allById.spliterator(), false).toList();
	}
	 
	/*@Override
	public Doctors fetchDoctorDataById(Integer id) 
	{
	  Optional<Doctors> byId = repository.findById(id);
	return null;
	}*/
	 
	 @Override
	public String checkDoctoreIsAvailableById(Integer id) {
		   boolean existsById = repository.existsById(id);
		return existsById?id+" Doctor is available..":"Doctor is not availabe";
	}
}
