package com.ford.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ford.app.model.UserAccount;

@Repository
public interface UserRepoAccount extends JpaRepository<UserAccount, Integer> {
	
	List<UserAccount> findByIduser(int id);

}
