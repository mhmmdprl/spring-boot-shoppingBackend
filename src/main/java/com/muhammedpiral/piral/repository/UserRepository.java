package com.muhammedpiral.piral.repository;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.muhammedpiral.piral.entity.account.Users;

public interface UserRepository extends JpaRepository<Users,Long> {

	Users findByUsername(String username);

	@Modifying
	@Query("update Users u set u.deleted='1', u.updatedBy=?1 where u.uuid=?2")
	@Transactional
	void delete(Long updatedById,UUID uuid);
	
	
	Users findByUuid(UUID uuid);
}
