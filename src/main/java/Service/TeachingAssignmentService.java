package Service;

import java.util.List;

import Model.TeachingAssignment;

public interface TeachingAssignmentService {
	int add(TeachingAssignment ta);
	int update(TeachingAssignment ta);
	int delete(int id);
	List<TeachingAssignment> getAllAssignments();
}
