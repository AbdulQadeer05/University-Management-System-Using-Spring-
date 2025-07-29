package Service;

import java.util.List;

import Model.Student;

public interface StudentService {

	void add(Student s);
	void update(Student s);
	void delete(int rollno);
	List<Student> getAll();
}
