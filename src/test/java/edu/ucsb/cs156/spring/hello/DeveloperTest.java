package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Yifan", Developer.getName());
    }
    
    @Test
    public void getName_returns_correct_githubId() {
        assertEquals("yifanchen729", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("f26-01", t.getName());
        assertTrue(t.getMembers().contains("Andrew"),"Team should contain Andrew");
        assertTrue(t.getMembers().contains("Christian"),"Team should contain Christian");
        assertTrue(t.getMembers().contains("Jonathan G."),"Team should contain Jonathan G.");
        assertTrue(t.getMembers().contains("Owen"),"Team should contain Owen");
        assertTrue(t.getMembers().contains("Yifan"),"Team should contain Yifan");
        assertTrue(t.getMembers().contains("Nathan"),"Team should contain Nathan");
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}