package clone.bzm.lounge.user.application.port.out.jpa;

import clone.bzm.lounge.user.domain.UserInfo;

public interface UserLoadPort {

    UserInfo findByEmail(String address);
    UserInfo findById(Long id);
}
