package com.ecology.springboot2lj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequestMapping("/childs")
public class SubpageController {

    /**
     * 404
     * @param map
     * @return
     */
    @RequestMapping("/404")
    public ModelAndView notFound(Map<String,Object> map){
        ModelAndView view = new ModelAndView("/index");
        view.addObject("child","my404");
        view.addObject("addr","childs/404");
        return view;
    }

    /**
     * 表格
     * @return
     */
    @RequestMapping("/tables")
    public ModelAndView tables(){
        ModelAndView view = new ModelAndView("/index");
        view.addObject("child","mytables");
        view.addObject("addr","childs/tables");
        return view;
    }

    /**
     * 日历
     * @return
     */
    @RequestMapping("/calendar")
    public ModelAndView calendar(){
        ModelAndView view = new ModelAndView("/index");
        view.addObject("child","mycalendar");
        view.addObject("addr","childs/calendar");
        return view;
    }

    /**
     * 表单
     * @return
     */
    @RequestMapping("/form")
    public ModelAndView form(){
        ModelAndView view = new ModelAndView("/index");
        view.addObject("child","myform");
        view.addObject("addr","childs/form");
        return view;
    }

    /**
     * 图表
     * @return
     */
    @RequestMapping("/chart")
    public ModelAndView chart(){
        ModelAndView view = new ModelAndView("/index");
        view.addObject("child","mychart");
        view.addObject("addr","childs/chart");
        return view;
    }

    /**
     * 文字列表
     * @return
     */
    @RequestMapping("/tableist")
    public ModelAndView tableList(){
        ModelAndView view = new ModelAndView("/index");
        view.addObject("child","mytableist");
        view.addObject("addr","childs/tableist");
        return view;
    }

    /**
     * 图文列表
     * @return
     */
    @RequestMapping("/tablelistimg")
    public ModelAndView tablelistimg(){
        ModelAndView view = new ModelAndView("/index");
        view.addObject("child","mytablelistimg");
        view.addObject("addr","childs/tablelistimg");
        return view;
    }
}
