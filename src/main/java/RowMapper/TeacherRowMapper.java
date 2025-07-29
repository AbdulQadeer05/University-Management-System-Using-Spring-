package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Model.Teacher;

public class TeacherRowMapper implements RowMapper<Teacher> {

	@Override
	public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
		Teacher t = new Teacher();
		
		t.setTeacher_id(rs.getInt("teacher_id"));
		t.setName(rs.getString("name"));
		t.setSubject(rs.getString("subject"));
		t.setEmail(rs.getString("email"));
		t.setContact(rs.getString("contact"));
		t.setUniversity_id(rs.getInt("university_id"));
		t.setDept_id(rs.getInt("dept_id"));
		return t;
	}

}
