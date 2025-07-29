package ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.ExamScheduleDao;
import Model.ExamSchedule;
import Service.ExamScheduleService;

@Service
public class ExamScheduleServiceImp implements ExamScheduleService {

	@Autowired
    private ExamScheduleDao dao;
	
	@Override
	public int add(ExamSchedule e) {
		// TODO Auto-generated method stub
		return dao.addExam(e);
	}

	@Override
	public int update(ExamSchedule e) {
		// TODO Auto-generated method stub
		return dao.updateExam(e);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return dao.deleteExam(id);
	}

	@Override
	public List<ExamSchedule> getAll() {
		// TODO Auto-generated method stub
		return dao.getAllExams();
	}

	@Override
	public ExamSchedule getById(int id) {
		// TODO Auto-generated method stub
		return dao.getExamById(id);
	}

}
