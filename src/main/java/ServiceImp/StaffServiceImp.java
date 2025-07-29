package ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.StaffDao;
import Model.Staff;
import Service.StaffService;
@Service
public class StaffServiceImp implements StaffService  {

	@Autowired
    private StaffDao dao;
	
	@Override
	public int add(Staff s) {
		// TODO Auto-generated method stub
		return dao.addStaff(s) ;
	}

	@Override
	public int update(Staff s) {
		// TODO Auto-generated method stub
		return dao.updateStaff(s);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return dao.deleteStaff(id);
	}

	@Override
	public Staff getById(int id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public List<Staff> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

}
