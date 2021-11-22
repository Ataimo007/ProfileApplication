package com.godcodes.SpringApplicationGradle.controllers;

import com.godcodes.SpringApplicationGradle.models.Member;
import com.godcodes.SpringApplicationGradle.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/member")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService userService)
    {
        this.memberService = userService;
    }

    @GetMapping
    public List<Member> getMembers() throws ParseException {
        return memberService.getMembers();
    }

    @PutMapping
    public void addMember(@RequestBody Member member)
    {
        memberService.addMember(member);
    }

    @GetMapping( path = "{memberID}")
    public Member getMember(@PathVariable(name = "memberID") Long memberId) throws ParseException {
        return memberService.getMember(memberId);
    }

    @PatchMapping( path = "{memberID}")
    public void updateMember(@PathVariable(name = "memberID") Long memberId, @RequestBody Member member)
    {
        memberService.updateMember(memberId, member);
    }

    @PutMapping( path = "{memberID}")
    public void updateMemberPartial(@PathVariable(name = "memberID") Long memberId, @RequestBody Member member)
    {
        memberService.updateMemberPartial(memberId, member);
    }

    @DeleteMapping( path = "{memberID}")
    public void deleteMember(@PathVariable(name = "memberID") Long member)
    {
        memberService.deleteMember(member);
    }
}
