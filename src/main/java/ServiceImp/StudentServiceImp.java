package ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.StudentDao;
import Model.Student;
import Service.StudentService;

@Service
public class StudentServiceImp implements StudentService {
	@Autowired
	private StudentDao dao;
	
	
	@Override
	public void add(Student s) {
		dao.addStudent(s);
		
	}

	@Override
	public void update(Student s) {
		// TODO Auto-generated method stub
		dao.updateStudent(s);
	}

	@Override
	public void delete(int rollno) {
		// TODO Auto-generated method stub
		dao.deleteStudent(rollno);
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return dao.getAllStudent();
	}

}
