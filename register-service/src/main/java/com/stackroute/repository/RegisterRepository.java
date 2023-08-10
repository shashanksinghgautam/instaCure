package com.stackroute.repository;

import com.stackroute.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<UserEntity,Integer> {

   public UserEntity findByEmail(String email);
   public UserEntity findByMobile(String mobile);

   public UserEntity findByEmailAndPasswordAndRole(String email, String password,String role);
}
