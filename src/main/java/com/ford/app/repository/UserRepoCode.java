package com.ford.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ford.app.model.UserCode;

@Repository
public interface UserRepoCode extends JpaRepository<UserCode, Integer> {

	UserCode findByCode(int code);
	
}
