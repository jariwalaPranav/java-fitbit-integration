package com.fitbit.api

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService
import org.springframework.security.oauth2.core.OAuth2AuthenticationException
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser
import org.springframework.security.oauth2.core.oidc.user.OidcUser
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService : DefaultOAuth2UserService() {
  var accessToken = "Bearer "

  @Throws(OAuth2AuthenticationException::class)
  override fun loadUser(userRequest: OAuth2UserRequest?): OAuth2User? {
    accessToken = "Bearer "
    accessToken = this.accessToken.plus(userRequest?.accessToken?.tokenValue ?: "")
    return super.loadUser(userRequest)
  }

  fun oidcUserService(): OAuth2UserService<OidcUserRequest, OidcUser>? {
    val delegate = OidcUserService()
    return OAuth2UserService { userRequest: OidcUserRequest ->
      // Delegate to the default implementation for loading a user
      var oidcUser = delegate.loadUser(userRequest)
      val accessToken = userRequest.accessToken
      this.accessToken = accessToken.tokenValue
      val mappedAuthorities: Set<GrantedAuthority> =
        HashSet()

      // TODO
      // 1) Fetch the authority information from the protected resource using accessToken
      // 2) Map the authority information to one or more GrantedAuthority's and add it to mappedAuthorities

      // 3) Create a copy of oidcUser but use the mappedAuthorities instead
      oidcUser = DefaultOidcUser(
        mappedAuthorities,
        oidcUser.idToken,
        oidcUser.userInfo
      )
      oidcUser
    }
  }
}
