package net.cobicobi.springone;

import java.util.List;

import net.cobicobi.springone.entity.User;
import net.cobicobi.springone.service.UserService;

import org.junit.Test;

public class UserSpringTest extends BaseSpringTest {
	@Test
	public void testFindAll() {
		UserService userService = ctx.
				getBean("userService", UserService.class);
		List<User> users = userService.findAll();
		for (User user : users) {
			System.out.println(user.getUsername());
		}
	}
}
