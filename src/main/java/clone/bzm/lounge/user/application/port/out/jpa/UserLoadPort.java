package clone.bzm.lounge.user.application.port.out.jpa;

import clone.bzm.lounge.user.domain.User;

public interface UserLoadPort {

    User findByEmail(String email);

    User findUser(String email, String plainPassword);

    User findById(Long id);

    boolean existsByEmail(String email);

}
