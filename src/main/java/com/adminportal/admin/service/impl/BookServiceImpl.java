package com.adminportal.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminportal.admin.dao.BookDAO;
import com.adminportal.admin.domain.Book;
import com.adminportal.admin.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO bookDAO;

	@Override
	public Book save(Book book) {
		return bookDAO.save(book);
	}

	@Override
	public List<Book> findAll() {
		return bookDAO.findAll();
	}

	@Override
	public Book findById(Long id) {
		return bookDAO.findById(id).get();
	}

	@Override
	public void removeOne(Long id) {
		bookDAO.deleteById(id);
	}

}
