package com.toy.Backend.service;

import com.toy.Backend.dto.BucketlistDetailDto;
import com.toy.Backend.dto.BucketlistRegisterDto;
import com.toy.Backend.dto.BucketlistResDto;
import com.toy.Backend.entity.*;
import com.toy.Backend.repository.BookmarkRepository;
import com.toy.Backend.repository.BucketlistRepository;
import com.toy.Backend.repository.BucketlistTagRepository;
import com.toy.Backend.repository.HashtagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BucketlistService {

    @Autowired
    private BucketlistRepository bucketlistRepository;
    @Autowired
    private HashtagRepository hashtagRepository;
    @Autowired
    private BucketlistTagRepository bucketlistTagRepository;
    @Autowired
    private BookmarkRepository bookmarkRepository;

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

    public Map<String, Object> getBucketlist(String memberId, String type){
        Map<String, Object> resultMap = new HashMap<>();

        memberId = memberId==null? "U001" : memberId; //null일 경우 본인
        Member member = memberService.getMember(memberId);

        List<Bucketlist> bucketlistEntityList = bucketlistRepository.findByMember(member);
        List<BucketlistResDto> bucketlistResDtos;

        if(type.equals("bingo")){
            bucketlistResDtos= bucketlistEntityList.stream()
                    .filter(bucketlist -> !bucketlist.getPosition().equals(0) && !bucketlist.getStatus().equals(2))
                    .map(bucketlist -> BucketlistResDto.builder()
                            .id(bucketlist.getId())
                            .title(bucketlist.getTitle())
                            .position(bucketlist.getPosition())
                            .check(bucketlist.getStatus().equals(1))
                            .build())
                    .collect(Collectors.toList());
        }

        else if(type.equals("todo")){
            bucketlistResDtos = bucketlistEntityList.stream()
                    .filter(bucketlist -> bucketlist.getStatus().equals(0))
                    .map(bucketlist -> BucketlistResDto.builder()
                            .id(bucketlist.getId())
                            .title(bucketlist.getTitle())
                            .check(false)
                            .build())
                    .collect(Collectors.toList());
        }

        else { //completed
            bucketlistResDtos = bucketlistEntityList.stream()
                    .filter(bucketlist -> bucketlist.getStatus().equals(1))
                    .map(bucketlist -> BucketlistResDto.builder()
                            .id(bucketlist.getId())
                            .title(bucketlist.getTitle())
                            .check(true)
                            .build())
                    .collect(Collectors.toList());
        }

        resultMap.put("bucketlist", bucketlistResDtos);
        resultMap.put("message", "버킷리스트 조회 성공");

        return resultMap;
    }

    public BucketlistDetailDto getBucketlistDetail(Integer bucketlistId){

        Member member = memberService.getMember("U001");

        Bucketlist bucketlist = bucketlistRepository.findById(bucketlistId).get();

        List<String> tagList = bucketlistTagRepository.findByBucketlistTagId_Bucketlist(bucketlist)
                .stream().map(bt -> bt.getBucketlistTagId().getHashtag().getName())
                .collect(Collectors.toList());

        boolean bookmark = bookmarkRepository.findByBucketlistAndMember(bucketlist, member).isPresent();

        BucketlistDetailDto bucketlistDetailDto = BucketlistDetailDto.builder()
                .id(bucketlistId)
                .memberId(bucketlist.getMember().getId())
                .memberName(bucketlist.getMember().getName())
                .title(bucketlist.getTitle())
                .content(bucketlist.getContent())
                .type(bucketlist.getType())
                .category(bucketlist.getCategory())
                .tag(tagList)
                .totalCount(bucketlist.getTotalCount())
                .count(bucketlist.getCount())
                .position(bucketlist.getPosition())
                .check(bucketlist.getStatus().equals(1))
                .bookmark(bookmark)
                .build();

        return bucketlistDetailDto;
    }
}
