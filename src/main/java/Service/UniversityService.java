package Service;

import java.util.List;

import Model.University;

public interface UniversityService {
		
	public int save(University u);
	public int update(University u);
	int delete(int id);
	public List<University> getAll();
	University getById(int id);
}
