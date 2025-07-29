package Dao;

import java.util.List;

import Model.Course;

public interface CourseDao {
	
	int addCourse(Course c);
	int updateCourse(Course c);
	int deleteCourse(int id);
	List<Course> getAllCourses();
}
