package com.fwf_bbs.forumcommon.api;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * @className CommonPage
 * @description 分页数据封装类
 * @auther wulongdog
 * @date 2022/10/3  16:56
 */
@Data
public class CommonPage <T>{

    /**
     * 当前页码
     */
    private Integer pageNum;

    /**
     * 每页数量
     */
    private Integer pageSize;

    /**
     * 总页数
     */
    private Integer totalPageNum;

    /**
     * 总条数
     */
    private Long total;

    /**
     * 数据
     */
    private List<T> list;

    /**
     * 将分页之后的数据list转换为分页信息
     * @param list
     * @return CommonPage<T>
     */
    public static <T> CommonPage<T> restPage(List<T> list) {
        CommonPage<T> result = new CommonPage<T>();
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        result.setTotalPageNum(pageInfo.getPages());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getList());
        return result;
    }
}
