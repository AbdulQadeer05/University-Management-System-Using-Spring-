package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Model.Course;

public class CourseRowMapper implements RowMapper<Course> {

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		Course c = new Course();
		
		c.setCourse_id(rs.getInt("course_id"));
		c.setName(rs.getString("course_name"));
		c.setDescription(rs.getString("description"));
		c.setCredits(rs.getInt("credits"));
		c.setDept_id(rs.getInt("dept_id"));
		return c;
	}

}
