//package com.example.blogapparturascerniauskas.config;
//
//import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@Profile("!test")
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final UserDetailsService userDetailsService;
//
//    public SecurityConfig(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/public/**", "/")
//                    .permitAll()
//                .antMatchers("/private/**")
//                    .authenticated()
//                .anyRequest()
//                    .authenticated()
//                .and()
//                .formLogin()
//                    .loginPage("/customLogin")
//                    .usernameParameter("customUsername")
//                    .passwordParameter("customPassword")
//                    .defaultSuccessUrl("/public/blogs", true)
//                    .failureUrl("/customLogin?error")
//                    .permitAll()
//                    .and()
//                .logout()
//                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
//                    .permitAll();
//    }
//
//    @Override
//    public void configure(WebSecurity web) {
//        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
//    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        PasswordEncoder delegatingPasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        auth.userDetailsService(userDetailsService)
//                .passwordEncoder(delegatingPasswordEncoder);
//    }
//}
