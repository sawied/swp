package com.github.sawied.jweb.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.github.sawied.jweb.entity.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long>,UserRepositoryCustom{

}
