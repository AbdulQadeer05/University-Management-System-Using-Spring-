package View;

import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Controller.SpringConfig;
import Model.Attendance;
import Model.Course;
import Model.Department;
import Model.ExamSchedule;
import Model.Result;
import Model.Staff;
import Model.Student;
import Model.Teacher;
import Model.TeachingAssignment;
import Model.University;
import Service.AttendanceService;
import Service.CourseService;
import Service.DepartmentService;
import Service.ExamScheduleService;
import Service.ResultService;
import Service.StaffService;
import Service.StudentService;
import Service.TeacherService;
import Service.TeachingAssignmentService;
import Service.UniversityService;

public class Main {

	public static void main(String arg[]) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		UniversityService service = context.getBean(UniversityService.class);
		DepartmentService deptService = context.getBean(DepartmentService.class);
		TeacherService teacherService = context.getBean(TeacherService.class);
		StudentService studentService = context.getBean(StudentService.class);
		CourseService courseService = context.getBean(CourseService.class);
		TeachingAssignmentService tas = context.getBean(TeachingAssignmentService.class);
		AttendanceService as = context.getBean(AttendanceService.class);
		ResultService rs=context.getBean(ResultService.class);
		ExamScheduleService es = context.getBean(ExamScheduleService.class); 
		StaffService ss = context.getBean(StaffService.class);
		
