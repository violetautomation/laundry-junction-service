package com.va.laundryjunction.controller;

import com.va.laundryjunction.dto.Response;
import com.va.laundryjunction.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@Api(description="user service for laundry junction")
public class UserController {

  @Autowired
  private UserService userService;

  @ApiOperation(value = "authentication service for laundry junction")
  @PostMapping(path = "logon", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response> authenticateUser(@RequestParam String username, @RequestParam String password) {
    String token = userService.authenticateUser(username,password);
    return ResponseEntity.ok(Response.builder().token(token).build());
  }

}
