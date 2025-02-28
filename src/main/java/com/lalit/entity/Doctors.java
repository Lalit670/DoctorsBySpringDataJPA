package com.lalit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name="Doctors")
public class Doctors 
{
	 
	 @Id
	 @Column(name="DID")
	 @SequenceGenerator(name="gen1", sequenceName = "doc_seq", initialValue = 100, allocationSize = 1)
	 @GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
      private Integer doctor_Id;
	 
	  
	 @Column(name="DNAME", length=30)
	 @NonNull
      private String doctor_name;
	  
	 @Column(name="DINCOME")
	 @NonNull
      private Double income;
	 
	 @Column(name="SPECIALIST", length=30)
	 @NonNull
      private String specialist;
	 
	 
	 @Column(name="ADDRESS" ,length=30)
	 @NonNull
      private String address;
	 
	 
	 @Column(name="PHONE")
	 @NonNull
      private Long phone;
}
