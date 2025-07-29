package Dao;

import java.util.List;

import Model.Teacher;

public interface TeacherDao {

	void addTeacher(Teacher t);
	void updateTeacher(Teacher t);
	void deleteTeacher(int id);
	List<Teacher> getAllTeachers();
}
