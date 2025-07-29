package Dao;

import java.util.List;

import Model.University;

public interface UniversityDao {

	public int save(University u);
	
	public int update(University u);
	
	public int delete(int id);
	
	public List<University> getAll();
	
	public University getById(int id);
	
}
