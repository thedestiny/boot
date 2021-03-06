package com.acedata.boot.service.impl;

import com.acedata.boot.dao.TaskDao;
import com.acedata.boot.dao.UserDao;
import com.acedata.boot.domain.Task;
import com.acedata.boot.domain.User;
import com.acedata.boot.service.inter.IndexService;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class IndexServiceImpl implements IndexService {


    @Autowired
    private TaskDao taskDao;

    @Autowired
    private UserDao userDao;

    private Logger logger = LoggerFactory.getLogger(IndexServiceImpl.class);


    @Override
    public List<String> queryList() {

        List<String> list = Lists.newArrayList("12", "23", "56", "98", "87");
        Collections.sort(list);

        for (String str : list) {
            logger.debug("str is {}", str);
        }

        return list;
    }

    @Override
    public User queryUserByName(String name) {

        User user = new User();
        user.setAddress("USA");
        user.setAge(7);
        user.setUserName("jim");

        return user;
    }

    @Autowired
    public List<Task> getTaskList() {
        Iterable<Task> taskIterable = taskDao.findAll();

        if (taskIterable instanceof List) {
            return (List<Task>) taskIterable;
        }

        return Lists.newArrayList();

    }

    @Autowired
    public Integer saveTask(Task task) {

        return 1;
    }


}
