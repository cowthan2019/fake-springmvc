package com.fvc.demo;

import com.fvc.ModelAndView;
import com.fvc.annotation.AutoWired;
import com.fvc.annotation.Controller;
import com.fvc.annotation.RequestMapping;
import com.fvc.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @AutoWired
    private HomeService homeService;


    @RequestMapping("/query/.*.json")
//	@GPResponseBody
    public ModelAndView query(HttpServletRequest request,HttpServletResponse response,
                                @RequestParam(value="name",required=false) String name,
                                @RequestParam("addr") String addr){
        //out(response,"get params name = " + name);
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("name", name);
        model.put("addr", addr);
        return new ModelAndView("first.pgml",model);
    }


    @RequestMapping("/add.json")
    public ModelAndView add(HttpServletRequest request,HttpServletResponse response){
        out(response,"this is json string");
        return null;
    }



    public void out(HttpServletResponse response,String str){
        try {
            response.getWriter().write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
