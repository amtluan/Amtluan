
package bai2;


public class Account {
    public Account(String username, String firstname, String lastname, String password, String phone, String email) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String phone;
    private String email;

    Account(String us, String fName, String lname, String pass, int phone, String mail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

        public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
         public void print() {
//        System.out.println(code + ", " + name + ", " + price);
          System.out.println(username + ";" + firstname + ";" + lastname+";"+password+";"+email+";"+phone);
    }
    public int compareTo(Object emp) {
        return this.getUsername().compareTo(((Account)emp).getUsername());
    } 
    
}
