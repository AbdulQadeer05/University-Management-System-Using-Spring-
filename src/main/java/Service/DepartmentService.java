package Service;

import java.util.List;

import Model.Department;

public interface DepartmentService {

	int add(Department d);
	int update(Department d);
	int delete(int id);
	List<Department> getAll();
	Department getById(int id);

}
