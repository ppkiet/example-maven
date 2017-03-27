/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kietpp.maven.controller;


import com.kietpp.maven.controller.DAO.User_DAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.addAttribute("name", "sdasda");
        return "index";
    }

    @RequestMapping(value = "/table", method = RequestMethod.GET)
    public String table() {
        return "table";
    }

    @RequestMapping("send")
    public String Send(ModelMap model, @RequestParam("username") String username, @RequestParam("key") String password) {
        User_DAO dao = new User_DAO();
        if (dao.loginUser(username, password)) {
            return "succes";
        } else {
            model.addAttribute("mess", "L?I: sai m?t kh?u vui lòng nh?p l?i!");
            return "index";
        }
    }

}
