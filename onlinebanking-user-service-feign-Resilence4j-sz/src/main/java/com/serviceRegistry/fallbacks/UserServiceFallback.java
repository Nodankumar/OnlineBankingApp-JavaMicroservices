package com.serviceRegistry.fallbacks;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.serviceRegistry.entities.User;
import com.serviceRegistry.proxies.UserProxy;

@Component
public class UserServiceFallback implements UserProxy{

	@Override
    public Optional<User> getUserById(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> getUserByName(String username) {
        return Optional.empty();
    }

    @Override
    public List<User> getAllUsers() {
        return Collections.emptyList();
    }

}
