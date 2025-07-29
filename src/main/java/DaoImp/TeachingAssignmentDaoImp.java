package DaoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Dao.TeachingAssignmentDao;
import Model.TeachingAssignment;
import RowMapper.TeachingAssignmentMapper;
@Repository
public class TeachingAssignmentDaoImp implements TeachingAssignmentDao  {
	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public int add(TeachingAssignment ta) {
	String sql="INSERT INTO teaching_assignment ( teacher_id, course_id) VALUES (?, ?)";	
	
	return jdbc.update(sql, ta.getTeacher_id(), ta.getCourse_id());
	}

	@Override
	public int update(TeachingAssignment ta) {
		String sql = "UPDATE teaching_assignment SET teacher_id=?, course_id=? WHERE id=?";
		return jdbc.update(sql, ta.getTeacher_id(), ta.getCourse_id(), ta.getId());
	}

	@Override
	public int delete(int id) {
		String sql="DELETE FROM teaching_assignment WHERE id=?";
		return jdbc.update(sql,id);
	}

	@Override
	public List<TeachingAssignment> getAllAssignments() {
		String sql = "SELECT * FROM teaching_assignment";
        return jdbc.query(sql, new TeachingAssignmentMapper());
	}

}
