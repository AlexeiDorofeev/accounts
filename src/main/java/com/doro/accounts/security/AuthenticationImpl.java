//package com.doro.accounts.security;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import java.util.Collection;
//
//public class AuthenticationImpl implements Authentication {
//
//    private final String name;
//    private final Collection<? extends GrantedAuthority> authorities;
//    private final Object details;
//    private boolean authenticated;
//
//    public AuthenticationImpl(String name, Collection<? extends GrantedAuthority> authorities, Object details) {
//        this.name = name;
//        this.authorities = authorities;
//        this.details = details;
//        this.authenticated = true;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public Object getCredentials() {
//        return null;
//    }
//
//    @Override
//    public Object getDetails() {
//        return details;
//    }
//
//    @Override
//    public String getName() {
//        return name;
//    }
//
//    @Override
//    public Object getPrincipal() {
//        return name;
//    }
//
//    @Override
//    public boolean isAuthenticated() {
//        return authenticated;
//    }
//
//    @Override
//    public void setAuthenticated(boolean authenticated) throws IllegalArgumentException {
//        this.authenticated = authenticated;
//    }
//}