		Scanner ob=new Scanner(System.in);
			while(true) {
				System.out.println(" Main Manu \n1. University \n2. Department \n3. Teacher \n4. Student \n5. Cource \n6. Teaching Assignment \n7. Attendance \n8. Result \n9. Exam Schedule \n10. Staff\nEnter Selection");
				int mainmanu = ob.nextInt();
				if(mainmanu==1 ) {
					//University Start

					System.out.println("1. Add University \n2. Update University \n3. Delete University \n4.View All University's \n Enter Selection :");
					int uni = ob.nextInt();
					University u1 = new University();
					
					if(uni==1) {
						System.out.println("Enter University name :");
						u1.setName(ob.next());
						System.out.println("Enter the University Address :");
						u1.setAddress(ob.next());
						System.out.println("Enter the University Email :");
						u1.setEmail(ob.next());
						System.out.println("Enter the University Contact No :");
						u1.setContact(ob.next());
						
						service.save(u1);
						System.out.println("University Added Successfully");
					}
					
					if(uni==2) {
						System.out.println("Enter the University ID which you want to Update :");
						u1.setId(ob.nextInt());
						System.out.println("Enter the New Name :");
						u1.setName(ob.next());
						System.out.println("Enter the New Address :");
						u1.setAddress(ob.next());
						System.out.println("Enter the New Email :");
						u1.setEmail(ob.next());
						System.out.println("Enter the New Contact No :");
						u1.setContact(ob.next());
						
						service.update(u1);
						System.out.println("University Update Successfully ");
					}
					if(uni==3) {
						System.out.println("Enter the University ID which you want to Delete :");
						service.delete(ob.nextInt());
						System.out.println("University Delete Successfully ");
					}
					if(uni==4) {
						List<University> list = service.getAll();
						for(University u : list) {
							System.out.println(u.getId()+"-"+u.getName()+"-"+u.getAddress()+"-"+u.getEmail()+"-"+u.getContact());
						}
						
					}
					
				
				}
				//University End
				//Department Start
				if(mainmanu==2) {
				
					System.out.println("1. Add Department \n2. Update Department \n3. Delete Department \n4. View All Department \n Enter Selection :");
					int dept = ob.nextInt();
					Department d = new Department();
					
					if(dept==1) {
						System.out.println("Enter University ID :");
						int uniId=ob.nextInt();
						System.out.println("Enter Department Name :");
						d.setDept_name(ob.next());
						System.out.println("Enter HOD Name :");
						d.setDept_head(ob.next());
						
						University uni = context.getBean(UniversityService.class).getById(uniId);
						if(uni!=null) {
						
						d.setUniversity_id(uniId);
							int result = context.getBean(DepartmentService.class).add(d);
							System.out.println("Department Added Successfully");
						}else {
							System.out.println("University ID not found !");	
						}
						
					}if(dept==2) {
						System.out.println("Enter the Department ID which you want to Update :");
						d.setDept_id(ob.nextInt());
						System.out.println("Enter the New Name (Department) :");
						d.setDept_name(ob.next());
						System.out.println("Enter the New HOD :");
						d.setDept_head(ob.next());
						System.out.println("Enter the New University ID :");
						d.setUniversity_id(ob.nextInt());
						
						int updated = context.getBean(DepartmentService.class).update(d);
						if(updated>0) {
							System.out.println("Record Update Successfully");
						}else {
							System.out.println("Error");
						}
						
					}if(dept==3) {
						System.out.println("Enter the Department ID which you want to Delete :");
						int del = ob.nextInt();
						int deleted = context.getBean(DepartmentService.class).delete(del);
						
						if(deleted>0) {
							System.out.println("Record Delete Successfully ");
						}else {
							System.out.println("Error");
						}
					}if(dept==4) {
						List<Department> alldep = context.getBean(DepartmentService.class).getAll();
						for(Department dep : alldep) {
							System.out.println(dep.getDept_id()+"-"+dep.getDept_name()+"-"+dep.getDept_head());
						}
					}
					
				}
				//Department End
				//Teacher Start
				if(mainmanu==3) {
					Teacher t = new Teacher();
					System.out.println("1. Add Teacher \n2. Update Teacher \n3. Delete Teacher \n4. View All Teacher \nEnter Selection");
					int teacher=ob.nextInt();
					
					if(teacher==1) {
						System.out.println("Enter the University ID :");
						int uniId=ob.nextInt();
						 University uni = service.getById(uniId);
						 
						 if(uni==null) {
							 System.out.println("University not Available");
						 }
						 
						 System.out.println("Enter the Department ID");
						 int dep = ob.nextInt();
						 
						 Department d = deptService.getById(uniId);
						 
						 if(d==null) {
							 System.out.println("Department Not Available");
						 }
						 
						 t.setUniversity_id(uniId);
						 t.setDept_id(dep);
						 
						 System.out.println("Enter the Teacher Name :");
						 t.setName(ob.next());
						 System.out.println("Enter the Subject Name :");
						 t.setSubject(ob.next());
						 System.out.println("Enter the Email :");
						 t.setEmail(ob.next());
						 System.out.println("Enter the Contact No :");
						 t.setContact(ob.next());
						 
						 teacherService.add(t);
						 System.out.println("Teacher Record Added Successfully");
						 
					}
					if(teacher==2) {
						System.out.println("Entet the Teacher Id which you want to update Record");
						t.setTeacher_id(ob.nextInt());
						System.out.println("Enter the University ID");
						t.setUniversity_id(ob.nextInt());
						System.out.println("Enter the Department ID");
						t.setDept_id(ob.nextInt());
						System.out.println("Enter the New Name :");
						t.setName(ob.next());
						System.out.println("Enter the Subject :");
						t.setSubject(ob.next());
						System.out.println("Enter the Email :");
						t.setEmail(ob.next());
						System.out.println("Entet the Contact No :");
						t.setContact(ob.next());
						
						teacherService.update(t);
						System.out.println("Record Update Successfull");
					}
					if(teacher==3) {
						System.out.println("Enter the Teacher Id which you want to Delete :");
						teacherService.delete(ob.nextInt());
						System.out.println("Record Delete Successfully");
					}
					if(teacher==4) {
						List<Teacher> list = teacherService.getAll();
						for(Teacher te : list) {
							System.out.println(te.getTeacher_id()+"-"+te.getUniversity_id()+"-"+te.getDept_id()+"-"+te.getName()+"-"+te.getSubject()+"-"+te.getEmail()+"-"+te.getContact());
						}
					}
				}
				//Teacher End
				//Student start
				
				if(mainmanu==4) {
					Student s = new Student();
					System.out.println("1. Add Student \n2. Update Student \n3. Delete Student \n4. View All Student \nEnter Selection :");
					int std = ob.nextInt();
					if(std==1) {
						System.out.println("Enter the Student ROll no :");
						s.setRollno(ob.nextInt());
						System.out.println("Enter the Student Name :");
						s.setName(ob.next());
						System.out.println("Enter the Student Gender :");
						s.setGender(ob.next());
						System.out.println("Enter the DOB :");
						s.setDob(Date.valueOf(ob.next()));
						System.out.println("Enter the Email :");
						s.setEmail(ob.next());
						System.out.println("Enter the Contact Number :");
						s.setContact(ob.next());
						System.out.println("Enter the University ID");
						int uniId=ob.nextInt();
						 University uni = service.getById(uniId);
						 if(uni==null) {
							 System.out.println("University not Available");
						 }
						 
						 System.out.println("Enter the Department ID");
						 int d = ob.nextInt();
						 Department dep = deptService.getById(d);
						 if(dep==null) {
							 System.out.println("Department Not Available");
						 }
						 
						 s.setUniversity_id(uniId);
						 s.setDept_id(d);
						 
						 studentService.add(s);
						 
						 System.out.println("Student Added Successfully");
						 
					}
					
					if(std==2) {
						System.out.println("Enter the Student Roll No which you want to Update ;");
						s.setRollno(ob.nextInt());
						System.out.println("Enter the Student New Name :");
						s.setName(ob.next());
						System.out.println("Enter the Gender");
						s.setGender(ob.next());
						System.out.println("Enter the DOB");
						s.setDob(Date.valueOf(ob.next()));
						System.out.println("Enter the Email :");
						s.setEmail(ob.next());
						System.out.println("Enter the Contact number :");
						s.setContact(ob.next());
						System.out.println("Enter the University Id :");
						s.setUniversity_id(ob.nextInt());
						System.out.println("Enter the Department Id :");
						s.setDept_id(ob.nextInt());
						
						studentService.update(s);
						System.out.println("Record Update Successfully ");
					}
					
					if(std==3) {
						System.out.println("Enter the Roll no Which you Want to Delete :");
						studentService.delete(ob.nextInt());
						System.out.println("Record Delete Successfully");
					}
					if(std==4) {
						List<Student> list = studentService.getAll();
						
						for(Student st : list) {
							System.out.println(st.getRollno()+"-"+st.getName()+"-"+st.getGender()+"-"+st.getDob()+"-"+st.getEmail()+"-"+st.getContact()+"-"+st.getUniversity_id()+"-"+st.getDept_id());
						}
						
					}
				} 
				//Student End
				//Start Course
				
				if(mainmanu==5) {
					Course c = new Course();
					
					System.out.println("1. Add Course \n2. Update Course \n3. Delete Course \n4. View All Courses \nEnter Selection :");
					int co=ob.nextInt();
					
					if(co==1) {
						System.out.println("Enter the Course Name :");
						c.setName(ob.next());
						System.out.println("Enter Description :");
						c.setDescription(ob.next());
						System.out.println("Enter Credits :");
						c.setCredits(ob.nextInt());
						System.out.println("Enter the Department ID :");
						int depId=ob.nextInt();
						
						Department d = deptService.getById(depId);
						if(d==null) {
							System.out.println("Department Not Found !");
						}
						c.setDept_id(depId);
						
						courseService.add(c);
						
						System.out.println("Record Added Successfully");
					}
					
					if(co==2) {
						System.out.println("Enter the Course ID which you want to Update :");
						c.setCourse_id(ob.nextInt());
						System.out.println("Enter the New Course Name :");
						c.setName(ob.next());
						System.out.println("Enter Description :");
						c.setDescription(ob.next());
						System.out.println("Enter the Credits :");
						c.setCredits(ob.nextInt());
						System.out.println("Enter the Department ID :");
						c.setDept_id(ob.nextInt());
						
						courseService.update(c);
						System.out.println("Record Update Successfully :");
					}
					if(co==3) {
						System.out.println("Enter the Course ID which you want to Delete :");
						int a = ob.nextInt();
						courseService.delete(a);
						
						System.out.println("Course Delete Successfully");
					}
					
					if(co==4) {
						List<Course> list =courseService.getAll();
						for(Course course : list) {
							System.out.println(course.getCourse_id()+"-"+course.getName()+"-"+course.getDescription()+"-"+course.getCredits()+"-"+course.getDept_id());
						}
					}
				}
				
				//End Course
				//Start Teaching Assignment
				
				if(mainmanu==6) {
					 TeachingAssignment ta = new TeachingAssignment();
					System.out.println("1. Assign Course to Teacher \n2. Update \n3. Delete \n4. Show All \nEnter the Selection :");
					int ass=ob.nextInt();
					
					if(ass==1) {
						 System.out.println("Enter the Course ID :");
						 ta.setCourse_id(ob.nextInt());
						 System.out.println("Enter the Teacher ID :");
						 ta.setTeacher_id(ob.nextInt());
						 
						 tas.add(ta);
						 System.out.println("Teaching Assignment Added Successfully :");
							
					}
					if(ass==2) {
						System.out.println("Enter the ID which you want to Update :");
						ta.setId(ob.nextInt());
						System.out.println("Enter the New Teacher ID :");
						ta.setTeacher_id(ob.nextInt());
						System.out.println("Enter the Course ID :");
						ta.setCourse_id(ob.nextInt());
						
						tas.update(ta);
						System.out.println("Record Update Successfully :");
					}
					if(ass==3) {
						System.out.println("Enter the ID which you want to Delete :");
						int d = ob.nextInt();
						tas.delete(d);
						
						System.out.println("Record Delete Successfully :");
					}
					if(ass==4) {
						List<TeachingAssignment> list = tas.getAllAssignments();
						for(TeachingAssignment ta1: list) {
							System.out.println(ta1.getId()+"-"+ta1.getTeacher_id()+"-"+ta1.getCourse_id());
						}
					}
				
				}
				
				//End Teaching Assignment
				//Start Attendance
				
				if(mainmanu==7) {
					Attendance a = new Attendance();
					
					System.out.println("1. Add Attendance \n2. View All Attendance \nEnter Selection :");
					int sel=ob.nextInt();
					
					if(sel==1) {
						System.out.println("Enter Date :");
						a.setDate(Date.valueOf(ob.next()));
						System.out.println("Enter Student ID");
						a.setStudent_id(ob.nextInt());
						System.out.println("Enter the Course ID");
						a.setCourse_id(ob.nextInt());
						System.out.println("Enter Status (Present/Absent):");
						a.setStatus(ob.next());
						
						as.mark(a);
						System.out.println("Attendance Marked Successfully");
					
					}
					
					if(sel==2) {
						List<Attendance> list = as.getAll();
						for(Attendance aa:list) {
							System.out.println(aa.getDate()+"-"+aa.getStatus()+"-"+aa.getCourse_id()+"-"+aa.getStudent_id());
						}
					}
				}
				//End Attendance
				//Start Result
				
				if(mainmanu==8) {
					Result r = new Result();
					
					System.out.println("1. Set Result \n2. Update Result \n3. Delete Result \n4. Get Result by ID \n5. Get All Result \nEnter Selection ;");
				int result=ob.nextInt();
				
				if(result==1) {
					System.out.println("Enter the Student Id :");
					r.setStudent_id(ob.nextInt());
					System.out.println("Enter the Course Id :");
					r.setCourse_id(ob.nextInt());
					System.out.println("Enter Marks");
					r.setMarks(ob.nextInt());
					
					rs.add(r);
					
					System.out.println("Result Set Successfully :");
					
				}
				if(result==2) {
					System.out.println("Enter Result ID which you want to Update :");
					r.setResult_id(ob.nextInt());
					System.out.println("Enter the Student ID");
					r.setStudent_id(ob.nextInt());
					System.out.println("Enter the Course ID");
					r.setCourse_id(ob.nextInt());
					System.out.println("Enter Marks :");
					r.setMarks(ob.nextInt());
					
					rs.update(r);
					
					System.out.println("Result Update Sucessfully");
					
				}
				if(result==3) {
					System.out.println("Enter Result ID");
					int dele=ob.nextInt();
					rs.delete(dele);
					System.out.println("Result Delete Successfully ");
				}
				
				if(result==4) {
					System.out.println("Enter Result ID");
					Result re = rs.getById(ob.nextInt());
					
					System.out.println("Student ID :"+re.getStudent_id());
					System.out.println("Course ID :"+re.getCourse_id());
					System.out.println("Marks :"+re.getMarks());
				}
				
				if(result==5) {
					List<Result> list = rs.getAll();
					for(Result res : list) {
						System.out.println(res.getStudent_id()+"-"+res.getCourse_id()+"-"+res.getMarks());
					}
				}
				
				}
				//End Result
				//Start Exam-Schedule
				
				if(mainmanu==9) {
					ExamSchedule ex = new ExamSchedule();
					System.out.println("1. Set Exam Schedule \n2. Update Exam Schedule \n3. Delete Schedule \n4.View By ID\n5. View All Exam Schedule \nEnter Selection");
					int sel=ob.nextInt();
					
					if(sel==1) {
						System.out.println("Enter Course ID");
						ex.setCourse_id(ob.nextInt());
						System.out.println("Enter the Date :");
						ex.setExam_date(Date.valueOf(ob.next()));
						System.out.println("Enter the Time :");
						ex.setExam_time(Time.valueOf(ob.next()));
						System.out.println("Location :");
						ex.setLocation(ob.next());
						
						es.add(ex);
						System.out.println("Exam Set Successfully");
					}
					
					if(sel==2) {
						System.out.println("Enter the Exam ID which you want to Update :");
						ex.setExam_id(ob.nextInt());
						System.out.println("Enter the Course ID");
						ex.setCourse_id(ob.nextInt());
						System.out.println(": Enter Date :");
						ex.setExam_date(Date.valueOf(ob.next()));
						System.out.println(": Enter Time :");
						ex.setExam_time(Time.valueOf(ob.next()));
						System.out.println("Location");
						ex.setLocation(ob.next());
						
						es.update(ex);
						System.out.println("Exam Update Successfully");
					}
					
					if(sel==3) {
						System.out.println("Enter Exam Schedule ID :");
						int del=ob.nextInt();
						es.delete(del);
						System.out.println("Exam Schedule Delete Successfully");
					}
					
					if(sel==4) {
						System.out.println("Enter Exam Schedule ID :");
						int id=ob.nextInt();
						 ExamSchedule e = es.getById(id);
			                if (e != null) {
			                    System.out.println("ID: " + e.getExam_id() + ", Course: " + e.getCourse_id() +", Date: " + e.getExam_date() + ", Time: " + e.getExam_time() + ", Location: " + e.getLocation());
			                } else {
			                    System.out.println("Not found.");
			                }
					}
					
					if(sel==5) {
						 List<ExamSchedule> list = es.getAll();
			                for (ExamSchedule e : list) {
			                    System.out.println("ID: " + e.getExam_id() + ", Course: " + e.getCourse_id() +
			                            ", Date: " + e.getExam_date() + ", Time: " + e.getExam_time() + ", Location: " + e.getLocation());
			                }
					}
					
				}
				
				//End Exam-schedule
				//Start Staff
				
				if(mainmanu==10) {
					Staff s = new Staff();
					System.out.println("1. Add Staff \n2. Update Staff \n3. Delete Staff \n4. View by ID \n5. View all Staff \nEnter Selection :");
					int sel = ob.nextInt();
					
					if(sel==1) {
						System.out.println("Enter the University ID :");
						s.setUniversity_id(ob.nextInt());
						System.out.println("Enter the Department ID :");
						s.setDept_id(ob.nextInt());
						System.out.println("Enter Name :");
						s.setName(ob.next());
						System.out.println("Enter Position :");
						s.setPosition(ob.next());
						System.out.println("Enter Contact :");
						s.setContact(ob.next());
						
						ss.add(s);
						System.out.println("Staff Added Successfully");
					
					}
					if(sel==2) {
						System.out.println("Enter Staff ID which you want to Udpate :");
						s.setStaff_id(ob.nextInt());
						System.out.println("Enter the University ID :");
						s.setUniversity_id(ob.nextInt());
						System.out.println("Enter Department ID :");
						s.setDept_id(ob.nextInt());
						System.out.println("Enter Name :");
						s.setName(ob.next());
						System.out.println("Enter Position :");
						s.setPosition(ob.next());
						System.out.println("Enter Contact :");
						s.setContact(ob.next());
						
						ss.update(s);
						System.out.println("Staff Update Successfuly");
					}
					
					if(sel==3) {
						System.out.println("Enter Staff ID ");
						int id=ob.nextInt();
					ss.delete(id);
					System.out.println("Staff Delete Successfully");
					}
					
					if(sel==4) {
						System.out.println("Enter Staff Id :");
						int id=ob.nextInt();
						Staff staff = ss.getById(id);
						
						if(staff!=null) {
						System.out.println("ID :"+staff.getStaff_id());
						System.out.println("Name :"+staff.getName());
						System.out.println("Contact :"+staff.getContact());
						System.out.println("University ID :"+staff.getUniversity_id());
						System.out.println("Department Id :"+staff.getDept_id());
						
						}else {
							System.out.println("Staff not Found ");
						}
					}
					
					if(sel==5) {
						 List<Staff> list = ss.getAll();
						 for (Staff st : list) {
		                        System.out.println(st.getStaff_id()+"-"+st.getUniversity_id()+"-"+st.getDept_id()+"-"+st.getName()+"-"+st.getPosition()+"-"+st.getContact());
		                    }
					}
					
				
				}//End Staff
				
				
			}
		
		}
		
		
	
}
