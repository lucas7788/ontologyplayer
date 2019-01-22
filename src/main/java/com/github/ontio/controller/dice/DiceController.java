package com.github.ontio.controller.dice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.ontio.model.dice.InvestRecord;
import com.github.ontio.model.dice.OpenRecord;
import com.github.ontio.model.dice.QuitRecord;
import com.github.ontio.paramBean.Result;
import com.github.ontio.service.impl.DiceHandleServiceImpl;
import com.github.ontio.utils.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/api/v1/ong")
public class DiceController {

    private static final Logger logger = LoggerFactory.getLogger(DiceController.class);

    private final String CLASS_NAME = this.getClass().getSimpleName();

    private static final String VERSION = "1.0";

    @Autowired
    private DiceHandleServiceImpl diceHandleService;


    @RequestMapping(value = "/getBetRecord/{address}/{pagesize}/{pagenumber}", method = RequestMethod.GET)
    @ResponseBody
    public Result getBetRecord(@PathVariable("address") String address,
                               @PathVariable("pagenumber") Integer pageNumber,
                               @PathVariable("pagesize") Integer pageSize) {
        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());
        Result rs = diceHandleService.getMyBetRecord(address, pageSize, pageNumber);
        return rs;
    }

    @RequestMapping(value = "/getInvestRecord/{address}/{pagesize}/{pagenumber}", method = RequestMethod.GET)
    @ResponseBody
    public Result getMyInvestRecord(@PathVariable("address") String address,
                               @PathVariable("pagenumber") Integer pageNumber,
                               @PathVariable("pagesize") Integer pageSize) {
        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());
        Result rs = diceHandleService.getMyInvestRecord(address, pageSize, pageNumber);
        return rs;
    }

    @RequestMapping(value = "/getOpenRecord/{address}/{pagesize}/{pagenumber}", method = RequestMethod.GET)
    @ResponseBody
    public Result getMyOpenRecord(@PathVariable("address") String address,
                                    @PathVariable("pagenumber") Integer pageNumber,
                                    @PathVariable("pagesize") Integer pageSize) {
        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());
        Result rs = diceHandleService.getMyOpenRecord(address, pageSize, pageNumber);
        return rs;
    }

    @RequestMapping(value = "/getQuitRecord/{address}/{pagesize}/{pagenumber}", method = RequestMethod.GET)
    @ResponseBody
    public Result getMyQuitRecord(@PathVariable("address") String address,
                                  @PathVariable("pagenumber") Integer pageNumber,
                                  @PathVariable("pagesize") Integer pageSize) {
        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());
        Result rs = diceHandleService.getMyQuitRecord(address, pageSize, pageNumber);
        return rs;
    }

    @RequestMapping(value = "/saveBetRecord", method = RequestMethod.POST)
    @ResponseBody
    public Result saveBetRecord(@RequestBody String reqParam){
        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());
        List betList = (List) JSONObject.parseObject(reqParam).get("list");
        Result rs = diceHandleService.insertBetRecord(betList);
        return rs;
    }

    @RequestMapping(value = "/saveInvestRecord", method = RequestMethod.POST)
    @ResponseBody
    public Result saveInvestRecord(@RequestBody String reqParam){
        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());
        InvestRecord investRecord = JSON.parseObject(reqParam, InvestRecord.class);
        Result rs = diceHandleService.insertInvestRecord(investRecord);
        return rs;
    }

    @RequestMapping(value = "/saveOpenRecord", method = RequestMethod.POST)
    @ResponseBody
    public Result saveOpenRecord(@RequestBody String reqParam){
        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());
        OpenRecord openRecord = JSON.parseObject(reqParam, OpenRecord.class);
        Result rs = diceHandleService.insertOpenRecord(openRecord);
        return rs;
    }


    @RequestMapping(value = "/saveQuitRecord", method = RequestMethod.POST)
    @ResponseBody
    public Result saveQuitRecord(@RequestBody String reqParam){
        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());
        QuitRecord quitRecord = JSON.parseObject(reqParam, QuitRecord.class);
        Result rs = diceHandleService.insertQuitRecord(quitRecord);
        return rs;
    }
}
