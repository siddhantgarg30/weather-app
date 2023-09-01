package com.weather.forecast.app.repository;

import com.weather.forecast.app.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {
    UserDetail findByUsername(String username);
}
