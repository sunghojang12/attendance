package com.jg.attendance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity // 해당 파일로 시큐리티를 활성화(SecurityConfig.java)
@Configuration // IoC에 등록
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder encode() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable(); // csrf : 정상적인 접근인지 확인 -> 일단 비활성화
        http.authorizeRequests()
                .antMatchers("/member/admin").authenticated()  // 이런 주소로 시작하게 되면 인증이 필요해
                .anyRequest().permitAll() // 그게 아닌 모든 요청은 허용하겠다.
                .and()
                .formLogin()
                .loginPage("/auth/signin") // 위의 인증이 필요한 요청이 왔을 때는 "/auth/signin" 요청으로 가게 하겠다.  // get 방식
                .loginProcessingUrl("/auth/signin")   // 로그인 요청을 post 방식으로 하면 얘가 낚아챔(스프링 시큐리티가 로그인 프로세스 진행// post 방식
                .defaultSuccessUrl("/");   // 정상적으로 처리가 된다면 "/" 요청으로 가게 하겠다.
    }
}
