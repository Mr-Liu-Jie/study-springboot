package com.liujie.study.springboot.jpa.controller;

import com.liujie.study.springboot.jpa.core.BaseController;
import com.liujie.study.springboot.jpa.core.Response;
import com.liujie.study.springboot.jpa.entity.UserDetail;
import com.liujie.study.springboot.jpa.repository.UserDetailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user_detail")
public class UserDetailController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailController.class);

    @Autowired
    private UserDetailRepository userDetailRepository;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public Object get(@PathVariable Long userId) {
        if (userId > 0) {
            UserDetail userDetail = userDetailRepository.findByUserId(userId);
            if (userDetail != null) {
                return Response.data(userDetail);
            }
        }

        return Response.error("参数错误");
    }
}
