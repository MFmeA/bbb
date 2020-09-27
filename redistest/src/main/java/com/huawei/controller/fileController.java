package com.huawei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Controller
public class fileController {


	@Autowired
	private RedisTemplate redisTemplate;

    @RequestMapping(value = "/result2",produces = "application/json")
    @ResponseBody
    public Map<String,Object> result2() {


        redisTemplate.boundHashOps("xitianchengyuan").put("����", "��ɮ");
        redisTemplate.boundHashOps("xitianchengyuan").put("Ա��1", "���");
        redisTemplate.boundHashOps("xitianchengyuan").put("Ա��2", "�˽�");
        redisTemplate.boundHashOps("xitianchengyuan").put("Ա��3", "ɳɮ");

        Map<String,Object> map=new HashMap<String, Object>();
        Set keys = redisTemplate.boundHashOps("xitianchengyuan").keys();
        List values = redisTemplate.boundHashOps("xitianchengyuan").values();
        Object zhuli = redisTemplate.boundHashOps("xitianchengyuan").get("Ա��1");
        map.put("keys",keys);
        map.put("values",values);
        map.put("����",zhuli);

        return map;
    }

    @RequestMapping(value = "/result1")
    @ResponseBody
    public String  result1() {
        String s="aaaa";
        return s;
    }


}
