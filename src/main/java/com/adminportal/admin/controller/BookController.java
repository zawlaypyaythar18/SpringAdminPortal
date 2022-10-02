package com.adminportal.admin.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.adminportal.admin.domain.Book;
import com.adminportal.admin.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/add")
	public String addBook(Model model) {
		Book book = new Book();
		model.addAttribute("book",book);
		return "AddBook";
	}
	
	@PostMapping("/add")
	public String addBookPost(@ModelAttribute("book") Book book) throws IOException {
		
		bookService.save(book);
		
		MultipartFile bookImage = book.getBookImage();
		
		byte[] bytes = bookImage.getBytes();
		
		String name = book.getId() + ".png";
		
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/image/book/" + name)));
		
		stream.write(bytes);
		stream.close();
		
		return "redirect:bookList";
		
	}
	
	@RequestMapping("/bookList")
	public String bookList(Model model) {
		List<Book> bookList = bookService.findAll();
		
		model.addAttribute("bookList",bookList);
		return "bookList";
	}
	
	@RequestMapping("/bookInfo")
	public String bookInfo(@RequestParam("id") Long id, Model model) {
		Book book = bookService.findById(id);
		model.addAttribute("book",book);
		return "bookInfo";
	}
	
	@RequestMapping("/updateBook")
	public String updateBook(@RequestParam("id") Long id, Model model) {
		Book book = bookService.findById(id);
		model.addAttribute("book",book);
		return "updateBook";
	}
	
	@PostMapping("/updateBook")
	public String updateBookPost(@ModelAttribute("book") Book book) throws IOException {
		bookService.save(book);
		
		MultipartFile bookImage = book.getBookImage();
		
		if (!bookImage.isEmpty()) {
			byte[] bytes = bookImage.getBytes();
			
			String name = book.getId() + ".png";
			
			Files.delete(Paths.get("src/main/resources/static/image/book/" + name));
			
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/image/book/" + name)));
			
			stream.write(bytes);
			stream.close();
		}
		
		return "redirect:/book/bookList";
		
	}
	
	@PostMapping("/remove")
	public String remove(@ModelAttribute("id") String id,Model model) throws IOException {
		Long bookId = Long.parseLong(id.substring(8));
		String name = bookId + ".png";
		
		bookService.removeOne(bookId);
		
		Files.delete(Paths.get("src/main/resources/static/image/book/" + name));
		
		List<Book> bookList = bookService.findAll();
		
		model.addAttribute("bookList",bookList);
		
		return "redirect:/book/bookList";
	}

}
