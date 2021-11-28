package study.springBasic.controller;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import study.springBasic.service.MemberService;

@Controller
public class StudyController {

    private final MemberService memberService;

    @Autowired
    public StudyController(MemberService memberService){
        this.memberService = memberService;
    }

//    thymeleaf 템플릿 확인
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!");
        return "hello";
    }

//    동적 content 확인
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

//    ReponseBody 확인
    @ResponseBody
    @GetMapping("hello-string")
    public String helloString(@RequestParam("data") String data){
        return "hello " + data;
    }

//    ResponsBody 객체 반환
    @ResponseBody
    @GetMapping("hello-api")
    public Hello helloApi(@RequestParam("data") String data){
        Hello hello = new Hello();
        hello.setName(data);

        return hello;
    }

    @Data
    static class Hello {
        private String name;
    }
}

