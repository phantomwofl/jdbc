package ru.netology.jdbc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.jdbc.Repository.JdbcRepository;

public class JdbcService {
    
    @Autowired
    private JdbcRepository jdbcRepository;


    public String getProductName(String name) {
        return jdbcRepository.getProductName(name);
    }
}