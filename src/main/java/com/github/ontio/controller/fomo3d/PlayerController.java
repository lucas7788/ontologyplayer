package com.github.ontio.controller.fomo3d;


import com.alibaba.fastjson.JSON;
import com.github.ontio.model.fomo3d.ActivityInfo;
import com.github.ontio.model.fomo3d.InvitorInfo;
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
@RequestMapping(value = "/api/v1/ong")
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
    @RequestMapping(value = "/saveinvitor", method = RequestMethod.POST)
    @ResponseBody
    public Result saveInvitor(@RequestBody String reqParam) {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());
        InvitorInfo invitorInfo = JSON.parseObject(reqParam, InvitorInfo.class);
        Result rs = buyerHandleService.saveInvitor(invitorInfo);
        return rs;
    }
    /**
     * query the last few blocks
     *
     * @return
     */
    @RequestMapping(value = "/addactivity", method = RequestMethod.POST)
    @ResponseBody
    public Result addActivity(@RequestBody String reqParam) {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());
        ActivityInfo activityInfo = JSON.parseObject(reqParam, ActivityInfo.class);
        Result rs = buyerHandleService.addActivity(activityInfo);
        return rs;
    }

    /**
     * query the last few blocks
     *
     * @return
     */
    @RequestMapping(value = "/updateActivityIsShow/{id}/{isShow}", method = RequestMethod.GET)
    @ResponseBody
    public Result updateActivityIsShow(@PathVariable("id") int id,
                                       @PathVariable("isShow") int isShow) {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());

        Result rs = buyerHandleService.updateActivityIsShow(id, isShow);
        return rs;
    }

    /**
     * query the last few blocks
     *
     * @return
     */
    @RequestMapping(value = "/getrecentactivity", method = RequestMethod.GET)
    @ResponseBody
    public Result getActivity() {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());
        Result rs = buyerHandleService.getActivity();
        return rs;
    }


    /**
     * query the last few blocks
     *
     * @return
     */
    @RequestMapping(value = "/getinvitorbyaddress/{address}", method = RequestMethod.GET)
    @ResponseBody
    public Result getInvitorByAddress(@PathVariable("address") String address) {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());
        Result rs = buyerHandleService.getInvitorByAddress(address);
        return rs;
    }

    /**
     * query the last few blocks
     *
     * @return
     */
    @RequestMapping(value = "/gettotalbyinvitor/{invitor}", method = RequestMethod.GET)
    @ResponseBody
    public Result getTotalByInvitor(@PathVariable("invitor") String invitor) {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());
        Result rs = buyerHandleService.getTotalByInvitor(invitor);
        return rs;
    }

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
