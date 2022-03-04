package com.example.demo.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@RestController
public class BookController {
	@Autowired
	private BookRepository repository;

	@PostMapping("/saveBook")
	public String saveBook(@RequestBody Book book) {
		repository.save(book);
		return "One Book saved";
	}

	@GetMapping("/findAllBooks")
	public List<Book> getBook() {
		return repository.findAll();
	}

	@GetMapping("/help")
	public String help() {
		return "Hello";
	}

	@GetMapping("/findAllBooks/{id}")
	public Optional<Book> getBook(@PathVariable int id) {
		return repository.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		repository.deleteById(id);
		return "Book Deleted with id :" + id;
	}
}