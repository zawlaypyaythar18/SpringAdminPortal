package com.adminportal.admin.resources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adminportal.admin.service.BookService;

@RestController
public class ResourceController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/book/removeList")
	public String removeList(@RequestBody ArrayList<String> bookIdList, Model model) throws IOException {
		for (String id : bookIdList) {
			Long bookId = Long.parseLong(id.substring(8));
			String name = bookId + ".png";
			bookService.removeOne(bookId);
			Files.delete(Paths.get("src/main/resources/static/image/book/" + name));
		}
		
		return "success";
	}

}
