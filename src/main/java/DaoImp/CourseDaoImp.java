package DaoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Dao.CourseDao;
import Model.Course;
import RowMapper.CourseRowMapper;
@Repository
public class CourseDaoImp implements CourseDao {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public int addCourse(Course c) {
		String sql="INSERT INTO course (course_name, description, credits, dept_id) VALUES(?, ?, ?, ?)";
		return	jdbc.update(sql, c.getName(), c.getDescription(), c.getCredits(), c.getDept_id());
		
	}

	@Override
	public int updateCourse(Course c) {
		String sql="UPDATE course SET course_name=?, description=?, credits=?, dept_id=? WHERE course_id=?";
	return jdbc.update(sql, c.getName(), c.getDescription(), c.getCredits(), c.getDept_id(), c.getCourse_id());

	}

	@Override
	public int deleteCourse(int id) {
		String sql="DELETE FROM course WHERE course_id=?";
	return jdbc.update(sql,id);

	}

	@Override
	public List<Course> getAllCourses() {

		String sql="SELECT * FROM course";
			return jdbc.query(sql, new CourseRowMapper());

	}

}
