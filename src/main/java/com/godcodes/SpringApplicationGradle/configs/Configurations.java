package com.godcodes.SpringApplicationGradle.configs;

import com.godcodes.SpringApplicationGradle.models.Member;
import com.godcodes.SpringApplicationGradle.reprository.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Configuration
public class Configurations
{
    @Bean
    CommandLineRunner memberInit(MemberRepository repository)
    {
         return args -> {
             try {
                 List.of(new Member("Ataimo", "Edem", Member.Gender.MALE, "08160594893", "flexwitlex@yahoo.com",
                         LocalDate.of(1995, Month.APRIL, 25), "Igando" )).forEach(member -> {
                     Optional<Member> byEmail = repository.findByEmail(member.getEmail());
                     if (byEmail.isEmpty())
                         repository.save(member);
                 });
             } catch (Exception ex)
             {
                 ex.printStackTrace();
             }
         };
    }
}
