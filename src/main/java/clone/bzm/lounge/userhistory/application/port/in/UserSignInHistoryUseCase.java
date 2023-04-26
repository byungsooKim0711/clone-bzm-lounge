package clone.bzm.lounge.userhistory.application.port.in;

import clone.bzm.lounge.userhistory.application.port.in.command.UserSignInHistoryCommand;

public interface UserSignInHistoryUseCase {

    void saveSignInHistory(UserSignInHistoryCommand command);
}
