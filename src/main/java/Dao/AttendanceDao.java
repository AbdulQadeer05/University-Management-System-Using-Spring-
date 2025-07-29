package Dao;

import java.util.List;

import Model.Attendance;

public interface AttendanceDao {
		
	int markAttendance(Attendance a);
    List<Attendance> getAttendanceByStudent(int studentId);
    List<Attendance> getAll();
}
