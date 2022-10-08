package com.fwf_bbs.forumproviderdemo.web.controller;

import com.fwf_bbs.forumcommon.api.CommonResult;
import com.fwf_bbs.forumproviderdemo.model.entity.Note;
import com.fwf_bbs.forumproviderdemo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 作者
 * @since 2022-10-08
 */
@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @RequestMapping("/get")
    public CommonResult<Note> getNote() {
        return CommonResult.success(noteService.getById(6));
    }

}
