package ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.UniversityDao;
import Model.University;
import Service.UniversityService;
@Service
public class UniversityServiceImpl implements UniversityService {

	@Autowired
	private UniversityDao dao;
	
	@Override
	public int save(University u) {
		// TODO Auto-generated method stub
		return dao.save(u);
	}

	@Override
	public int update(University u) {
		// TODO Auto-generated method stub
		return dao.update(u);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public List<University> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public University getById(int id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

}
