package DaoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Dao.DepartmentDao;
import Model.Department;
import RowMapper.DepartmentMapper;
import RowMapper.UniversityRowMapper;
@Repository
public class DepartmentDaoImp implements DepartmentDao {
	
	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public int addDepartment(Department d) {
	String sql = "INSERT INTO department (dept_name, dept_head, university_id) VALUES (?, ?, ?)";
		return jdbc.update(sql, d.getDept_name(), d.getDept_head(), d.getUniversity_id());
	}

	@Override
	public int updateDepartment(Department d) {
	String sql = "UPDATE department SET dept_name=?, dept_head=?, university_id=? WHERE dept_id=?"; 
		return jdbc.update(sql, d.getDept_name(), d.getDept_head(), d.getUniversity_id(), d.getDept_id());
	}

	@Override
	public int deleteDepartment(int id) {
	String sql = "DELETE FROM department WHERE dept_id=?";
		return jdbc.update(sql,id);
	}

	@Override
	public List<Department> getAllDepartments() {
	String sql = "SELECT * FROM department";
		return jdbc.query(sql, new DepartmentMapper());
	}

	@Override
	public Department getById(int id) {
		String sql = "SELECT * FROM department WHERE dept_id=?";
		return jdbc.queryForObject(sql, new DepartmentMapper(), id);
	}

}
