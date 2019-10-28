package cn.net.nikai.cloud.user.controller2;

import cn.net.nikai.cloud.user.dto.Card;
import cn.net.nikai.cloud.user.dto.Friend;
import cn.net.nikai.cloud.user.dto.User;
import com.oeasy.base.spi.ServiceResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/part")
public class PartController {

    @PostMapping("/user-map/map")
    public HashMap<String, User> mapUsers(User user, @RequestPart Card card) {
        return null;
    }

    /**
     * array all users
     *
     * @return all users
     * @service array all users
     */
    @GetMapping("/users-all/array")
    public ArrayList<User> listAllUsers(@RequestBody User user, @RequestPart Friend friend) {
        return null;
    }


    /**
     * <pre>
     *   全量模糊匹配查找车辆入场信息
     *  </pre>
     *
     * @param carNum   部分车牌号码
     * @param matchNum 要匹配位数
     * @param start    开始时间,格式yyyy-MM-dd HH:mm:ss
     * @param end      结束时间，格式 yyyy-MM-dd HH:mm:ss
     * @return 模糊匹配结果列表
     * @service 全量模糊匹配查找车辆入场信息
     * @scene 停车场系统相关业务调用
     * @type QUERY
     * @author 尼凯#nikai@0easy.com
     * @version 1.0.0
     * @atom TRUE
     * @internal FALSE
     * @date 2019/9/30
     * @code 0#成功
     * @code -1#未知错误
     * @code 41001#入参错误
     * @code 43003#未查到相关记录
     * @since 1.0.0
     */
    @GetMapping("/car-in/fuzzy")
    @ResponseBody
    public ServiceResponse<List<String>> fuzzyQuery(@RequestParam String carNum, @RequestParam int matchNum,
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date start,
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date end) {
        return null;
    }

    @GetMapping("/user-get/add")
    public String addUserByGet(User user) {
        return null;
    }

    @PostMapping("/user-post/add")
    public String addUserByPost(User user) {
        return null;
    }

}
