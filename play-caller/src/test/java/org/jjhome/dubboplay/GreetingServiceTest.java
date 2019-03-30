package org.jjhome.dubboplay;

import org.jjhome.dubboplay.api.service.GreetingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class GreetingServiceTest {

    @Resource
    private GreetingService greetingService;

    @Test
    public void testGreeting() {
        String words = greetingService.greet();
        System.out.println(words);
        assertNotNull(words);
    }


}
