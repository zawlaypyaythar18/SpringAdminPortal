package com.adminportal.admin.service;

import java.util.List;

import com.adminportal.admin.domain.Book;

public interface BookService {

	Book save(Book book);
	
	List<Book> findAll();
	
	Book findById(Long id);
	
	void removeOne(Long id);
	
}
