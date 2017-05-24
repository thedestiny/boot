package com.acedata.boot.service.inter;

import com.acedata.boot.domain.User;

import java.util.List;


public interface IndexService {

    List<String> queryList();

    User queryUserByName(String name);




}
