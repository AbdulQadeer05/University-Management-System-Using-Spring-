package DaoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Dao.StudentDao;
import Model.Student;
import RowMapper.StudentRowMapper;

@Repository
public class StudentDaoImp implements StudentDao {
	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public void addStudent(Student t) {
		String sql = "INSERT INTO student (rollno, name, gender, dob, email, contact, university_id, dept_id)VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		jdbc.update(sql, t.getRollno(), t.getName(), t.getGender(), t.getDob(), t.getEmail(), t.getContact(),t.getUniversity_id(), t.getDept_id());
		
	}

	@Override
	public void updateStudent(Student t) {
		String sql = "UPDATE student SET name=?, gender=?, dob=?, email=?, contact=?, university_id=?, dept_id=? WHERE rollno=?"; 
		jdbc.update(sql, t.getName(), t.getGender(), t.getDob(), t.getEmail(), t.getContact(), t.getUniversity_id(), t.getDept_id(), t.getRollno());
	}

	@Override
	public void deleteStudent(int rollno) {
		String sql = "DELETE FROM student WHERE rollno=?";
		jdbc.update(sql,rollno);
	}

	@Override
	public List<Student> getAllStudent() {
		String sql="SELECT * FROM student";
		return jdbc.query(sql, new StudentRowMapper());
	}

}
