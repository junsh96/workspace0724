package com.kh.spring.controller;

import com.kh.spring.model.vo.Member;
import com.kh.spring.service.MemberService;
import com.kh.spring.service.MemberServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//Bean에 클래스 등록하는 방법 @Component클래스를 부여
//@Controller -> @Component + Controller객체가 가질수 있는 예외처리등의 기능을 포함하는 어노테이션
@Controller
public class MemberController {
    /*
    @Autowired
    의존성 주입을 사용할때 기술하는 어노테이션
    클래스내에 필요한 객체를 직접생성하지 않고 spring컨테이너가 관리하는 객체(Bean에 등록)을 주입받아 사용할수 있게 해줌
     필드 주입방식 / 생성자 주입 방식

     private MemberService memberService = new MemberServiceImpl();
     기존 객체 직접 생성 방식
     객체간의 결합도가 높아짐.(구현체가 고정되어있어 확장/교체가 어려움)
     ->소스 코드 수정이 일어날 경우 하나하나 변경해야할 코드가 연쇄적으로 생성.

     DI(Dependency Injection) - 의존성 주입 방식
     - 객체를 직접 생성하지 않고 스프링 컨테이너가 관리하는 객체를 주입받아 쓰는 것.
     - 결압도 낮아지고 , 테스트가 용이, 관심사 분리(객체를 생성하고 사용하는 비즈니스 로직이 분리) 유지보수가 높아짐

     필드 주입 방식 - Autowired
     스프링 컨테이너가 객체를 생성 후, Autowired가 있는 필드에 의존성 주입을 해주는 방식
     장점 : 코드가 간결하다.
     단점 : 테스트가 어려움.(필드 주입 방식은 객체 생성시 의존성이 주입되지 않고  bean에서 생성 후 주입되는 방식이기 때문에
                            테스트 진행시 임의의 객체를 생성하기 어렵다.)
            불변성 보장 불가. -> 런타임에 값이 변경될수 있다.


      생성자 주입 방식
      가장 권장되는 방식으로, 생성 시점에   @Autowired이 있는 생성자를 통해  의존성을 주입하는 방식이다.
      -불변성 보장, 테스트 용이
     */

