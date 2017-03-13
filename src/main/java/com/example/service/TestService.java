package com.example.service;

import com.example.Repository.CategoryRepository;
import com.example.Repository.TestRepository;
import com.example.domain.Category;
import com.example.domain.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by zach on 3/11/2017.
 */
@Service
@Transactional(readOnly = true)
public class TestService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TestRepository testRepository;

    /**
     *
     * @param name
     * @param date
     * @param category
     * @return
     */
    @Transactional
    public Test createTest(String name, Date date, Category category) {
       if(name == null || date == null || category == null)
       {
           LOG.info("Passed argument is null");
       }
        Test newTest = new Test(name,date,categoryRepository.findByName(category.getName()));
        testRepository.save(newTest);
        return newTest;
    }
}