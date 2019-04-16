package com.exam.todoapp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.exam.todoapp.models.Task;

public interface TasksRepository extends CrudRepository<Task,Integer>{
	
	List<Task>findAll();
	
	List<Task>findByUserId(Long userId);
	
	<S extends Task> S save(S entity);
	
	void  delete(Task task);
	
	Optional<Task> findById(Integer id);
	

}
