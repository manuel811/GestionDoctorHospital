package com.manuel.hospital.doctores.services;

import java.util.List;

import com.manuel.hospital.doctores.entity.Doctor;

public interface doctorServicio<E>{
	
	public List<E> findAll() throws Exception; //Encontrar todo
	
	public E findById(Long id) throws Exception; // Encontrar por id
	
	public E save(E entity) throws Exception; // CREAR
	
	public E update(Long id, E entity) throws Exception; //Actualizar
	
	public Void delete(Long id) throws Exception; // Borrar
	
	public Doctor findByNameAndSurname(String nombre, String apellidos) throws Exception;
	
	

}
