package com.acedata.boot.service.impl;

import com.acedata.boot.domain.User;
import com.acedata.boot.service.inter.IndexService;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class IndexServiceImpl implements IndexService {


    @Override
    public List<String> queryList() {

        List<String> list = Lists.newArrayList("12", "23", "56", "98", "87");
        Collections.sort(list);

        for (String str : list) {
            System.out.println("str is : " + str);
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
}
