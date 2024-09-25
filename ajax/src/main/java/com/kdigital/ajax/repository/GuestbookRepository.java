package com.kdigital.ajax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kdigital.ajax.entity.GuestbookEntity;
@Repository
public interface GuestbookRepository extends JpaRepository<GuestbookEntity, Long> {
    
    // 두개 이상의 조건으로 삭제할 때
    void deleteBySeqAndPwd(Long seq, String pwd);

}
