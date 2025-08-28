package com.unytech.spring_jpa_ex1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    public UserDetailsService userDetailsService;
    @Bean
    public AuthenticationProvider authProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(userDetailsService);
//        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());// this is for plan text paswword from DB
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));// here it looks for Encrypted password

        return provider;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

//        httpSecurity.csrf(customizer -> customizer.disable());
/**------------------------1-----------------------------------------------*/
//        httpSecurity.csrf(customizer -> customizer.disable());


//        Customizer<CsrfConfigurer<HttpSecurity>> custCsrf = new Customizer<CsrfConfigurer<HttpSecurity>>() {
//            @Override
//            public void customize(CsrfConfigurer<HttpSecurity> configurer) {
//                configurer.disable();
//            }
//        };
//
//        httpSecurity.csrf(custCsrf);

//        httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated())

/**---------------------------------2----------------------------------------------*/
//        httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated());

//
//        Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> custHttp = new Customizer<AuthorizeHttpRequestsConfigurer<org.springframework.security.config.annotation.web.builders.HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>() {
//            @Override
//            public void customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authRegistry) {
//                authRegistry.anyRequest().authenticated();
//            }
//        };
//
//        httpSecurity.authorizeHttpRequests(custHttp);

/**     -------------------------Customized Security with Lambda---------------------------------*/
//        httpSecurity.csrf(customizer -> customizer.disable());//-------1
//        httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated());//------------2
////        httpSecurity.formLogin(Customizer.withDefaults());
//        httpSecurity.httpBasic(Customizer.withDefaults());
//
//        httpSecurity.sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        /**---------------the above same code in Builder pattren -----------------------------*/

        httpSecurity
                    .csrf(customizer -> customizer.disable())
                    .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                    .httpBasic(Customizer.withDefaults())
                    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return httpSecurity.build();
    }

    /**-------static values*/
//    @Bean
//    public UserDetailsService userDetailsService(){
//
//        UserDetails user= User
//                                .withDefaultPasswordEncoder()
//                                .username("unay")
//                                .password("1234")
//                                .roles("USER")
//                                .build();
//
//        UserDetails admin= User
//                                .withDefaultPasswordEncoder()
//                                .username("admin")
//                                .password("admin@1234")
//                                .roles("ADMIN")
//                                .build();
//
//
//        return new InMemoryUserDetailsManager(user,admin);
//    }
}
