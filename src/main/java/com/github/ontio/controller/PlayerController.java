package com.github.ontio.controller;


import com.github.ontio.paramBean.Result;
import com.github.ontio.service.impl.BuyerHandleServiceImpl;
import com.github.ontio.utils.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/api/v1/buyers")
public class PlayerController {

    private static final Logger logger = LoggerFactory.getLogger(PlayerController.class);

    private final String CLASS_NAME = this.getClass().getSimpleName();

    private static final String VERSION = "1.0";

    @Autowired
    private BuyerHandleServiceImpl buyerHandleService;

    /**
     * query the last few blocks
     *
     * @return
     */
    @RequestMapping(value = "/getmybuyrecordbypage/{buyer}/{pagesize}/{pagenumber}", method = RequestMethod.GET)
    @ResponseBody
    public Result getMyBuyRecordByPage(@PathVariable("buyer") String buyer,
                                @PathVariable("pagenumber") Integer pageNumber,
                                @PathVariable("pagesize") Integer pageSize) {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());

        Result rs = buyerHandleService.getMyBuyRecordByPage(buyer, pageSize, pageNumber);
        return rs;
    }

    /**
     * query the last few blocks
     *
     * @return
     */
    @RequestMapping(value = "/getbuyrecordbypage/{pageSize}/{pageNumber}", method = RequestMethod.GET)
    @ResponseBody
    public Result getBuyRecordByPage(@PathVariable("pageSize") int pageSize,
                                  @PathVariable("pageNumber") int pageNumber) {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());

        Result rs = buyerHandleService.getBuyRecordByPage(pageSize,pageNumber);
        return rs;
    }

    /**
     * query the last few blocks
     *
     * @return
     */
    @RequestMapping(value = "/getmywithdrawrecordbypage/{address}/{pageSize}/{pageNumber}", method = RequestMethod.GET)
    @ResponseBody
    public Result getMyBetsByPage(@PathVariable("address") String address,
                                  @PathVariable("pageSize") int pageSize,
                                  @PathVariable("pageNumber") int pageNumber) {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());

        Result rs = buyerHandleService.getMyWithdrawRecordByPage(address, pageSize, pageNumber);
        return rs;
    }

    /**
     * query the last few blocks
     *
     * @return
     */
    @RequestMapping(value = "/getwinnerbypage/{pageSize}/{pageNumber}", method = RequestMethod.GET)
    @ResponseBody
    public Result getWinnerByPage(@PathVariable("pageSize") int pageSize,
                                  @PathVariable("pageNumber") int pageNumber) {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());

        Result rs = buyerHandleService.getWinnerByPage(pageSize, pageNumber);
        return rs;
    }
}
