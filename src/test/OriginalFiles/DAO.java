package OriginalFiles;

import java.util.List;

public interface DAO<T> {

	List<T> getAll();
	
	T getOne(int id);
	
	void add(T t) throws Exception;
	
	void update(T t) throws Exception;
	
	void delete(T t) throws Exception;
	
	void deleteById(int id) throws Exception;
}
