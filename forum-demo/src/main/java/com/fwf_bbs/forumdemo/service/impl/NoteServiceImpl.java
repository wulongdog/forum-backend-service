package com.fwf_bbs.forumdemo.service.impl;

import com.fwf_bbs.forumdemo.entity.Note;
import com.fwf_bbs.forumdemo.mapper.NoteMapper;
import com.fwf_bbs.forumdemo.service.NoteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 作者
 * @since 2022-10-03
 */
@Service
public class NoteServiceImpl extends ServiceImpl<NoteMapper, Note> implements NoteService {

}
