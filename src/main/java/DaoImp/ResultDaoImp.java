package DaoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Dao.ResultDao;
import Model.Result;
import RowMapper.ResultRowMapper;

@Repository
public class ResultDaoImp implements ResultDao {

	  @Autowired
	  private JdbcTemplate jdbc;
	
	
	@Override
	public int add(Result r) {
		
		 String sql = "INSERT INTO result (student_id, course_id, marks) VALUES (?, ?, ?)";
	      return jdbc.update(sql, r.getStudent_id(), r.getCourse_id(), r.getMarks());
	}

	@Override
	public int update(Result r) {
		 String sql = "UPDATE result SET student_id=?, course_id=?, marks=? WHERE result_id=?";
	     return jdbc.update(sql, r.getStudent_id(), r.getCourse_id(), r.getMarks(), r.getResult_id());
	}

	@Override
	public int delete(int id) {
		String sql="DELETE FROM result WHERE result_id=?";
		return jdbc.update(sql,id);
	}

	@Override
	public Result getById(int id) {
		 String sql = "SELECT * FROM result WHERE result_id=?";
	        return jdbc.queryForObject(sql, new ResultRowMapper(), id);
	}

	@Override
	public List<Result> getAll() {
		String sql = "SELECT * FROM result";
        return jdbc.query(sql, new ResultRowMapper());
	}

}
