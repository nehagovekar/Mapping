package com.hsbc.mastergroupservice.MastergroupMapping.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsbc.mastergroupservice.MastergroupMapping.service.MastergroupService;


@RestController
public class FileController{
@Autowired
private MastergroupService mastergroupService;
@GetMapping(value="/viewJson")
public ResponseEntity<String> viewJson()
{
	String json=mastergroupService.csvtojson();
	return new ResponseEntity<>(json,HttpStatus.OK);
	
	
}
}
