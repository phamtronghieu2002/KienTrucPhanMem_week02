package com.example.apigateway.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class APIGateWayController {


    private  String urlApiUser = "http://localhost:8081/users";
    private  String urlApiProduct = "http://localhost:8080/api/users/products";


    @GetMapping("/listUser")
    public List<Map<String, Object>> getAllUsers(){

 ResponseEntity<List<Map<String, Object>>> responseEntity = restTemplate.exchange(
             urlApiUser,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Map<String,Object>>>() {}
        );
        List<Map<String, Object>> userList = responseEntity.getBody()
        return userList;
    }

    @GetMapping("/listProduct")
    public List<Map<String, Object>> getAllProduct(){
   ResponseEntity<List<Map<String, Object>>> responseEntity = restTemplate.exchange(
                urlApiProduct,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Map<String,Object>>>() {}
        );

        List<Map<String, Object>> productList = responseEntity.getBody();
        return productList;
    }
}
