package com.yupi.template.controller;

import com.yupi.template.annotation.AuthCheck;
import com.yupi.template.common.BaseResponse;
import com.yupi.template.common.ResultUtils;
import com.yupi.template.constant.UserConstant;
import com.yupi.template.model.vo.StatisticsVO;
import com.yupi.template.service.StatisticsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 统计分析控制器
 *
 * @author <a href="https://codefather.cn">编程导航学习圈</a>
 */
@RestController
@RequestMapping("/statistics")
@Slf4j
@Tag(name = "StatisticsController", description = "统计分析接口")
public class StatisticsController {

    @Resource
    private StatisticsService statisticsService;

    /**
     * 获取系统统计数据（仅管理员）
     */
    @GetMapping("/overview")
    @Operation(summary = "获取系统统计数据")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<StatisticsVO> getStatistics() {
        StatisticsVO statistics = statisticsService.getStatistics();
        return ResultUtils.success(statistics);
    }
}
