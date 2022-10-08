package com.fwf_bbs.forumproviderdemo.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author 作者
 * @since 2022-10-08
 */
@Getter
@Setter
@TableName("t_note")
@ApiModel(value = "Note对象", description = "")
public class Note {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("content")
    private String content;

    @TableField("time")
    private LocalDateTime time;

    @TableField("title")
    private String title;


}
