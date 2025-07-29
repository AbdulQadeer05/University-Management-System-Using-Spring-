package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Model.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student st = new Student();
		st.setRollno(rs.getInt("rollno"));
		st.setName(rs.getString("name"));
		st.setGender(rs.getString("gender"));
		st.setDob(rs.getDate("dob"));
		st.setEmail(rs.getString("email"));
		st.setContact(rs.getString("contact"));
		st.setUniversity_id(rs.getInt("university_id"));
		st.setDept_id(rs.getInt("dept_id"));
		
		
		return st;
	}

}
