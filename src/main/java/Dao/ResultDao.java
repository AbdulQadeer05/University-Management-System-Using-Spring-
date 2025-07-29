package Dao;

import java.util.List;

import Model.Result;

public interface ResultDao {

	 int add(Result r);
	 int update(Result r);
	 int delete(int id);
	 Result getById(int id);
	 List<Result> getAll();
}
