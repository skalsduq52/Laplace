package com.yeop.Laplace.repository;

import com.yeop.Laplace.VO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userId);
    int deleteByUserId(String userId);
}
