package com.lalit.services;

import java.util.List;

import com.lalit.entity.Doctors;

public interface IDoctorsService 
{
      public String registerDoctors(Doctors doctor) throws Exception;
      public String countAllDoctores() throws Exception;
      public String addGroupOfDoctors(List<Doctors> list) throws Exception;
      
}
