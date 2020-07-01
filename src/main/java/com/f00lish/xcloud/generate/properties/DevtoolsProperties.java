package com.f00lish.xcloud.generate.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author f00lish
 * @version 2018/4/26
 * Created By IntelliJ IDEA.
 * Qun:530350843
 */
@Component
@ConfigurationProperties(prefix = "xcloud.generate")
public class DevtoolsProperties {

    /**
     * 项目路径
     */
    private String projectLocation;

    /**
     * 开发者
     */
    private String developer;

    /**
     * 表的前缀
     */
    private String tablePrefix;

    public String getProjectLocation() {
        return projectLocation;
    }

    public void setProjectLocation(String projectLocation) {
        this.projectLocation = projectLocation;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getTablePrefix() {
        return tablePrefix;
    }

    public void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix;
    }
}