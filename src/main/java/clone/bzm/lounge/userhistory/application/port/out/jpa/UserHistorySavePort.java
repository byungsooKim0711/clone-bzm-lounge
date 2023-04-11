package clone.bzm.lounge.userhistory.application.port.out.jpa;

import clone.bzm.lounge.userhistory.domain.UserHistoryInfo;

public interface UserHistorySavePort {

    UserHistoryInfo save(UserHistoryInfo userHistory);
}
