package io.bankname.credit.objects.services;

import java.util.List;
import java.util.stream.Stream;


public interface BaseService<T> {
	
	void saveEntity(T t);
	
	void deleteEntity(T t);
	
	T showEntity(long id);

	List<T> showAllEntity();

	Stream<T> presentEntityByName(String name);
}
