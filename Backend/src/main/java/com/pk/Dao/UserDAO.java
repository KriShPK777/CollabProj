package com.pk.Dao;

import com.pk.Model.UserDetail;

public interface UserDAO 
{
      public boolean registeruser(UserDetail user);
      public UserDetail getUserDetail(String username);
      public UserDetail checkUserCredential(UserDetail user);
      public boolean updateUser(UserDetail user);
}
