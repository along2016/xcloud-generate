package com.f00lish.xcloud.generate.service;

import com.f00lish.xcloud.generate.mapper.TablesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author f00lish
 * @version 2018/4/26
 * Created By IntelliJ IDEA.
 * Qun:530350843
 */
@Service
public class TableService {

    @Value("${spring.datasource.db-name}")
    private String dbName;

    @Autowired
    private TablesMapper tablesMapper;

    /**
     * 获取当前数据库所有的表信息
     */
    public List<Map<String, Object>> getAllTables() {
        return tablesMapper.getAllTables(dbName);
    }
}
