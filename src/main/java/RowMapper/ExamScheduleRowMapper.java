package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Model.ExamSchedule;

public class ExamScheduleRowMapper implements RowMapper<ExamSchedule>  {

	@Override
	public ExamSchedule mapRow(ResultSet rs, int rowNum) throws SQLException {
		ExamSchedule e = new ExamSchedule();
		
		 e.setExam_id(rs.getInt("exam_id"));
	     e.setCourse_id(rs.getInt("course_id"));
	     e.setExam_date(rs.getDate("exam_date"));
	     e.setExam_time(rs.getTime("exam_time"));
	     e.setLocation(rs.getString("location"));
	        return e;
	}

}
