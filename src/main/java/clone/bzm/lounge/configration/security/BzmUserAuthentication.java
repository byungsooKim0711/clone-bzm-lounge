package clone.bzm.lounge.configration.security;

public record BzmUserAuthentication(
        Long id,
        String email,
        String name,
        String status) {
}
