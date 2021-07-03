package io.bankname.credit.objects.services;

import java.util.List;


public interface BaseService<T> {
	
	void saveEntity(T t);
	
	void deleteEntity(T t);
	
	T showEntity(long id);

	List<T> showAllEntity();

	T presentEntityByName(String name);
}
