package Model;

import java.sql.Date;
import java.sql.Time;

public class ExamSchedule {
	
	 private int exam_id;
	    private int course_id;
	    private Date exam_date;
	    private Time exam_time;
	    private String location;
		public int getExam_id() {
			return exam_id;
		}
		public void setExam_id(int exam_id) {
			this.exam_id = exam_id;
		}
		public int getCourse_id() {
			return course_id;
		}
		public void setCourse_id(int course_id) {
			this.course_id = course_id;
		}
		public Date getExam_date() {
			return exam_date;
		}
		public void setExam_date(Date exam_date) {
			this.exam_date = exam_date;
		}
		public Time getExam_time() {
			return exam_time;
		}
		public void setExam_time(Time exam_time) {
			this.exam_time = exam_time;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
}
