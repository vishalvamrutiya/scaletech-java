package com.delivery.daily.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.delivery.daily.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
