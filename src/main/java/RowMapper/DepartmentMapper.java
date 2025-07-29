package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Model.Department;

public class DepartmentMapper implements RowMapper<Department> {

	@Override
	public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
		Department d = new Department();
		
		d.setDept_id(rs.getInt("dept_id"));
		d.setDept_name(rs.getString("dept_name"));
		d.setDept_head(rs.getString("dept_head"));
		d.setUniversity_id(rs.getInt("university_id"));
		
		return d;
	}

}
