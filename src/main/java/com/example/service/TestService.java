package com.example.service;

import com.example.Repository.CategoryRepository;
import com.example.Repository.TestRepository;
import com.example.Repository.UserRepository;
import com.example.domain.Category;
import com.example.domain.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zach on 3/11/2017.
 */
@Service
@Transactional
public class TestService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private UserRepository userRepository;

    /**
     *
     * @param name
     * @param date
     * @param category
     * @return
     */

    public Test createTest(String name, Date date, Category category) {
       if(name == null || date == null || category == null)
       {
           LOG.info("Passed argument is null");
       }
        Test newTest = new Test(name,date,categoryRepository.findByName(category.getName()));
        testRepository.save(newTest);
        return newTest;
    }
    public Set<Test> findAll()
    {
        Set<Test> findAllTests = new HashSet<>();
        for (Test test : testRepository.findAll()
             ) { findAllTests.add(test);

        }
        return findAllTests;
    }

}