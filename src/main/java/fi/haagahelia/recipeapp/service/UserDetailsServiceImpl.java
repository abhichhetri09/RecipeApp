package fi.haagahelia.recipeapp.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import fi.haagahelia.recipeapp.domain.User;
import fi.haagahelia.recipeapp.domain.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public UserDetailsServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> user = userRepository.findByUsername(username);
		UserBuilder builder = null;
		if (user.isPresent()) {
			User currentUser = user.get();
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.password(currentUser.getPasswordHash());
			builder.roles(currentUser.getRole());
		} else {
			throw new UsernameNotFoundException("User not found.");
		}

		return builder.build();

	}

}