package clone.bzm.lounge.user.application.port.out.jpa;

import clone.bzm.lounge.user.domain.UserInfo;

public interface UserSavePort {

    UserInfo signUp(UserInfo userInfo);
}
