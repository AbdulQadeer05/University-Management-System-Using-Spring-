package DaoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Dao.StaffDao;
import Model.Staff;
import RowMapper.StaffRowMapper;

@Repository
public class StaffDaoImp  implements StaffDao  {

	 @Autowired
	 private JdbcTemplate jdbc;
	
	@Override
	public int addStaff(Staff s) {
		 String sql = "INSERT INTO staff (name, position, contact, university_id, dept_id) VALUES (?, ?, ?, ?, ?)";
	     return jdbc.update(sql, s.getName(), s.getPosition(), s.getContact(), s.getUniversity_id(), s.getDept_id());
	    }
	@Override
	public int updateStaff(Staff s) {
		 String sql = "UPDATE staff SET name=?, position=?, contact=?, university_id=?, dept_id=? WHERE staff_id=?";
	     return jdbc.update(sql, s.getName(), s.getPosition(), s.getContact(), s.getUniversity_id(), s.getDept_id(), s.getStaff_id());
	    }

	@Override
	public int deleteStaff(int id) {
		String sql = "DELETE FROM staff WHERE staff_id=?";
        return jdbc.update(sql, id);
    }

	@Override
	public Staff getById(int id) {
		 String sql = "SELECT * FROM staff WHERE staff_id=?";
	     return jdbc.queryForObject(sql, new StaffRowMapper(), id);
	    }

	@Override
	public List<Staff> getAll() {
		 String sql = "SELECT * FROM staff";
	     return jdbc.query(sql, new StaffRowMapper());
	    }

}
