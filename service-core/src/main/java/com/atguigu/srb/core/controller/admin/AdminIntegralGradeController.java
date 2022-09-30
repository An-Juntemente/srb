package com.atguigu.srb.core.controller.admin;


import com.atguigu.common.exception.Assert;
import com.atguigu.common.exception.BusinessException;
import com.atguigu.common.result.R;
import com.atguigu.common.result.ResponseEnum;
import com.atguigu.srb.core.pojo.entity.IntegralGrade;
import com.atguigu.srb.core.service.IntegralGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 积分等级表 前端控制器
 * </p>
 *
 * @author anyqing
 * @since 2022-08-30
 */
@Api(tags = "积分等级管理")
@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/admin/core/integralGrade")
public class AdminIntegralGradeController {

    @Autowired
    private IntegralGradeService integralGradeService;

    @ApiOperation("查询积分等级列表")
    @GetMapping("/list")
    public R listAll(){

        log.info("Hi, Logback");
        log.warn("Hi, Logback");
        log.error("Hi, Logback");

        List<IntegralGrade> list = integralGradeService.list();
        return R.succ().data("list",list).msg("获取积分等级列表成功");
    }

    @ApiOperation(value = "根据Id删除积分等级记录", notes = "逻辑删除")
    @DeleteMapping("/remove/{id}")
    public R remove(
            @ApiParam(value = "Id", required = true, example = "1")
            @PathVariable("id")Long id){
         return integralGradeService.removeById(id) ?
                 R.succ().msg("删除积分等级成功") : R.fail().msg("删除积分等级失败");
    }

    @ApiOperation(value = "根据Id查询积分等级")
    @GetMapping("/get/{id}")
    public R selectById(
            @ApiParam(value = "积分等级id", required = true, example = "1")
            @PathVariable("id") Long id){
        IntegralGrade integralGrade = integralGradeService.getById(id);
        return integralGrade != null ?
                R.succ().data("integralGrade",integralGrade) :
                R.fail().msg("查询失败");
    }

    @ApiOperation(value = "根据Id更新积分等级")
    @PutMapping("/update")
    public R updateById(
            @ApiParam("积分等级对象")
            @RequestBody IntegralGrade integralGrade){
        return integralGradeService.updateById(integralGrade) ?
                R.succ().msg("更新积分等级成功") :
                R.fail().msg("更新积分等级失败");
    }

    @ApiOperation(value = "新增积分等级")
    @PostMapping("/save")
    public R save(
            @ApiParam("积分等级对象")
            @RequestBody IntegralGrade integralGrade){
        if (integralGrade.getBorrowAmount() == null){
            throw  new BusinessException(ResponseEnum.BORROW_AMOUNT_NULL_ERROR);
        }
        //Assert.notNull(integralGrade.getBorrowAmount(),ResponseEnum.BORROW_AMOUNT_NULL_ERROR);

        return integralGradeService.save(integralGrade) ?
                R.succ().msg("新增积分等级成功") :
                R.fail().msg("新增积分等级失败");
    }
}

