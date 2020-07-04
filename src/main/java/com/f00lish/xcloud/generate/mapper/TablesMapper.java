package com.f00lish.xcloud.generate.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author wangjiliang
 * @since 2020-07-01
 */
@Repository
public interface TablesMapper {

    @Select("select TABLE_NAME as tableName,TABLE_COMMENT as tableComment from information_schema.`TABLES` where TABLE_SCHEMA = #{tableSchema}")
    List<Map<String, Object>> getAllTables(@Param("tableSchema") String tableSchema);
}
