package Service;

import java.util.List;

import Model.Teacher;

public interface TeacherService {

	void add(Teacher t);
	void update(Teacher t);
	void delete(int id);
	List<Teacher> getAll(); 
}
