package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Model.TeachingAssignment;

public class TeachingAssignmentMapper implements RowMapper<TeachingAssignment> {

	@Override
	public TeachingAssignment mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		 TeachingAssignment ta = new TeachingAssignment();
		 	ta.setId(rs.getInt("id"));
	        ta.setTeacher_id(rs.getInt("teacher_id"));
	        ta.setCourse_id(rs.getInt("course_id"));
		return ta;
	}

}
