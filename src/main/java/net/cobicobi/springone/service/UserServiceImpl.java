package net.cobicobi.springone.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import net.cobicobi.springone.entity.User;
import net.cobicobi.springone.repo.UserRepository;

@Service("userService")
@Repository
@Transactional
public class UserServiceImpl implements UserService {

	private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional(readOnly=true)
	public List<User> findAll() {
		logger.debug("Finding all contact");
		return Lists.newArrayList(userRepository.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public User findById(Long id) {
		logger.debug("Finding user #" + id);
		return userRepository.findOne(id);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

}
