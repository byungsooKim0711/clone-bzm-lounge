package clone.bzm.lounge.user.application.port.out.jpa;

import clone.bzm.lounge.user.domain.User;

public interface UserSavePort {

    User signUp(User user);
}
