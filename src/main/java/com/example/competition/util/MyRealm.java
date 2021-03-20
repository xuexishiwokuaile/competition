//package com.example.competition.util;
//
//import com.example.competition.model.User;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class MyRealm extends AuthorizingRealm {
//    @Autowired
//    UserService userService;
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        return null;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        String username = token.getUsername();
//        if (username == null) throw new AccountException("用户名不能为空");
//        //String password = userService.findOneById(username).getPassword();
//        //if (password == null) throw new AccountException("账户错误");
//        //AuthenticationInfo info = new SimpleAuthorizationInfo(username, password, getName());
//
//        User user = userService.findOneById(username);
//        if (user != null) {
//            return new SimpleAuthenticationInfo(user.getId(), user.getPassword(), getName());
//        }
//        return null;
//    }
//}
