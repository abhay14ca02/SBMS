package com.rajabhay.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajabhay.user.entity.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Integer>{

}
