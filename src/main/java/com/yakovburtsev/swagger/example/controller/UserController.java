/*
 * Copyright 2018 Russian Post
 *
 * This source code is Russian Post Confidential Proprietary.
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 * Otherwise this violation would be treated by law and would be subject to legal prosecution.
 * Legal use of the software provides receipt of a license from the right holder only.
 */
package com.yakovburtsev.swagger.example.controller;

import com.yakovburtsev.swagger.example.entity.User;
import com.yakovburtsev.swagger.example.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api(value = "User controller")
@RequestMapping("/swagger-example/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Create user", notes = "method to create a new user")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Name", name = "name", dataType = "string", paramType = "query"),
            @ApiImplicitParam(value = "Age", name = "age", dataType = "int", paramType = "query"),
            @ApiImplicitParam(value = "Sex", name = "sex", dataType = "enum", allowableValues = "MALE, FEMALE", paramType = "query")
    })
    @PostMapping(value = "/create")
    @ResponseBody
    public User create(@ApiIgnore User user) {
        return userService.create(user);
    }

    @GetMapping(value = "/all")
    public List<User> all() {
        return userService.getAll();
    }

}
