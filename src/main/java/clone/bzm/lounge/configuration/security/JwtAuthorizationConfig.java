package clone.bzm.lounge.configuration.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;


/**
 * Custom Argument Resolver 등록
 */
@RequiredArgsConstructor
@Configuration
public class JwtAuthorizationConfig implements WebMvcConfigurer {

    private final BzmMemberMethodArgumentResolver resolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(resolver);
    }
}