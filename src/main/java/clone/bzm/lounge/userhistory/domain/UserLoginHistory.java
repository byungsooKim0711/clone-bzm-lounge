package clone.bzm.lounge.userhistory.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserLoginHistory {

    private Long signInUserId;

    private String device;

    private String ip;

    private String service;

    private String type;

    @Builder
    public UserLoginHistory(Long signInUserId, String device, String ip, String service, String type) {
        this.signInUserId = signInUserId;
        this.device = device;
        this.ip = ip;
        this.service = service;
        this.type = type;
    }
}
