package DaoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Dao.AttendanceDao;
import Model.Attendance;
import RowMapper.AttendanceRowMapper;

@Repository
public class AttendanceDaoImp  implements AttendanceDao{

	 @Autowired
	    private JdbcTemplate jdbc;
	
	
	@Override
	public int markAttendance(Attendance a) {
		String sql = "INSERT INTO attendance(student_id, course_id, date, status) VALUES (?, ?, ?, ?)";
        return jdbc.update(sql, a.getStudent_id(), a.getCourse_id(), a.getDate(), a.getStatus());
		
	}

	@Override
	public List<Attendance> getAttendanceByStudent(int studentId) {
		 String sql = "SELECT * FROM attendance WHERE student_id=?";
	        return jdbc.query(sql, new AttendanceRowMapper(), studentId);
	}

	@Override
	public List<Attendance> getAll() {
		 String sql = "SELECT * FROM attendance";
	        return jdbc.query(sql, new AttendanceRowMapper());
	}

}
