package clone.bzm.lounge.userhistory.application.port.in;

import clone.bzm.lounge.userhistory.application.port.in.command.UserPasswordHistoryCommand;

public interface UserPasswordHistoryUseCase {

    void savePasswordHistory(UserPasswordHistoryCommand command);
}
