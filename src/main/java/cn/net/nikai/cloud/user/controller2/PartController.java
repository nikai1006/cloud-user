package cn.net.nikai.cloud.user.controller2;

import cn.net.nikai.cloud.user.dto.Card;
import cn.net.nikai.cloud.user.dto.Friend;
import cn.net.nikai.cloud.user.dto.User;
import com.oeasy.base.spi.ServiceResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 尼凯 nikai@nikai.ltd
 * @version 1.7.7
 * @unignore
 */
@RestController
@RequestMapping("/part")
public class PartController {

    /**
     * @unignore
     * @param user
     * @param card
     * @return
     */
    @PostMapping(value = "/user-map/map", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,
        MediaType.APPLICATION_FORM_URLENCODED_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public HashMap<String, User> mapUsers(User user, @RequestPart Card card) {
        return null;
    }

    /**
     * array all users
     *
     * @return all users
     * @service array all users
     * @unignore
     */
    @GetMapping("/users-all/array")
    @ApiOperation(value = "查询所有用户", notes = "查询全部用户(测试专用)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "mobile", value = "手机号码", dataType = "string", paramType = "query", example = "13802780104", required = true),
        @ApiImplicitParam(name = "user_name", value = "登录账号", dataType = "string", paramType = "query", example = "lihailin9073", required = true),
        @ApiImplicitParam(name = "password", value = "登录密码", dataType = "string", paramType = "query", example = "123456", required = true),
        @ApiImplicitParam(name = "validate_code", value = "注册验证码", dataType = "string", paramType = "query", example = "3679", required = true)
    })
    @ApiResponses({
        @ApiResponse(code = 200, message = "success", examples = @Example(@ExampleProperty(mediaType = MediaType.APPLICATION_JSON_VALUE, value = "{\"name\":\"nikai\"}"))),
        @ApiResponse(code = 404, message = "not found", examples = @Example(@ExampleProperty(mediaType = MediaType.APPLICATION_JSON_VALUE, value = "{\"name\":\"nikai\"}")))
    })
    public ArrayList<User> findAllUsers(@RequestBody User user, @RequestPart Friend friend) {
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
     * @author 尼凯 nikai@0easy.com
     * @version 1.3.0
     * @atom TRUE
     * @internal FALSE
     * @date 2019/9/30
     * @code 0 成功
     * @code -1 未知错误
     * @code 41001 入参错误
     * @code 43003 未查到相关记录
     * @since 1.0.9
     * @unignore
     */
    @GetMapping("/car-in/fuzzy")
    @ResponseBody
    public ServiceResponse<List<String>> fuzzyQuery(
        @RequestParam(required = false, defaultValue = "1234564", value = "carNo") String carNum,
        @RequestParam int matchNum,
        @RequestParam(value = "startTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date start,
        @RequestParam(value = "endTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @NotNull Date end) {
        return null;
    }

    /**
     * @param user 用户
     * @return 返回消息
     * @unignore
     */
    @GetMapping("/user-get/add")
    public String addUserByGet(User user) {
        return null;
    }


    /**
     * @param user
     * @return
     * @unignore
     */
    @ApiImplicitParams(
        {
            @ApiImplicitParam()
        }
    )
    @PostMapping("/user-post/add")
    public String addUserByPost(@ApiParam(name = "") User user) {
        return null;
    }

}
