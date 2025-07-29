package DaoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Dao.UniversityDao;
import Model.University;
import RowMapper.UniversityRowMapper;

@Repository
public class UniversityDaoImp implements UniversityDao {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	
	
	@Override
	public int save(University u) {
	String sql = "INSERT INTO university (name, address, email, contact) VALUES(?, ?, ?, ?)";
		return jdbc.update(sql,u.getName(), u.getAddress(), u.getEmail(), u.getContact() ); 
	}

	@Override
	public int update(University u) {
		String sql = "UPDATE university SET name = ?, address = ?, email = ?, contact = ? WHERE id = ?";
		return jdbc.update(sql, u.getName(), u.getAddress(), u.getEmail(), u.getContact(), u.getId());
	}

	@Override
	public int delete(int id) {
		String sql = "DELETE FROM university WHERE id = ?";
		return jdbc.update(sql,id);
	}

	@Override
	public List<University> getAll() {
		String sql = "SELECT * FROM university";
		return jdbc.query(sql, new UniversityRowMapper());
	}

	@Override
	public University getById(int id) {
		String sql = "SELECT * FROM university WHERE id = ?";
		return jdbc.queryForObject(sql, new UniversityRowMapper(), id);
        
	}



}
