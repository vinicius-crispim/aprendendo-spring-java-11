package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> op = repository.findById(id);
		return op.get();
	}
	
	public User saveUser(User user) {
		return repository.save(user);
	}
	
	public void deleteUser(Long id) {
		repository.deleteById(id);
	}
	
	//getOne apenas pega o objeto monitorado e depois mexe no banco, o findBy pega no banco
	public User updateUser(Long id, User user) {
		User obj = repository.getOne(id);
		updateData(obj,user);
		return repository.save(obj);
	}

	private void updateData(User obj, User user) {

		obj.setEmail(user.getEmail());
		obj.setName(user.getName());
		obj.setPhone(user.getPhone());
	}
	
	
}
