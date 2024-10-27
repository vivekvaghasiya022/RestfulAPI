package com.vivek.app.restapi.Repo;

import com.vivek.app.restapi.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
