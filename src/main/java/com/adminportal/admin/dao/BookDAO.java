package com.adminportal.admin.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.adminportal.admin.domain.Book;

public interface BookDAO extends CrudRepository<Book, Long> {

	List<Book> findAll();
	
}
