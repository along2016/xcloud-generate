package com.f00lish.xcloud.generate.task;

import lombok.Data;

/**
 * @author f00lish
 * @version 2018/4/26
 * Created By IntelliJ IDEA.
 * Qun:530350843
 */
@Data
public class GenerateTask {

    private String projectLocation;

    private String tablePrefix;

    private String packageName;

    private String tableName;

    private String entityName;

    private String module;

    private String developer;

    private Boolean onlyGenerateEntity;
}
