package clone.bzm.lounge.userhistory.application.port.out.jpa;

import clone.bzm.lounge.userhistory.domain.UserLoginHistory;

public interface UserHistorySavePort {

    UserLoginHistory save(UserLoginHistory userLoginHistory);
}
