package ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.ResultDao;
import Model.Result;
import Service.ResultService;

@Service
public class ResultServiceImp implements ResultService {

	
	 @Autowired
	 private ResultDao dao;
	@Override
	public int add(Result r) {
		// TODO Auto-generated method stub
		return dao.add(r);
	}

	@Override
	public int update(Result r) {
		// TODO Auto-generated method stub
		return dao.update(r);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public Result getById(int id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public List<Result> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

}
