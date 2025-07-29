package Dao;

import java.util.List;

import Model.Department;

public interface DepartmentDao {
		int addDepartment(Department d);
		
		int updateDepartment(Department d);
		
		int deleteDepartment(int id);
		
		List<Department> getAllDepartments();
		
		Department getById(int id);
}
