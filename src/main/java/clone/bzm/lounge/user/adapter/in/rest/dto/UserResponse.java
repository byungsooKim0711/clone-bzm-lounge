package clone.bzm.lounge.user.adapter.in.rest.dto;

import clone.bzm.lounge.user.domain.User;

public record UserResponse(
        Long id,
        String email,
        String name,
        String phoneNumber,
        String status) {

    public static UserResponse of(User user) {
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getName(),
                user.getPhoneNumber(),
                user.getStatus()
        );
    }

    public static UserResponse maskingOf(User user) {
        throw new UnsupportedOperationException("//todo: ");
    }
}