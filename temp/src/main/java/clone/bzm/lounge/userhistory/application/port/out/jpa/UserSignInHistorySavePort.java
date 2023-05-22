package clone.bzm.lounge.userhistory.application.port.out.jpa;

import clone.bzm.lounge.userhistory.domain.UserSignInHistory;

public interface UserSignInHistorySavePort {

    void save(UserSignInHistory userLoginHistory);
}
