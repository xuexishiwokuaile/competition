package com.example.competition.util;

import com.example.competition.model.User;
import org.apache.shiro.SecurityUtils;

/**
 * @author Chen Anran
 * @date 2021/3/20
 */
public class SecurityUtil {

    public static User getCurUser() {
        return (User) SecurityUtils.getSubject().getSession().getAttribute("user");
    }

    public static int getAuthority() {
        return (int) SecurityUtils.getSubject().getSession().getAttribute("authority");
    }
}
