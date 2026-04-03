package com.test.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.StoryBook;

@Repository
public interface StoryBookRepository extends ReactiveCrudRepository<StoryBook, Long>
{

}
