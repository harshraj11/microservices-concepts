package net.javaguides.departmentservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RefreshScope
@RestController
@RequestMapping("/api")
public class HomeController {

    @Value("${message:Hello default}")
    private String message;

    @GetMapping("/message")
    String getMessage() {
        return this.message;
    }

    @GetMapping(value = "/productList")
    public String getProductList() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("User-Agent", "Application");
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response=restTemplate.exchange("https://catfact.ninja/fact", HttpMethod.GET, entity, String.class);
        System.out.println(response);
        return response.getBody();
    }
}
