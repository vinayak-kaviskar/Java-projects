package com.exam.notify.repositories;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.exam.notify.models.Task;

public interface TasksRepository extends CrudRepository<Task, Integer> {

	List<Task> findAll();

	List<Task> findByIsCompletedFalse();

	<S extends Task> S save(S entity);

	void delete(Task task);

	Optional<Task> findById(Integer id);

	List<Task> findByReminderTimeBetweenAndIsCompletedFalse(Timestamp startTime,Timestamp endTime);
}
