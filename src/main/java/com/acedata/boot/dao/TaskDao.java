package com.acedata.boot.dao;

import com.acedata.boot.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;


@Repository
@Table(name = "task")
public interface TaskDao extends CrudRepository<Task, String> {




}
