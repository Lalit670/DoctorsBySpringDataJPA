package com.lalit.services;

import java.util.List;

import com.lalit.entity.Doctors;

public interface IDoctorsService 
{
      public String registerDoctors(Doctors doctor);
      public String countAllDoctores() ;
      public String addGroupOfDoctors(List<Doctors> list) ;
      
      public List<Doctors> FetchAllDoctorsData();
      public List<Doctors> FetchAllDoctorsDataByIDs(List<Integer> list);
     // public Doctors fetchDoctorDataById(Integer id);
      public String checkDoctoreIsAvailableById(Integer id);
      
}
