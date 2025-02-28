package com.lalit.repository;

import org.springframework.data.repository.CrudRepository;

import com.lalit.entity.Doctors;

public interface IDoctorsRepository extends CrudRepository<Doctors, Integer> {

}
