package clone.bzm.lounge.user.adapter.in.rest.dto;

import clone.bzm.lounge.user.domain.UserInfo;

public record UserResponse(
        Long id,
        String email,
        String name,
        String phoneNumber,
        String status) {

    public static UserResponse of(UserInfo userInfo) {
        return new UserResponse(
                userInfo.getId(),
                userInfo.getEmail(),
                userInfo.getName(),
                userInfo.getPhoneNumber(),
                userInfo.getStatus()
        );
    }

    public static UserResponse maskingOf(UserInfo userInfo) {
        throw new UnsupportedOperationException("//todo: ");
    }
}
