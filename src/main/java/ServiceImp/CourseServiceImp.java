package ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.CourseDao;
import Model.Course;
import Service.CourseService;

@Service
public class CourseServiceImp implements CourseService {

	@Autowired
	private CourseDao dao;
	
	@Override
	public int add(Course c) {
		// TODO Auto-generated method stub
		return dao.addCourse(c);
	}

	@Override
	public int update(Course c) {
		// TODO Auto-generated method stub
		return dao.updateCourse(c);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return dao.deleteCourse(id);
	}

	@Override
	public List<Course> getAll() {
		// TODO Auto-generated method stub
		return dao.getAllCourses();
	}

}
