package clone.bzm.lounge.user.application.port.out.jpa;

import clone.bzm.lounge.user.domain.User;

public interface UserLoadPort {

    User findByEmail(String address);
    User findById(Long id);
}
