package com.kdigital.ajax.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kdigital.ajax.dto.GuestbookDTO;
import com.kdigital.ajax.entity.GuestbookEntity;
import com.kdigital.ajax.repository.GuestbookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GuestbookService {
   
   final GuestbookRepository repository;

   /**
    * 방명록의 모든 글을 조회
    * @return
    */
   public List<GuestbookDTO> selectAll() {
	   List<GuestbookDTO> list = new ArrayList<>();
	   List<GuestbookEntity> guestEntity = repository.findAll();

	   guestEntity.forEach((entity) -> 
	       list.add(GuestbookDTO.toDTO(entity)));

	   return list;
   }
   /**
    * 방명록의 모든 코드를 조회
    * @return
    */
   public List<GuestbookDTO> retrieveAll() {
	   List<GuestbookDTO> list = new ArrayList<>();
	   List<GuestbookEntity> guestEntity = repository.findAll(Sort.by(Sort.Direction.DESC,"seq"()));

    entity.forEach((e) -> list.add(GuestbookDTO.toDTO(e))));

	   return list;
   }

   /*
   DB 에서 글 삭제
   */
  public void deleteGuestbook(Long seq){
    repository.deleteById(seq);
  }
}
