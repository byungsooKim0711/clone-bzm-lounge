package clone.bzm.lounge.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class User {

    private Long id;

    private String email;

    @JsonIgnore
    private String securePassword;

    private String name;

    private String phoneNumber;

    private String status;

    private UserToken token;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    protected User(Long id,
                   String email,
                   String securePassword,
                   String name,
                   String phoneNumber,
                   String status,
                   LocalDateTime createdAt,
                   LocalDateTime modifiedAt) {
        this.id = id;
        this.email = email;
        this.securePassword = securePassword;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public static User withId(Long id,
                              String email,
                              String securePassword,
                              String name,
                              String phoneNumber,
                              String status,
                              LocalDateTime createdAt,
                              LocalDateTime modifiedAt) {
        return new User(id, email, securePassword, name, phoneNumber, status, createdAt, modifiedAt);
    }

    public static User signUp(String email,
                              String securePassword,
                              String name,
                              String phoneNumber) {
        return new User(null, email, securePassword, name, phoneNumber, null, null, null);
    }

    public void addToken(UserToken token) {
        this.token = token;
    }
}
