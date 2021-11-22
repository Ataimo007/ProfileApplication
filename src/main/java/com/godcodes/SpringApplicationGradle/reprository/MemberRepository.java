package com.godcodes.SpringApplicationGradle.reprository;

import com.godcodes.SpringApplicationGradle.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

    Optional<Member> findByEmail(String email);
}
