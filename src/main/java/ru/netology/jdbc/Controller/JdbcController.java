package ru.netology.jdbc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.netology.jdbc.Service.JdbcService;

public class JdbcController {

    @Autowired
    private JdbcService service = new JdbcService();

    @GetMapping("/products/fetch-product")
    public String getProductName(@RequestParam ("name") String name) {
        return service.getProductName(name);
    }
}
