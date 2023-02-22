package com.yomance.web.test;

import com.yomance.web.bean.page.PageQuery;
import com.yomance.web.bean.result.BusinessException;
import com.yomance.web.config.result.ResultFormat;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yomance
 * @version 1.0
 * @date 2023-02-16 21:41:34
 */
@ResultFormat
@RequestMapping("/t")
@RestController
@Slf4j
public class TestController {

    @GetMapping
    public List<User> testPageQuery(PageQuery<Where> query) {
        log.info("query: {}", query);
        log.info("where: {}", query.getWhere());
        User user = new User();
        user.setId(1611686100391424002L);
        user.setTime(LocalDateTime.now());
        List<User> list = new ArrayList<>();
        list.add(user);
        return list;
    }

    @GetMapping("/err")
    public String err() {
        throw new BusinessException("抛出异常");
    }

    @Data
    public static class Where {
        // 搜索关键字
        private String keyWords;
        // 开始时间
        private LocalDateTime startTime;
        // 结束时间
        private LocalDateTime endTime;
    }

    @Data
    public static class User {
        private Long id;
        private LocalDateTime time;
    }
}
