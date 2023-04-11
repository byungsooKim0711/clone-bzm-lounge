package clone.bzm.lounge.userhistory.application.port.in;

import clone.bzm.lounge.userhistory.application.port.in.command.UserHistoryCommand;

public interface UserHistoryUseCase {

    void saveSignInHistory(UserHistoryCommand command);
}
