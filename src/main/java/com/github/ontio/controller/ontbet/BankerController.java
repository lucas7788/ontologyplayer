package com.github.ontio.controller.ontbet;

import com.alibaba.fastjson.JSON;
import com.github.ontio.model.ontbet.BankerInfo;
import com.github.ontio.paramBean.Result;
import com.github.ontio.service.impl.BankerHandleServiceImpl;
import com.github.ontio.utils.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/api/v1/banker")
public class BankerController {
    private static final Logger logger = LoggerFactory.getLogger(BetsController.class);

    private final String CLASS_NAME = this.getClass().getSimpleName();

    private static final String VERSION = "1.0";

    @Autowired
    private BankerHandleServiceImpl bankerHandleService;

    /**
     *
     *
     * @return
     */
    @RequestMapping(value = "/getbankerinvestbypage/{banker}/{pagesize}/{pagenumber}", method = RequestMethod.GET)
    @ResponseBody
    public Result getBankerInvestByPage(@PathVariable("banker") String banker, @PathVariable("pagenumber") Integer pageNumber,
                                @PathVariable("pagesize") Integer pageSize) {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());

        Result rs = bankerHandleService.getBankerInvestByPage(banker, pageSize, pageNumber);
        return rs;
    }

    /**
     *
     *
     * @return
     */
    @RequestMapping(value = "/getbankerwithdrawbypage/{banker}/{pagesize}/{pagenumber}", method = RequestMethod.GET)
    @ResponseBody
    public Result getBankerWithdrawByPage(@PathVariable("banker") String banker, @PathVariable("pagenumber") Integer pageNumber,
                                @PathVariable("pagesize") Integer pageSize) {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());

        Result rs = bankerHandleService.getBankerWithdrawByPage(banker,pageSize, pageNumber);
        return rs;
    }

    /**
     *
     *
     * @return
     */
    @RequestMapping(value = "/savebankerinvest", method = RequestMethod.POST)
    @ResponseBody
    public Result saveBankerInvest(@RequestBody String reqParam) {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());

        BankerInfo bankerInfo = JSON.parseObject(reqParam, BankerInfo.class);

        Result rs = bankerHandleService.insertBankerInvest(bankerInfo);
        return rs;
    }

    /**
     *
     *
     * @return
     */
    @RequestMapping(value = "/savebankerwithdraw", method = RequestMethod.POST)
    @ResponseBody
    public Result saveBankerWithdraw(@RequestBody String reqParam) {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());

        BankerInfo bankerInfo = JSON.parseObject(reqParam, BankerInfo.class);

        Result rs = bankerHandleService.insertBankerWithdraw(bankerInfo);
        return rs;
    }

}
