package clone.bzm.lounge.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

@Getter
public class User {

    private Long id;

    private String email;

    @JsonIgnore
    private String securePassword;

    private String name;

    private String phoneNumber;

    private String status;

    protected User(Long id,
                   String email,
                   String securePassword,
                   String name,
                   String phoneNumber,
                   String status) {
        this.id = id;
        this.email = email;
        this.securePassword = securePassword;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    public static User withId(Long id,
                              String email,
                              String securePassword,
                              String name,
                              String phoneNumber,
                              String status) {
        return new User(id, email, securePassword, name, phoneNumber, status);
    }

    public static User signUp(String email,
                              String securePassword,
                              String name,
                              String phoneNumber) {
        return new User(null, email, securePassword, name, phoneNumber, null);
    }
}
