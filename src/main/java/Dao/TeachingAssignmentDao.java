package Dao;

import java.util.List;

import Model.TeachingAssignment;

public interface TeachingAssignmentDao {
		int add(TeachingAssignment ta);
		int update(TeachingAssignment ta);
		int delete(int id);
		List<TeachingAssignment> getAllAssignments();
}
