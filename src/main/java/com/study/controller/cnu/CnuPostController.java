package com.study.controller.cnu;

import com.study.domain.cnu.CnuPost;
import com.study.repository.mybatis.CnuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by rokim on 2016. 5. 15..
 */
@Controller
@RequestMapping("/post")
public class CnuPostController {
    @Value("${application.security.salt}") private String securityKey;

    @Autowired
    CnuRepository cnuRepository;
    //new안했지만 실제 객체 들어있을것임. 안에있는 기능들 사용할 수 있다. 
    
    @RequestMapping("")
    public String index(Model model) {
        List<CnuPost> cnuPostList = cnuRepository.selectCnuPostList();
        model.addAttribute("cnuPostList",cnuPostList);
        //여기 
        return "post/index";
    }

    @RequestMapping("/write")
    public String write() {
        return "post/write";
    }

    @RequestMapping("/view")
    public String view() {
        return "post/view";
    }
}
