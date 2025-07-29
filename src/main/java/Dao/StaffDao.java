package Dao;

import java.util.List;

import Model.Staff;

public interface StaffDao {
	
	  int addStaff(Staff s);
	    int updateStaff(Staff s);
	    int deleteStaff(int id);
	    Staff getById(int id);
	    List<Staff> getAll();
}
