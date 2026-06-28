package com.domain.blog_website.repository;

import com.domain.blog_website.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
    // 기본적으로 제공하는 SQL 로직을 사용할 것이기 때문에 따로 작성할 것이
    // 지금으로는 존재하지 않습니다.
}
