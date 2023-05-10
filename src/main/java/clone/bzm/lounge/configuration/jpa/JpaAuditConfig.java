package clone.bzm.lounge.configuration.jpa;

import clone.bzm.lounge.configuration.security.BzmUserDetails;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@EnableJpaAuditing
@Configuration
public class JpaAuditConfig {

    @Configuration
    public static class JpaAuditorAwareConfig implements AuditorAware<Long> {

        @Override
        public Optional<Long> getCurrentAuditor() {

            return Optional.ofNullable(SecurityContextHolder
                            .getContext()
                            .getAuthentication())
                    .map(authentication -> authentication instanceof AnonymousAuthenticationToken
                            ? null
                            : ((BzmUserDetails) authentication.getPrincipal())
                    )
                    .map(details -> details.getAuthentication().id());
        }
    }
}
