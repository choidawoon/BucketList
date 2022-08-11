package com.toy.Backend.service.Impl;

import com.toy.Backend.dto.BookmarkReqDto;
import com.toy.Backend.dto.ListBookmarkResDto;
import com.toy.Backend.entity.Bookmark;
import com.toy.Backend.entity.Bucketlist;
import com.toy.Backend.entity.Member;
import com.toy.Backend.enumClass.Order;
import com.toy.Backend.repository.BookmarkRepository;
import com.toy.Backend.repository.BucketlistRepository;
import com.toy.Backend.repository.MemberRepository;
import com.toy.Backend.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class bookmarkServiceImpl implements BookmarkService {

    private final BookmarkRepository bookmarkRepository;
    private final MemberRepository memberRepository;
    private final BucketlistRepository bucketlistRepository;

    @Override
    public Map<String, Object> registerBookmark(BookmarkReqDto bookmarkReqDto) throws Exception {
        log.info("BookmarkService registerBookmark call");

        Map<String, Object> resultMap = new HashMap<>();

        Optional<Bucketlist> bucketlist = bucketlistRepository.findById(bookmarkReqDto.getBucketlistId());
        Optional<Member> member = memberRepository.findById(bookmarkReqDto.getMemberId());

        Bookmark bookmark = Bookmark.builder()
                .bucketlist(bucketlist.get())
                .member(member.get())
                .build();

        bookmarkRepository.save(bookmark);

        resultMap.put("message", "성공");
        resultMap.put("bookmarkId", bookmark.getId());

        return resultMap;
    }

    @Override
    public Map<String, Object> listBookmark(String order, int page) throws Exception {
        log.info("BookmarkService listbookmark");

        Sort sort = getOrder(order);
        Page<Bookmark> bookmarks;
        bookmarks = bookmarkRepository.findAll(PageRequest.of(page,10,sort));

        return makeListBookmark(bookmarks);
    }

    @Override
    public Map<String, Object> makeListBookmark(Page<Bookmark> bookmarks) throws Exception {
        log.info("BookmarkService makerListBookmark call");

        Map<String, Object> resultMap = new HashMap<>();

        if(bookmarks.isEmpty()){
            resultMap.put("message", "게시글 없음");
            return resultMap;
        }

        List<ListBookmarkResDto> list = new ArrayList<>();

        for(Bookmark bookmark : bookmarks){

            ListBookmarkResDto listBookmarkResDto = ListBookmarkResDto.builder()
                    .id(bookmark.getId())
                    .bucketlistId(bookmark.getBucketlist().getId())
                    .memberId(bookmark.getMember().getId())
                    .build();

            list.add(listBookmarkResDto);
        }

        resultMap.put("listBookmark", list);
        resultMap.put("totalPage", bookmarks.getTotalPages());
        resultMap.put("message", "성공");
        return resultMap;
    }

    public Sort getOrder(String order){
        if(order.equals(Order.최신순.toString())) {return  Sort.by("id").descending();}
        else{return Sort.by("id").ascending();}
    }
}
