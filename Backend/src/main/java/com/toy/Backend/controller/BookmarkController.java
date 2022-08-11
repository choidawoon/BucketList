package com.toy.Backend.controller;

import com.toy.Backend.dto.BookmarkReqDto;
import com.toy.Backend.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/bookmark")
@RequiredArgsConstructor
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @PostMapping
    public ResponseEntity registerBookmark(@RequestPart BookmarkReqDto bookmarkReqDto){
        log.info("BookmarkController registerBookmark call");

        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.CREATED;
        try {
            resultMap = bookmarkService.registerBookmark(bookmarkReqDto);
        }catch (Exception e){
            log.error(e.getMessage());
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity(resultMap, status);
    }

    @GetMapping({"{memberId}"})
    public ResponseEntity getMyBookmarkList(@PathVariable int memberId, @RequestParam(required = false, defaultValue = "최신순") String order, @RequestParam(defaultValue = "1") int page){
        log.info("BookmarkController getMyBookmarkList call");

        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.OK;

        try {
            resultMap = bookmarkService.listBookmark(order, page-1);
        }catch (Exception e){
            log.info(e.getMessage());
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity(resultMap, status);
    }

}
