package com.pk.Dao;

import com.pk.Model.ProfilePicture;

public interface ProfilePictureDAO 
{
   public boolean addProfilePicture(ProfilePicture profilePicture);
   public ProfilePicture getProfilePicture(String username);
}
