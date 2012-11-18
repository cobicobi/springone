package net.cobicobi.springone.service;

import java.util.List;

import net.cobicobi.springone.entity.User;

public interface UserService {
	public List<User> findAll();
	public User findById(Long id);
	public User save(User user);
}
