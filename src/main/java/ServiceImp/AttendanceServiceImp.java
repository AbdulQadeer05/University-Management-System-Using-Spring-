package ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.AttendanceDao;
import Model.Attendance;
import Service.AttendanceService;

@Service
public class AttendanceServiceImp implements AttendanceService {

	  @Autowired
	    private AttendanceDao dao;
	
	
	@Override
	public int mark(Attendance a) {
		return dao.markAttendance(a);
	}

	@Override
	public List<Attendance> getByStudent(int studentId) {
		return dao.getAttendanceByStudent(studentId);
	}

	@Override
	public List<Attendance> getAll() {
		 return dao.getAll();
	}

}
