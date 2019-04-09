package com.va.laundryjunction.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.va.laundryjunction.dao.UserDao;
import com.va.laundryjunction.domain.User;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserDao userDao;

  @Autowired
  private Algorithm laundrtyJunctionHmacAlgorithm;

  public String authenticateUser(String username, String pasword){
    User user = userDao.getUserCredentials(username);

    // TODO:
    // create hashpassword using sha-2(password, salt) and compare that with user.hashedPassword.
    // if both are same create a JWT token and return
    return JWT.create()
        .withIssuedAt(new Date())
        // TODO: configure it in config map
        .withIssuer("laundryJunction")
        .sign(laundrtyJunctionHmacAlgorithm);
  }
}
