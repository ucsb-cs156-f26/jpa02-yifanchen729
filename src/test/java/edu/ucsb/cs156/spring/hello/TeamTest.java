package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void getName_returns_correct_name() {
        assert (team.getName().equals("test-team"));
    }

    @Test
    public void equals_same_object_returns_true() {
        assert (team.equals(team));
    }

    @Test
    public void equals_not_same_class_returns_false() {
        assert (!team.equals(new String("sd")));
    }

    @Test
    public void equals_same_class_diff_name_returns_false() {
        Team team2 = new Team("test-team2");
        team2.addMember("Andrew");
        team2.addMember("Christian");
        team2.addMember("Jonathan G.");
        team2.addMember("Owen");
        team2.addMember("Yifan");
        team2.addMember("Nathan");
        assert (!team.equals(team2));
    }

    @Test
    public void equals_same_class_diff_member_returns_false() {
        Team team2 = new Team("test-team");
        team2.addMember("diffMember");
        assert (!team.equals(team2));
    }

    @Test
    public void equals_same_class_same_name_same_member_returns_true() {
        Team team2 = new Team("test-team");
        team2.addMember("Andrew");
        team2.addMember("Christian");
        team2.addMember("Jonathan G.");
        team2.addMember("Owen");
        team2.addMember("Yifan");
        team2.addMember("Nathan");
        assert (!team.equals(team2));
    }

    @Test
    public void same_class_same_value_hash_returns_true() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void same_class_diff_name_hash_returns_false() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo2");
        t2.addMember("bar");
        assertNotEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void same_class_diff_members_hash_returns_false() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar2");
        assertNotEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void hash_special_case() {
        Team t = new Team("specialCase");
        int result = t.hashCode();
        int expectedResult = -872928375;
        assertEquals(expectedResult, result);
    }
}
