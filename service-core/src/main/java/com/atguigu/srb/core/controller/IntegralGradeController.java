package com.atguigu.srb.core.controller;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 积分等级表 前端控制器
 * </p>
 *
 * @author anyqing
 * @since 2022-08-30
 */
@Api(tags = "积分等级信息接口")
@RestController
@RequestMapping("/api/core/integralGrade")
public class IntegralGradeController {

    @GetMapping("/test")
    public void test(){}

}

