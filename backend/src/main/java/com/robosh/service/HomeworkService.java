package com.robosh.service;

import com.robosh.data.mapping.HomeworkMapper;
import com.robosh.data.repository.HomeworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeworkService {

    private HomeworkRepository homeworkRepository;
    private HomeworkMapper homeworkMapper;

    @Autowired
    public HomeworkService(HomeworkRepository homeworkRepository) {
        this.homeworkRepository = homeworkRepository;
        homeworkMapper = HomeworkMapper.INSTANCE;
    }


}
