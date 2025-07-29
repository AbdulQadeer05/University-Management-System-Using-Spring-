package DaoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Dao.ExamScheduleDao;
import Model.ExamSchedule;
import RowMapper.ExamScheduleRowMapper;
@Repository
public class ExamScheduleDaoImp  implements ExamScheduleDao{

	 @Autowired
	 private JdbcTemplate jdbc;
	
	
	@Override
	public int addExam(ExamSchedule e) {
		 String sql = "INSERT INTO exam_schedule (course_id, exam_date, exam_time, location) VALUES (?, ?, ?, ?)";
	     return jdbc.update(sql, e.getCourse_id(), e.getExam_date(), e.getExam_time(), e.getLocation());
	}

	@Override
	public int updateExam(ExamSchedule e) {
		String sql = "UPDATE exam_schedule SET course_id=?, exam_date=?, exam_time=?, location=? WHERE exam_id=?";
        return jdbc.update(sql, e.getCourse_id(), e.getExam_date(), e.getExam_time(), e.getLocation(), e.getExam_id());
	}

	@Override
	public int deleteExam(int id) {
		   String sql = "DELETE FROM exam_schedule WHERE exam_id=?";
	       return jdbc.update(sql, id);
	}

	@Override
	public List<ExamSchedule> getAllExams() {
		  String sql = "SELECT * FROM exam_schedule";
	      return jdbc.query(sql, new ExamScheduleRowMapper());
	}

	@Override
	public ExamSchedule getExamById(int id) {
		 String sql = "SELECT * FROM exam_schedule WHERE exam_id=?";
	     return jdbc.queryForObject(sql, new ExamScheduleRowMapper(), id);
	}

}
