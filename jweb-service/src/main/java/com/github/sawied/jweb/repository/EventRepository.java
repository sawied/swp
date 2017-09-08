package com.github.sawied.jweb.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.github.sawied.jweb.entity.Event;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

}