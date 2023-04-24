package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello"; // templates에 있는 hello파일로 가게함.
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){ //"name"은 ?뒤 변수 이름 String 네임은 변수의 값
        model.addAttribute("name", name); //"name"의 값 name을 hello template의 name변수에 넣어줌.
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //html없이 http body부에 이 내용을 직접 넣어주겠다.
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api") // 데이터를 내놓으라고 할때 사용
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
