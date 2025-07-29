package Service;

import java.util.List;

import Model.Course;

public interface CourseService {
	 
	int add(Course c);
	int update(Course c);
	int delete(int id);
	List<Course> getAll();
}
