package Dao;

import java.util.List;

import Model.ExamSchedule;

public interface ExamScheduleDao {

	  int addExam(ExamSchedule e);
	    int updateExam(ExamSchedule e);
	    int deleteExam(int id);
	    List<ExamSchedule> getAllExams();
	    ExamSchedule getExamById(int id);
}
