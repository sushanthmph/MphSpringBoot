package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.StoryBook;
import com.test.repository.StoryBookRepository;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/storybook")
public class StoryBookController {
	
	@Autowired
	private StoryBookRepository repository;
	
	@PostMapping("/create")
	public Mono<StoryBook> createStoryBook(@RequestBody StoryBook book)
	{
		return repository.save(book);
	}
	
	@GetMapping("/list")
	public Flux<StoryBook> listAllStoryBooks()
	{
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Mono<StoryBook> getBookById(@PathVariable long id)
	{
		return repository.findById(id);
	}
	
	@PutMapping("/update/{id}")
	public Mono<StoryBook> updateBookById(@PathVariable long id, @RequestBody StoryBook book)
	{
		book.setId(id);
		
		return repository.save(book);
	}
	
	@DeleteMapping("/delete/{id}")
	public Disposable deleteBookById(@PathVariable long id)
	{
		return repository.deleteById(id).subscribe();
		
		//return repository.findAll();
	}

}
