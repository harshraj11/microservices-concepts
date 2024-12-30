package net.javaguides.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/api/employee")
public class Homecontroller {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/productList")
    public String getProductList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("User-Agent", "Application");
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response=restTemplate.exchange("http://DEPARTMENT-SERVICE/api/department/productList", HttpMethod.GET, entity, String.class);
        System.out.println(response);
        return response.getBody();
    }

}
