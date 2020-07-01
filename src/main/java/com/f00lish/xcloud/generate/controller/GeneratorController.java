package com.f00lish.xcloud.generate.controller;

import com.f00lish.xcloud.common.base.controller.BaseController;
import com.f00lish.xcloud.common.base.result.ResultMessage;
import com.f00lish.xcloud.generate.properties.DevtoolsProperties;
import com.f00lish.xcloud.generate.service.GenerateService;
import com.f00lish.xcloud.generate.service.TableService;
import com.f00lish.xcloud.generate.task.GenerateTask;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author f00lish
 * @version 2018/4/26
 * Created By IntelliJ IDEA.
 * Qun:530350843
 */
@RestController
@Api(value="/generator",tags = "代码生成器接口")
@RequestMapping("/generator")
public class GeneratorController extends BaseController {

    @Autowired
    private TableService tableService;

    @Autowired
    private GenerateService generateService;

    @Autowired
    private DevtoolsProperties devtoolsProperties;

    /**
     * 获取环境信息
     */
    @GetMapping("/env")
    @ApiOperation("获取代码生成器配置")
    public Object blackboard() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("tables",tableService.getAllTables());
        hashMap.put("params",devtoolsProperties);
        ResultMessage result = ResultMessage.success("");
        result.setData(hashMap);
        return result;
    }

    /**
     * 生成代码
     */
    @ApiOperation("生成代码")
    @PostMapping("/generate")
    public Object generate(GenerateTask generateTask){
        generateService.generate(generateTask);
        return ResultMessage.success("");
    }
}
