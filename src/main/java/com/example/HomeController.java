//package com.example;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//public class HomeController {
//    @RequestMapping("/") // root에 요청이 오면 자동으로 실행
//    public String home() {
//        System.out.println("Home");
//
//        return "board/index"; // view 이름
//        // ./WEB-INF/views/index.jsp
//    }
//
//    @RequestMapping("home") // root에 요청이 오면 자동으로 실행
//    public String home2() {
//        System.out.println("Home2");
//
//        return "board/home"; // view 이름
//        // ./WEB-INF/views/home.jsp
//    }
//
//    @RequestMapping("classlist") // root에 요청이 오면 자동으로 실행
//    public String list(Model model) {
//        System.out.println("classlist");
//        List<String> list = new ArrayList<String>();
//        list.add("실전프로젝트1");
//        list.add("컴퓨터구조2");
//        list.add("컴퓨터비전");
//        list.add("이산수학");
//
//        model.addAttribute("classlist", list);
//        String msg = "2학년 2학기 교과목 리스트";
//        model.addAttribute("title", msg);
//        return "board/list";
//        // ./WEB-INF/views/home.jsp
//    }
//}
