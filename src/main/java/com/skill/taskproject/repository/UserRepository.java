package com.skill.taskproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skill.taskproject.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
    Optional <Users> findByEmail(String email);
}
