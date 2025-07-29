package ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.TeacherDao;
import Model.Teacher;
import Service.TeacherService;
@Service
public class TeacherServiceImp implements TeacherService {
		
	@Autowired
	private TeacherDao dao;
	
	@Override
	public void add(Teacher t) {
		// TODO Auto-generated method stub
		dao.addTeacher(t);
	}

	@Override
	public void update(Teacher t) {
		// TODO Auto-generated method stub
		dao.updateTeacher(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.deleteTeacher(id);
	}

	@Override
	public List<Teacher> getAll() {
		// TODO Auto-generated method stub
		return dao.getAllTeachers();
	}

}
