package ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.DepartmentDao;
import Model.Department;
import Service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
		
	@Autowired
	private DepartmentDao dao;
	
	@Override
	public int add(Department d) {
		// TODO Auto-generated method stub
		return dao.addDepartment(d);
	}

	@Override
	public int update(Department d) {
		// TODO Auto-generated method stub
		return dao.updateDepartment(d);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return dao.deleteDepartment(id);
	}

	@Override
	public List<Department> getAll() {
		// TODO Auto-generated method stub
		return dao.getAllDepartments();
	}

	@Override
	public Department getById(int id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

}
