package ru.netology.jdbc.Repository;

import lombok.Data;
import org.apache.catalina.webresources.FileResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import ru.netology.jdbc.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@Repository
public class JdbcRepository {

    @Autowired
    JdbcOperations namedParameterJdbcTemplate;

    private String script = read("myScript.sql");
    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProductName(String name) {

        Person person = namedParameterJdbcTemplate.queryForObject(script,
                Map.of("name", "Oleg"),
                (rs, rowNum) -> new Person(rs.getString("name"), rs.getString("productName")));

        return person.toString();
    }
}
