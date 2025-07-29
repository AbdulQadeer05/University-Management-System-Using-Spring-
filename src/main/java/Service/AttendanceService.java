package Service;

import java.util.List;

import Model.Attendance;

public interface AttendanceService {
		
	 int mark(Attendance a);
	    List<Attendance> getByStudent(int studentId);
	    List<Attendance> getAll();
}
