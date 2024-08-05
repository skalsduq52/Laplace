package com.yeop.Laplace.repository;

import com.yeop.Laplace.VO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(String userId);
    void deleteByUserId(String userId);
}
