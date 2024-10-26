package com.manuel.hospital.doctores.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manuel.hospital.doctores.entity.Doctor;

@Repository
public interface doctorRepositorio extends JpaRepository<Doctor,Long>{
	
	public Doctor findByNombreAndApellidos(String nombre,String apellidos);

	
}
