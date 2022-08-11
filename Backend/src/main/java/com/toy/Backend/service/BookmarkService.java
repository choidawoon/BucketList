package com.toy.Backend.service;

import com.toy.Backend.dto.BookmarkReqDto;
import com.toy.Backend.entity.Bookmark;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface BookmarkService {
    //후기 글 등록
    Map<String, Object> registerBookmark(BookmarkReqDto bookmarkReqDto) throws Exception;
    Map<String, Object> listBookmark (String order, int page) throws Exception;
    Map<String, Object> makeListBookmark (Page<Bookmark> bookmarks) throws Exception;
}
