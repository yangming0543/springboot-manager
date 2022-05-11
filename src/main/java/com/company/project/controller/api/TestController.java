package com.company.project.controller.api;

import com.company.project.common.utils.DataResult;
import com.company.project.service.HttpApiSessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * 首页
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年5月11日
 */
@RestController
@RequestMapping("/app/api")
@Api(tags = "test")
public class TestController {

    @Resource
    HttpApiSessionService httpApiSessionService;

    @GetMapping("/test")
    @ApiOperation(value = "获取首页数据接口")
    public DataResult getHomeInfo() {
        //拿userId与userName
        String userId = httpApiSessionService.getCurrentUserId();
        String username = httpApiSessionService.getCurrentUsername();
        return DataResult.success();
    }
}
