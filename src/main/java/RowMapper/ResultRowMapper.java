package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Model.Result;

public class ResultRowMapper implements RowMapper<Result> {

	@Override
	public Result mapRow(ResultSet rs, int rowNum) throws SQLException {
		  Result r = new Result();
		  
		    r.setResult_id(rs.getInt("result_id"));
	        r.setStudent_id(rs.getInt("student_id"));
	        r.setCourse_id(rs.getInt("course_id"));
	        r.setMarks(rs.getInt("marks"));
		return r;
	}

}
