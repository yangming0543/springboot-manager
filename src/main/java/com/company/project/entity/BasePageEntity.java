package com.company.project.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * BaseEntity
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年3月18日
 */
@Data
@JsonIgnoreProperties(value = {"page", "limit", "getQueryPage"})
public class BasePageEntity {
    @JSONField(serialize = false)
    @TableField(exist = false)
    @JsonIgnore
    private Integer page;

    @JSONField(serialize = false)
    @TableField(exist = false)
    @JsonIgnore
    private Integer limit;

    /**
     * 数据权限：用户id
     */
    @JSONField(serialize = false)
    @TableField(exist = false)
    @JsonIgnore
    private List<String> createIds;

    /**
     * page条件
     *
     * @param <T>
     * @return
     */
    @JSONField(serialize = false)
    @JsonIgnore
    public <T> Page getQueryPage() {
        return new Page<T>(page == null ? 1 : page, limit == null ? 10 : limit);
    }
}
