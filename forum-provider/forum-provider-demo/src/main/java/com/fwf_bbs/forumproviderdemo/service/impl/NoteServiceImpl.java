package com.fwf_bbs.forumproviderdemo.service.impl;

import com.fwf_bbs.forumproviderdemo.mapper.NoteMapper;
import com.fwf_bbs.forumproviderdemo.model.entity.Note;
import com.fwf_bbs.forumproviderdemo.service.NoteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 作者
 * @since 2022-10-08
 */
@Service
public class NoteServiceImpl extends ServiceImpl<NoteMapper, Note> implements NoteService {

    @Override
    public Note getById(Serializable id) {
        return super.getById(id);
    }
}
