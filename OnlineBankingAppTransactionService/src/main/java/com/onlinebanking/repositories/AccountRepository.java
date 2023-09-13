package com.onlinebanking.repositories;

import org.springframework.context.annotation.Scope;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebanking.models.Account;




@Repository (value="AccountRepository")
@Scope(value="singleton")

public interface AccountRepository extends JpaRepository<Account, Integer>{
	

	
}
