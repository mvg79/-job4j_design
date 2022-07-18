package ru.job4j.generics;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RoleStoreTest {
    @Test
    void whenAddAndFindThenRolenameIsRole1() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Role1"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("Role1");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Role1"));
        Role result = store.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindRolenameIsRole1() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Role1"));
        store.add(new Role("1", "Role2"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("Role1");
    }

    @Test
    void whenReplaceThenRolenameIsRole2() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Role1"));
        store.replace("1", new Role("1", "Role2"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("Role2");
    }

    @Test
    void whenNoReplaceRoleThenNoChangeRolename() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Role1"));
        store.replace("10", new Role("10", "Role2"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("Role1");
    }

    @Test
    void whenDeleteRooleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Role1"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteRoleThenRolenameIsRole1() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Role1"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("Role1");
    }
}