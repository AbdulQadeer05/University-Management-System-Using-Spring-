package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Model.University;

public class UniversityRowMapper implements RowMapper<University>{

	@Override
	public University mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		University u = new University();
		u.setId(rs.getInt("id"));
		u.setName(rs.getString("name"));
		u.setAddress(rs.getString("address"));
		u.setEmail(rs.getString("email"));
		u.setContact(rs.getString("contact"));
		
		
		return u;
		
	}

}
