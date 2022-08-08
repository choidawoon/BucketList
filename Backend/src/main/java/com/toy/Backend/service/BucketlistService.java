package com.toy.Backend.service;

import com.toy.Backend.dto.BucketlistRegisterDto;
import com.toy.Backend.entity.*;
import com.toy.Backend.repository.BucketlistRepository;
import com.toy.Backend.repository.BucketlistTagRepository;
import com.toy.Backend.repository.HashtagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BucketlistService {

    @Autowired
    private BucketlistRepository bucketlistRepository;
    @Autowired
    private HashtagRepository hashtagRepository;
    @Autowired
    private BucketlistTagRepository bucketlistTagRepository;

    @Autowired
    private MemberService memberService;

    public void registerBucketlist(BucketlistRegisterDto bucketlistRegisterDto){

        //시큐리티 적용 전 임시 회원
        Member member = memberService.getMember("U001");

        Bucketlist bucketlist = bucketlistRegisterDto.toEntity(member);
        if(bucketlistRegisterDto.getType() == 1) //누적형
            bucketlist.changeCount(0);
        bucketlistRepository.save(bucketlist);

        //태그 저장
        saveHashtag(bucketlist, bucketlistRegisterDto.getTag());
    }

    public void saveHashtag(Bucketlist bucketlist, List<String> tag){
        for(String str : tag){
            System.out.println(str);

            Optional<Hashtag> tagOp = hashtagRepository.findByName(str);

            if(tagOp.isPresent())//존재하는 태그
                bucketlistTagRepository.save(new BucketlistTag(new BucketlistTagId(bucketlist, tagOp.get())));

            else{
                Hashtag newTag = Hashtag.builder().name(str).build();
                hashtagRepository.save(newTag);
                bucketlistTagRepository.save(new BucketlistTag(new BucketlistTagId(bucketlist, newTag)));
            }
        }
    }

    public void deleteHashtag(){

    }
}
