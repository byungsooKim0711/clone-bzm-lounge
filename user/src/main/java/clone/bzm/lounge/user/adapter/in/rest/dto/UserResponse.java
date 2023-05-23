package clone.bzm.lounge.user.adapter.in.rest.dto;

import clone.bzm.lounge.user.domain.User;

import java.time.LocalDateTime;

public record UserResponse(
        Long id,
        String email,
        String name,
        String phoneNumber,
        String status,
        String token,
        LocalDateTime createdAt,
        LocalDateTime modifiedAt) {

    public static UserResponse of(User user) {
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getName(),
                user.getPhoneNumber(),
                user.getStatus(),
                user.getToken() == null ? null : user.getToken().accessToken(),
                user.getCreatedAt(),
                user.getModifiedAt()
        );
    }

    public static UserResponse maskingOf(User user) {
        throw new UnsupportedOperationException("//todo: ");
    }
}
