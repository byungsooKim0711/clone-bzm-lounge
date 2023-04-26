package clone.bzm.lounge.user.application.port.out.jpa;

import clone.bzm.lounge.user.application.port.in.command.ChangePasswordCommand;
import clone.bzm.lounge.user.application.port.in.command.SignUpCommand;
import clone.bzm.lounge.user.domain.User;

public interface UserSavePort {

    User signUp(SignUpCommand command);

    User changePassword(ChangePasswordCommand command);
}
