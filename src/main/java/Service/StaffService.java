package Service;

import java.util.List;

import Model.Staff;

public interface StaffService {
	int add(Staff s);
    int update(Staff s);
    int delete(int id);
    Staff getById(int id);
    List<Staff> getAll();
}
