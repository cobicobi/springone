package net.cobicobi.springone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import net.cobicobi.springone.entity.Role;
import net.cobicobi.springone.repo.RoleRepository;

@Service("roleService")
@Repository
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	@Transactional(readOnly=true)
	public List<Role> findAll() {
		return Lists.newArrayList(roleRepository.findAll());
	}

}
