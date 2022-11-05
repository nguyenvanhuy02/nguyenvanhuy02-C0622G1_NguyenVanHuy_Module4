package blog.app_blog.service.impl;

import blog.app_blog.model.MyUserDetail;
import blog.app_blog.model.User;
import blog.app_blog.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user == null ){
            throw new UsernameNotFoundException("User name " + username + "not found");
        }
        return new MyUserDetail(user);
    }
}
