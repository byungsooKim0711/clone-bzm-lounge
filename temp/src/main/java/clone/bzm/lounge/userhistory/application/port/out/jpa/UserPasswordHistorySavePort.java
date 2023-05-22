package clone.bzm.lounge.userhistory.application.port.out.jpa;

import clone.bzm.lounge.userhistory.domain.UserPasswordHistory;

public interface UserPasswordHistorySavePort {

    void save(UserPasswordHistory history);
}
