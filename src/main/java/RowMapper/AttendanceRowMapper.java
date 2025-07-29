package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Model.Attendance;

public class AttendanceRowMapper implements RowMapper<Attendance> {

	@Override
	public Attendance mapRow(ResultSet rs, int rowNum) throws SQLException {
		Attendance a = new Attendance();
		
		a.setId(rs.getInt("id"));
		a.setStudent_id(rs.getInt("student_id"));
	    a.setCourse_id(rs.getInt("course_id"));
	    a.setDate(rs.getDate("date"));
	    a.setStatus(rs.getString("status"));
		return a;
	}

}
