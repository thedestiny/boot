package com.acedata.boot.dao;

import com.acedata.boot.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;


@Table(name="user")
@Repository
public interface UserDao extends CrudRepository<User, Long> {



}
