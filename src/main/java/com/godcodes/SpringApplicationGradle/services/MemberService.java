package com.godcodes.SpringApplicationGradle.services;

import com.godcodes.SpringApplicationGradle.models.Member;
import com.godcodes.SpringApplicationGradle.reprository.MemberRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository userRepository;

    @Autowired
    public MemberService(MemberRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Member> getMembers()
    {
        return userRepository.findAll();
    }

    public Member getMember(Long memberId) {
        Optional<Member> member = userRepository.findById(memberId);
        if (member.isEmpty())
            throw new IllegalStateException("Email already exist");
        return member.get();
    }

    public void addMember(@NotNull Member member) {
//        Optional<Member> optionalMember = userRepository.findByEmail(member.getEmail());
//        optionalMember.ifPresent(existing -> {
//            throw new IllegalStateException("Email already exist");
//        });
        member.setId(null);
        System.out.println("The new member is " + member);
        userRepository.save(member);
    }

    public void deleteMember(Long memberId) {
        Optional<Member> optionalMember = userRepository.findById(memberId);
        optionalMember.ifPresentOrElse(userRepository::delete, () -> {
            throw new IllegalStateException(String.format("Member with ID %d doesn't Exist", memberId));
        });
    }

    public void updateMember(Long memberId, Member member) {
        Optional<Member> found = userRepository.findById(memberId);
        found.ifPresent(userRepository::save);
    }

    public void updateMemberPartial(Long memberId, Member member) {
        Optional<Member> found = userRepository.findById(memberId);
        found.ifPresent(foundMember -> {
            foundMember.update(member);
            userRepository.save(foundMember);
        });
    }
}
