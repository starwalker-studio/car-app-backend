package com.ford.app.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ford.app.model.UserLog;

@Repository
public interface UserRepoLog extends JpaRepository<UserLog, Integer> {
	
	@Modifying	
	@Transactional	
	@Query("update UserLog u set u.date_update_user = :date_update_user where u.idUser = :idUser and u.dateLog = :dateLog")
	public void updateDateUserId(@Param("date_update_user") String date_update_user, 
									@Param("idUser") int idUser, @Param("dateLog")String dateLog);
	
	public List<UserLog> findByIdUserOrderByDateLogDesc(int idUser);

}
