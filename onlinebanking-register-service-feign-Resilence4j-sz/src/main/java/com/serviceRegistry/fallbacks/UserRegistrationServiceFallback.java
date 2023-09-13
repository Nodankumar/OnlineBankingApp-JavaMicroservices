package com.serviceRegistry.fallbacks;

import org.springframework.stereotype.Component;

import com.serviceRegistry.entities.User;
import com.serviceRegistry.proxies.UserRegistrationProxy;

@Component
public class UserRegistrationServiceFallback implements UserRegistrationProxy{

    @Override
    public void addUser(User user) {
        System.err.println("Fallback: Error occurred while adding a user.");
    }

}
