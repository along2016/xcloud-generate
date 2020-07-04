package com.f00lish.xcloud.generate.service;

import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import lombok.Data;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * @author f00lish
 * @version 2018/4/26
 * Created By IntelliJ IDEA.
 * Qun:530350843
 */
@Data
public class EntityNameRewriter extends InjectionConfig {
    private String entityName;

    @Override
    public void initMap() {
        if(StringUtils.isNotEmpty(entityName)){
            List<TableInfo> tableInfoList = this.getConfig().getTableInfoList();
            if(tableInfoList != null){
                tableInfoList.get(0).setComment(entityName);
            }
        }
    }
}
