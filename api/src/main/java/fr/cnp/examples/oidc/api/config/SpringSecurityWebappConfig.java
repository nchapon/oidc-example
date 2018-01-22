package fr.cnp.examples.oidc.api.config;

import fr.cnp.examples.oidc.api.CustomAccessDeniedHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * Created by nchapon on 22/01/18.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityWebappConfig extends WebSecurityConfigurerAdapter {

    private CustomAccessDeniedHandler customAccessDeniedHandler;

    public SpringSecurityWebappConfig(CustomAccessDeniedHandler customAccessDeniedHandler) {
        this.customAccessDeniedHandler = customAccessDeniedHandler;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().fullyAuthenticated()
                .and()
                .addFilterBefore(new RequestContextUserFilter(), BasicAuthenticationFilter.class)
                .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler);
    }


}
