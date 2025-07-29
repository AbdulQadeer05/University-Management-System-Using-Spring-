package DaoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Dao.TeacherDao;
import Model.Teacher;
import RowMapper.TeacherRowMapper;

@Repository
public class TeacherDaoImp implements TeacherDao {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public void addTeacher(Teacher t) {
		String sql = "INSERT INTO  teacher (name, subject, email, contact, university_id, dept_id) VALUES(?, ?, ?, ?, ?, ?)";
		jdbc.update(sql, t.getName(), t.getSubject(), t.getEmail(), t.getContact(), t.getUniversity_id(), t.getDept_id());
	}

	@Override
	public void updateTeacher(Teacher t) {
		String sql = "UPDATE teacher SET name=?, subject=?, email=?, contact=?, university_id=?, dept_id=? WHERE teacher_id=?";
		jdbc.update(sql, t.getName(), t.getSubject(), t.getEmail(), t.getContact(), t.getUniversity_id(), t.getDept_id(), t.getTeacher_id());
	}

	@Override
	public void deleteTeacher(int id) {
		String sql = "DELETE FROM teacher WHERE teacher_id=?";
		jdbc.update(sql, id);
		
	}

	@Override
	public List<Teacher> getAllTeachers() {
		String sql = "SELECT * FROM teacher";
		return jdbc.query(sql, new TeacherRowMapper());
	}

}
