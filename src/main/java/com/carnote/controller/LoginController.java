package com.carnote.controller;

import com.carnote.model.entity.UserInfo;
import com.carnote.model.entity.UserRole;
import com.carnote.service.UserInfoService;
import com.carnote.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    UserRoleService userRoleService;

    @Autowired
    public PasswordEncoder passwordRegistrationEncoder() {
        return new BCryptPasswordEncoder();
    }

    @RequestMapping(value = { "/login"}, method = RequestMethod.GET)
    public String loginPage(@RequestParam(value = "succ", required=false) Integer succ,
                            @RequestParam(value = "error", required=false) boolean error, Map<String, Object> map) {

        map.put("user", new UserInfo());
        map.put("succ", succ);
        map.put("error", error);
        return "login";
    }

    @RequestMapping(value="/addUser", method= RequestMethod.POST)
    public String addUser(@ModelAttribute UserInfo user) {

        try {
            userInfoService.add(new UserInfo(user.getUsername(), passwordRegistrationEncoder().encode(user.getPassword())));
            userRoleService.add(new UserRole(user.getUsername(), "USER"));
        } catch (DataIntegrityViolationException e) {
            return "redirect:/login?succ=0";
        }

        return "redirect:/login?succ=1";
    }
}
