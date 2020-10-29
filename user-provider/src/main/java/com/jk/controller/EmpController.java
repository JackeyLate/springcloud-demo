package com.jk.controller;

import com.jk.entity.EmpEntity;
import com.jk.service.EmpService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class EmpController {

    @Resource
    private EmpService empService;


    @RequestMapping("/find")
    public String find() {
        return "zuul请求成功";
    }


    /**
     * 查询
     *
     * @return
     */
    @RequestMapping("emp/findAll")
    public List<EmpEntity> findAll(@RequestBody EmpEntity user){
        List<EmpEntity> list = empService.findAll(user);
        return list;
    }

    /**
     * 新增+修改
     * @param user
     */
    @RequestMapping("emp/saveUser")
    public void addUser(@RequestBody EmpEntity user){

        if(user.getUserId()!=null){
            empService.updUser(user);
        }else{
            empService.addUser(user);
        }


    }

    /**
     * 回显
     * @param id
     * @return
     */
    @RequestMapping("emp/HxUser")
    public EmpEntity HxUser(@RequestParam Integer id){
        return empService.HxUser(id);
    }


    /**
     * 删除
     * @param id
     */
    @RequestMapping("user/delUser")
    public void delUser(@RequestParam Integer id){
        empService.delUser(id);
    }


}
