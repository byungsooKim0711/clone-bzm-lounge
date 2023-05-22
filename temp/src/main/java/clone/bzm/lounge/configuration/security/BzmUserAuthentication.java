package clone.bzm.lounge.configuration.security;

public record BzmUserAuthentication(
        Long id,
        String email,
        String name,
        String status) {
}
