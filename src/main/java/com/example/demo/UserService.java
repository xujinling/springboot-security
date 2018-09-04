package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

	private Logger log=LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private StuRepository stuRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("------------------------------------"+username);
		Student stu=stuRepository.getStudentBySname(username);
		if(stu==null){
			throw new UsernameNotFoundException("该用户不存在");
		}
		stu.setSpwd(encoder.encode(stu.getSpwd()));
		return stu;
	}

}
