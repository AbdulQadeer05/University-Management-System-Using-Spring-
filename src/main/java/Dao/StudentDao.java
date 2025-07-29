package Dao;

import java.util.List;

import Model.Student;

public interface StudentDao {

		void addStudent(Student t);
		void updateStudent(Student t);
		void deleteStudent(int rollno);
		List<Student> getAllStudent();
}
