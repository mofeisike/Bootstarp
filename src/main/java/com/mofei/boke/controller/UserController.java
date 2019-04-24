package com.mofei.boke.controller;

import com.mofei.boke.bean.User;
import com.mofei.boke.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author mofeiske
 * @Description: ${todo}
 * @Date: Create in 2019/4/23 17:03
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    //查询所有用户
    @GetMapping
    public ModelAndView list(Model model){
        model.addAttribute("userList",userRepository.listUsers());
        model.addAttribute("title","用户管理");
        return new ModelAndView("user/list","userModel",model);
    }

    //根据id查询用户
    @GetMapping("{id}")
    public ModelAndView list(@PathVariable("id") long id, Model model){
        User user = userRepository.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","查看用户");
        return new ModelAndView("user/view","userModel",model);
    }

    //获取创建表单页面
    @GetMapping("/form")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title","创建用户");
        return new ModelAndView("user/form", "userModel", model);
    }

    @PostMapping
    public ModelAndView saveOrUpdateUser(User user,Model model) {
        user = userRepository.saveOrUpdateUser(user);
        model.addAttribute("user",user);
        return new ModelAndView("redirect:/user", "userModel", model);
    }

    @GetMapping("/modify/{id}")
    public ModelAndView modify(@PathVariable("id") Long id ,Model model){
        User user = userRepository.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","修改用户");
        return new ModelAndView("user/form","userModel",model);
    }

    @GetMapping("delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        userRepository.deleteUser(id);
        return new ModelAndView("redirect:/user");
    }

}
