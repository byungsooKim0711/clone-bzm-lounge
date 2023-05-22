package clone.bzm.lounge.user.adapter.out.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.regex.Pattern;

@Getter
@Embeddable
class UserEmail {

    @Column(name = "email", nullable = false, length = 50)
    private String address;

    protected UserEmail() {
        /* empty */
    }

    protected UserEmail(String address) {
        // check validation
        checkAddress(address);

        this.address = address;
    }

    public static UserEmail of(String address) {
        return new UserEmail(address);
    }

    public String getName() {
        String[] tokens = address.split("@");
        if (tokens.length == 2) {
            return tokens[0];
        }
        throw new IllegalStateException("Invalid email format: " + address);
    }

    public String getDomain() {
        String[] tokens = this.address.split("@");
        if (tokens.length == 2) {
            return tokens[1];
        }

        throw new IllegalStateException("Invalid email format: " + this.address);
    }

    private static boolean checkAddress(String address) {
        return Pattern.matches("[\\w~\\-.+]+@[\\w~\\-]+(\\.[\\w~\\-]+)+", address);
    }
}
