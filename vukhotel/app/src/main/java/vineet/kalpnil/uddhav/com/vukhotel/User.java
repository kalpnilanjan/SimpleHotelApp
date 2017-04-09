package vineet.kalpnil.uddhav.com.vukhotel;

/**
 * Created by abc on 05-Apr-16.
 */
public class User {

    String name, username, password, email;
    String gender,mobile;

    public User(String name, String username, String password, String mobile, String email, String gender) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.mobile = mobile;
        this.email = email;
        this.gender = gender;
    }
    public User(String username, String password) {
        this("", username, password, "", "", "");
    }
}