    private final MemberService memberService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public MemberController(MemberService memberService, BCryptPasswordEncoder bCryptPasswordEncoder)  {
        this.memberService = memberService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    /*
    Spring에서 클라이언트가 보낸 정보를 받는 방법

    1. HttpServletRequest를 활용해서 전달값을 가져옴.
    메서드에 매개변수로 HttpServletRequest를 작성해주면
    스프링 컨테어니가 해당 메서드를 호출할때 자동으로 매개변수를 주입해준다.
     */

//    @PostMapping("login.me")
//    public String login(HttpServletRequest request, HttpServletResponse response) {
//        String id = request.getParameter("userId");
//        String pw = request.getParameter("userPwd");
//
//        return null;
//    }

    /*
    2. @RequestParam 어노테이션을 활용하는 방법
    request.getParameter(키)로 밸류를 추출하는 역활을 대신 해주는 어노테이션
    요청 parameter의 key값과 동일하게 매개변수명을 설정해주면 RequestParam을 생략가능
     */
//    @PostMapping("login.me")
//    public String login(@RequestParam(value="userId" , defaultValue = "user01") String id, String userPwd) {
//
//        return null;
//    }
    /*
    3. 객체를 이용하는 방법 (@ModelAttribute 생략가능)
    HTML폼데이터를 객체로 받을 때 사용.
    요청시 전달 값들을 담고자하는 클랙스 타입의 객체를 만들어 준 뒤
    전달되는 키값과 매개변수 객체의 필드명을 동일하게 만들어주면 객체를 매개변수로 값을 매핑해준다.
     */
//    @PostMapping("login.me")
//    public String login(Member member) {
//        System.out.println("member"+member);
//        return null;
//    }

    /*
    요청처리 후 데이터를 담아서 응답하는 방법(포워딩 or url 재요청)
    1. Spring에서 제공하는 model객체 이용
    포워딩할 응답뷰로 전달하고자하는 데이터를 키-밸류 쌍으로 담을수 있는 영역이다.
    Model객체에 addAttribute()로 저장시 requestScope에 값을 저장
     */
//    @PostMapping("login.me")
//    public String login(@ModelAttribute Member member, Model model) {
//        System.out.println("member"+member);
//
//        model.addAttribute("memberId",member.getMemberId());
//        model.addAttribute("memberPwd",member.getMemberPwd());
//        return "index";
//    }

    /*
    2. HttpSession을 이용한 값 저장후 url 재요청
     */
//    @PostMapping("login.me")
//    public String login(@ModelAttribute Member member, HttpSession session) {
//        System.out.println("member"+member);
//
//        session.setAttribute("memberId", member.getMemberId());
//        session.setAttribute("memberPwd", member.getMemberPwd());
//
//        return "redirect:/";
//    }

    /*
    3. ModelAndView객체를 이용하는 방법. -> 데이터를 담고 리턴 형식까지 지정하는 객체
     */
//    @PostMapping("login.me")
//    public ModelAndView login(@ModelAttribute Member member, ModelAndView mv) {
//        System.out.println("member"+member);
//
//        mv.addObject("memberId", member.getMemberId());
//        mv.addObject("memberPwd", member.getMemberPwd());
//
//        //mv.setViewName("index"); // 포워딩
//        mv.setViewName("redirect/"); //url 재요청
//        return mv;
//    }

    @PostMapping("login.me")
    public ModelAndView login(String memberId, String memberPwd, HttpSession httpsession, ModelAndView mv) {
        Member loginMember = memberService.getMemberById(memberId);
        System.out.println("?"+loginMember);
        //memberPwd -> 암호화 되지 않은 pwd

        //logimMember.getMemberPwd() -> 암호화된 pwd

        //bCryptPasswordEncoder.matchs(평문 , 암호문) -> 둘이 일치하면 true 아니면 false

        if (loginMember == null) {
            mv.addObject("errMsg", "아이디를 찾을수 없습니다.");
            mv.setViewName("common/error");
            //} else if(!loginMember.getMemberPwd().equals(memberPwd)) {
        } else if (!bCryptPasswordEncoder.matches(memberPwd,loginMember.getMemberPwd())) {
            mv.addObject("errMsg","비밀번호를 확인해주세요");
            mv.setViewName("common/error");
        } else {
            httpsession.setAttribute("loginMember", loginMember);

            mv.setViewName("redirect:/");
        }

        return mv;
    }

    @GetMapping("enrollForm.me")
    public String enrollForm() {
        return "member/enrollForm";
    }

    @GetMapping("idDulpicateCheck.me")
    @ResponseBody //리턴을 뷰로 보내지 말고 HTTP응답 바디에 그대로 담아서 보내라
    public String idDulpicateCheck(String checkId) {

        int result = memberService.getMemberCountById(checkId);

        return result > 0 ? "NNNNN" : "NNNNY";
    }

    @PostMapping("insert.me")
    public String joinMember(Member member,HttpSession httpSession, Model model) {
        /*
        비밀번호를 사용자 입력 그대로 저장한다 -> 평문 -> 해킹이나 개인정보 침해 우려
        스프링 시큐리티에서 지원하는 암호화 방식을 사용해서 저장/검증
         */
        String pwd = bCryptPasswordEncoder.encode(member.getMemberPwd());
        member.setMemberPwd(pwd);
        int result = memberService.addMember(member);
        if ( result > 0) {
            httpSession.setAttribute("alertMsg","회원가입 성공");
            return "redirect:/";
        } else {
            model.addAttribute("errorMSg","회원 가입 실패");
            return "common/error";
        }

    }

    @GetMapping("/myPage.me")
    public String myPage() {
        return "member/myPage";
    }

    @GetMapping("/logout.me")
    public String logout(HttpSession  httpSession) {
        httpSession.removeAttribute("loginMember");
        return "redirect:/";
    }

    @PostMapping("/update.me")
    public String updateMember(Member member,HttpSession httpSession, Model model) {
        System.out.println(member);
        Member result = memberService.updateMember(member);

        if ( result != null) {
            httpSession.setAttribute("alertMsg","회원정보 수정 성공");
            return "redirect:/";
        } else {
            model.addAttribute("errorMSg","회원 정보 수정 실패");
            return "common/error";
        }
        

    }

    @PostMapping("/updatePwd.me")
    public String updatePwd(String updatePwd, String memberPwd,HttpSession httpSession, Model model) {
        Member loginMember = (Member)httpSession.getAttribute("loginMember");
        String memberId = loginMember.getMemberId();
        if (!memberPwd.equals(loginMember.getMemberPwd())) {
            model.addAttribute("errorMSg","비밀번호가 일치하지 않습니다.");
            return "common/error";
        }
        Member newInfo = memberService.updatePwd(memberPwd,updatePwd, memberId);

        if (newInfo != null) {
            httpSession.setAttribute("alertMsg","비밀번호 수정 성공");
            return "redirect:/";
        } else {
            model.addAttribute("errorMSg","비밀번호 수정 실패");
            return "common/error";
        }
    }

    @PostMapping("/delete.me")
    public String deleteMember(String memberPwd,HttpSession httpSession, Model model) {
        Member loginMember = (Member)httpSession.getAttribute("loginMember");
        String memberId = loginMember.getMemberId();
        if (!memberPwd.equals(loginMember.getMemberPwd())) {
            model.addAttribute("errorMSg","비밀번호가 일치하지 않습니다.");
            return "common/error";
        }

        int result = memberService.deleteMember(memberId);

        if (result > 0) {
            httpSession.setAttribute("alertMsg","회원 탈퇴 성공");
            httpSession.removeAttribute("loginMember");
            return "/";
        } else {
            model.addAttribute("errorMSg","회원 탈퇴 실패");
            return "common/error";
        }
    }


}
