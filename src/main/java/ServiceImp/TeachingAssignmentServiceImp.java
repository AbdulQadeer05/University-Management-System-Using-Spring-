package ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.TeachingAssignmentDao;
import Model.TeachingAssignment;
import Service.TeachingAssignmentService;
@Service
public class TeachingAssignmentServiceImp implements  TeachingAssignmentService {

	 @Autowired
	    private TeachingAssignmentDao dao;
	
	
	@Override
	public int add(TeachingAssignment ta) {
		// TODO Auto-generated method stub
		return dao.add(ta);
	}

	@Override
	public int update(TeachingAssignment ta) {
		// TODO Auto-generated method stub
		return dao.update(ta);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public List<TeachingAssignment> getAllAssignments() {
		// TODO Auto-generated method stub
		return dao.getAllAssignments();
	}

}
