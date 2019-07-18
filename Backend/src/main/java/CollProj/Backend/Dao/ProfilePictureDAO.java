package CollProj.Backend.Dao;

import CollProj.Backend.Model.ProfilePicture;

public interface ProfilePictureDAO 
{
   public boolean addProfilePicture(ProfilePicture profilePicture);
   public ProfilePicture getProfilePicture(String username);
}
