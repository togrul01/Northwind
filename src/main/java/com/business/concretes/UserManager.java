package com.business.concretes;

import com.business.abstracts.UserService;
import com.core.DataResult;
import com.core.Result;
import com.core.SuccessDataResult;
import com.core.SuccessResult;
import com.core.dataAccess.UserDao;
import com.core.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao)  {
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        userDao.save(user);
        return new SuccessResult("User added :" );
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<>(userDao.findByEmail(email), "User found");
    }
}
