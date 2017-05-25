package com.acedata.boot.web;

import com.acedata.boot.domain.Task;
import com.acedata.boot.service.impl.IndexServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;


@Controller
public class IndexController {


    @Autowired
    private IndexServiceImpl indexService;

    @RequestMapping(value = "/index/data",method = RequestMethod.GET)
    @ResponseBody
    public List<String> getData(){

        List<String> list = indexService.queryList();

        Collections.reverse(list);

        for (String str : list) {
            System.out.println("str is : " + str);
        }

        return list;
    }


    @RequestMapping(value = "/index/index.html",method = RequestMethod.GET)
    public String getIndexPage(){

        return "index";
    }

    @RequestMapping(value = "/index/task/list",method = RequestMethod.GET)
    @ResponseBody
    public List<Task> getTaskList(){

        return indexService.getTaskList();

    }










}
