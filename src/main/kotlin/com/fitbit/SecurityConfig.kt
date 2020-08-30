package com.fitbit

import com.fitbit.api.UserService
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter


@Configuration
class SecurityConfig (val userService: UserService) : WebSecurityConfigurerAdapter() {

  @Throws(Exception::class)
  override fun configure(security: HttpSecurity?) {
    security?.antMatcher("/**")?.
    authorizeRequests()?.
    antMatchers("/test")?.
    authenticated()?.
    and()?.
    oauth2Login()?.
    userInfoEndpoint()
      ?.oidcUserService(userService.oidcUserService())
  }
}

