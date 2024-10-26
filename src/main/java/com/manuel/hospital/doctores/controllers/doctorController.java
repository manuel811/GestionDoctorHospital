package com.manuel.hospital.doctores.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.manuel.hospital.doctores.entity.Doctor;
import com.manuel.hospital.doctores.services.doctorServicioImpl;

@RestController
@RequestMapping("doctor")
public class doctorController {

@Autowired
private doctorServicioImpl doctorServicioImpl;
	

@GetMapping()
public ResponseEntity<List<Doctor>> findAll(){
	try {
		 return ResponseEntity.ok(doctorServicioImpl.findAll());
		
	}catch (Exception e) {
		
	return ResponseEntity.notFound().build();
	}

}


@GetMapping("/{id}")
public ResponseEntity<Doctor>finById(@PathVariable Long id){
	try {
		
		return ResponseEntity.ok(doctorServicioImpl.findById(id));
		
		
	}catch (Exception e) {
	return ResponseEntity.notFound().build();

	}
}


@PostMapping
public ResponseEntity<Doctor>save(@RequestBody Doctor doctor ){
	try {
		return ResponseEntity.ok(doctorServicioImpl.save(doctor));
	}catch (Exception e) {
		return ResponseEntity.notFound().build();
	}
}


@PutMapping("/{id}")
public ResponseEntity<Doctor>update(@PathVariable Long id, @RequestBody Doctor doctor){
	try {
		return ResponseEntity.ok(doctorServicioImpl.update(id, doctor));
	}catch (Exception e) {
		return ResponseEntity.notFound().build();
	}
	
}


@DeleteMapping("/{id}")
public ResponseEntity<Void>delete(@PathVariable Long id){
	try {
		return ResponseEntity.ok(doctorServicioImpl.delete(id));
	}catch (Exception e) {
		return ResponseEntity.notFound().build();
	}
	
	
}


//RestTemplate


@GetMapping("/nombre/{nombre}/apellidos/{apellidos}")
public ResponseEntity<Doctor>findNameAndSurname(@PathVariable String nombre, @PathVariable String apellidos){
	
	try {
		
		return ResponseEntity.ok(doctorServicioImpl.findByNameAndSurname(nombre, apellidos));
		
		
	}catch (Exception e) {
		return ResponseEntity.notFound().build();
	}
	
	
	
}





}
