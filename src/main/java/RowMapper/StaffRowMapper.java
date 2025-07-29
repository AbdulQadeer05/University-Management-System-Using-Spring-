package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Model.Staff;

public class StaffRowMapper implements RowMapper<Staff> {

	@Override
	public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
		 Staff s = new Staff();
		 
		  s.setStaff_id(rs.getInt("staff_id"));
	        s.setName(rs.getString("name"));
	        s.setPosition(rs.getString("position"));
	        s.setContact(rs.getString("contact"));
	        s.setUniversity_id(rs.getInt("university_id"));
	        s.setDept_id(rs.getInt("dept_id"));
	        return s;
	}

}
