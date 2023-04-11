package clone.bzm.lounge.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

@Getter
public class UserInfo {

    private Long id;

    private String email;

    @JsonIgnore
    private String securePassword;

    private String name;

    private String phoneNumber;

    private String status;

    protected UserInfo(Long id,
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

    public static UserInfo withId(Long id,
                                  String email,
                                  String securePassword,
                                  String name,
                                  String phoneNumber,
                                  String status) {
        return new UserInfo(id, email, securePassword, name, phoneNumber, status);
    }

    public static UserInfo signUp(String email,
                                  String securePassword,
                                  String name,
                                  String phoneNumber) {
        return new UserInfo(null, email, securePassword, name, phoneNumber, null);
    }
}
