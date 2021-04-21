
package dto;


public class UserDTO {
    String userID, fullName, Password;
    boolean status;

    public UserDTO(String userID, String Password) {
        this.userID = userID;
        this.Password = Password;
    }
    
    

    public UserDTO(String userID, String fullName, String Password, boolean status) {
        this.userID = userID;
        this.fullName = fullName;
        this.Password = Password;
        this.status = status;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
