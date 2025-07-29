package Service;

import java.util.List;

import Model.ExamSchedule;

public interface ExamScheduleService {

	 int add(ExamSchedule e);
	    int update(ExamSchedule e);
	    int delete(int id);
	    List<ExamSchedule> getAll();
	    ExamSchedule getById(int id);
}
