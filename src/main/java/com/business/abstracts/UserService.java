package com.business.abstracts;

import com.core.DataResult;
import com.core.Result;
import com.core.entities.User;

public interface UserService {
    Result add(User user);

    DataResult<User> findByEmail(String email);
}
