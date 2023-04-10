package com.pingpals.PingPals.repository;

import com.pingpals.PingPals.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{

}
