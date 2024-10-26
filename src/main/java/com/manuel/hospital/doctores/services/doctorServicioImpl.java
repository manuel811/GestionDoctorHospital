package com.manuel.hospital.doctores.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manuel.hospital.doctores.entity.Doctor;
import com.manuel.hospital.doctores.repository.doctorRepositorio;

import jakarta.transaction.Transactional;

@Service
public class doctorServicioImpl implements doctorServicio<Doctor> {
	
	@Autowired
	private doctorRepositorio doctorRepositorio;
	

    @Transactional
	@Override
	public List<Doctor> findAll() throws Exception {
	
		try {
			List<Doctor>doctores=doctorRepositorio.findAll();
			return doctores;
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

    @Transactional
	@Override
	public Doctor findById(Long id) throws Exception {
		
		try {
			Optional<Doctor>doctorId=doctorRepositorio.findById(id);
			return doctorId.get();
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

    @Transactional
	@Override
	public Doctor save(Doctor entity) throws Exception {
		
		try {
			return doctorRepositorio.save(entity);
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

    @Transactional
	@Override
	public Doctor update(Long id, Doctor entity) throws Exception {
    	try {
    		Optional<Doctor>NuevoDoctor=doctorRepositorio.findById(id);
    		Doctor doctor=NuevoDoctor.get();
    		doctor=doctorRepositorio.save(entity);
    		return doctor;
    		
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
    	
    	
		
	}

    @Transactional
	@Override
	public Void delete(Long id) throws Exception {
    	
    	try {
			
    		doctorRepositorio.deleteById(id);
    		
    		
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return null;
		
	}

	@Override
	public Doctor findByNameAndSurname(String nombre, String apellidos) throws Exception {
		
		
		try {
			return doctorRepositorio.findByNombreAndApellidos(nombre, apellidos);
		}catch (Exception e) {
		
			throw new Exception(e.getMessage());
		}
			
	}

	


	
	
	
}
