package org.jjhome.dubboplay.impl;

import org.jjhome.dubboplay.api.service.GreetingService;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service("greetingService")
public class GreetingServiceImpl implements GreetingService {
    private final SecureRandom random = new SecureRandom();
    private static final String[] verbs = {"Hello", "Hi", "Goodbye"};
    private static final String[] nouns = {"World", "Universe", "Man", "There"};

    static {
        System.out.println("%%%%%%%%%%%%%initialized!");
    }

    @Override
    public String greet() {
        return String.format(
            "%s %s",
            verbs[random.nextInt(100) % verbs.length],
            nouns[random.nextInt(100) % nouns.length]
        );
    }
}
