package com.github.ontio.controller.ontbet;


import com.alibaba.fastjson.JSON;
import com.github.ontio.model.ontbet.BetInfo;
import com.github.ontio.paramBean.Result;
import com.github.ontio.service.impl.BetsHandleServiceImpl;
import com.github.ontio.utils.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/api/v1/bets")
public class BetsController {

    private static final Logger logger = LoggerFactory.getLogger(BetsController.class);

    private final String CLASS_NAME = this.getClass().getSimpleName();

    private static final String VERSION = "1.0";

    @Autowired
    private BetsHandleServiceImpl betsHandleService;

    /**
     * query the last few blocks
     *
     * @return
     */
    @RequestMapping(value = "/getbetsbypage/{pagesize}/{pagenumber}", method = RequestMethod.GET)
    @ResponseBody
    public Result getBetsByPage(@PathVariable("pagenumber") Integer pageNumber,
                             @PathVariable("pagesize") Integer pageSize) {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());

        Result rs = betsHandleService.getBetsByPage(pageSize, pageNumber);
        return rs;
    }

    /**
     * query the last few blocks
     *
     * @return
     */
    @RequestMapping(value = "/getmybetsbybettor/{bettor}", method = RequestMethod.GET)
    @ResponseBody
    public Result getMyBets(@PathVariable("bettor") String bettor) {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());

        Result rs = betsHandleService.getMyBetsByBettor(bettor);
        return rs;
    }

    /**
     * query the last few blocks
     *
     * @return
     */
    @RequestMapping(value = "/getmybetsbypage/{bettor}/{pageSize}/{pageNumber}", method = RequestMethod.GET)
    @ResponseBody
    public Result getMyBetsByPage(@PathVariable("bettor") String bettor, @PathVariable("pageSize") int pageSize,
                                  @PathVariable("pageNumber") int pageNumber) {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());

        Result rs = betsHandleService.getMyBetsByPage(bettor, pageSize,pageNumber);
        return rs;
    }

    /**
     * query the last few blocks
     *
     * @return
     */
    @RequestMapping(value = "/savebetinfo", method = RequestMethod.POST)
    @ResponseBody
    public Result saveBetInfo(@RequestBody String reqParam) {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());

        BetInfo betInfo = JSON.parseObject(reqParam, BetInfo.class);

        Result rs = betsHandleService.insertBetInfo(betInfo);
        return rs;
    }

    /**
     * query the last few blocks
     *
     * @return
     */
    @RequestMapping(value = "/gethugewinstopbynum/{num}", method = RequestMethod.GET)
    @ResponseBody
    public Result getHugeWins(@PathVariable("num") Integer num) {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());

        Result rs = betsHandleService.getHugeWinsTopByNum(num);
        return rs;
    }

    /**
     * query the last few blocks
     *
     * @return
     */
    @RequestMapping(value = "/savehugewin", method = RequestMethod.POST)
    @ResponseBody
    public Result saveHugeWin(@RequestBody String reqParam) {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());

        BetInfo betInfo = JSON.parseObject(reqParam, BetInfo.class);
        Result rs = betsHandleService.insertHugeWin(betInfo);
        return rs;
    }

}
