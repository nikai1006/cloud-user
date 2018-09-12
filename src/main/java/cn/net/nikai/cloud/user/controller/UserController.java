package cn.net.nikai.cloud.user.controller;

import cn.net.nikai.cloud.user.dto.User;
import cn.net.nikai.cloud.user.service.UserService;
import com.jiatui.spi.ServiceResponse;
import com.jiatui.spi.enums.ResponseErrorCodeEnum;
import com.jiatui.spi.util.JsonFactory;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务发布器
 *
 * @author nikai
 * @version 1.0.0
 * @domain BASE
 * @category BASE
 */
@RestController
@RequestMapping("/ai")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * <pre>
     *     查询所有的用户信息
     * <pre>
     * @service 所有用户信息查询
     * @scene 新增用户;前端;商城业务
     * @type QUERY
     * @code 0#成功
     * @code 1#系统异常
     * @code 41003#参数失败
     * @code 2#操作繁忙
     * @code 42020#无效的用户备注;
     * @author 尼凯#keni@aijiatui.com
     * @return 用户信息列表
     * @atom false
     */
    @GetMapping(value = "/all-users/query")
    @ResponseBody
    public ServiceResponse<List<User>> queryUsers() {
        try {
            List<User> users = userService.queryAll();
            return new ServiceResponse<List<User>>(users);
        } catch (Exception e) {
            log.error(ResponseErrorCodeEnum.SYSTEM_ERR.getMessage(), e);
            return new ServiceResponse<>(ResponseErrorCodeEnum.SYSTEM_ERR);
        }
    }

    /**
     * <pre>
     *     根据用户id查询用户信息
     * <pre>
     * @service 根据用户id查询用户信息
     * @scene 新增用户;前端;商城业务
     * @param id 用户id
     * @type QUERY
     * @version 1.0.0
     * @author 尼凯#keni@aijiatui.com
     * @code 0#成功
     * @code 1#系统异常
     * @code 41003#参数失败
     * @code 2#操作繁忙
     * @code 42020#无效的用户备注;
     */
    @GetMapping("/user/query")
    @ResponseBody
    public ServiceResponse<User> queryUserById(@RequestParam Long id) {
        log.info("input params# id={}", id);
        try {
            User user = userService.queryOne(id);
            return new ServiceResponse<User>(user);
        } catch (Exception e) {
            log.error(ResponseErrorCodeEnum.SYSTEM_ERR.getMessage(), e);
            return new ServiceResponse<User>(ResponseErrorCodeEnum.SYSTEM_ERR);
        }
    }

    /**
     * <pre>
     *     根据用户id和用户名查询用户信息
     * <pre>
     * @service 根据用户id和用户名查询用户信息
     * @param userId 用户id
     * @param userName 用户姓名
     * @scene 新增用户;前端;商城业务
     * @domain BASE
     * @type QUERY
     * @version 1.0.0
     * @author 尼凯#keni@aijiatui.com
     * @return 单个用户信息
     * @code 0#成功
     * @code 1#系统异常
     * @code 41003#参数失败
     * @code 2#操作繁忙
     * @code 42020#无效的用户备注;
     */
    @GetMapping("/user/find")
    @ResponseBody
    public ServiceResponse<User> findUser(@RequestParam("id") Long userId, @RequestParam String userName) {
        log.info("input params# id={},name={}", userId, userName);
        try {
            User user = userService.queryOne(userId);
            return new ServiceResponse<User>(user);
        } catch (Exception e) {
            log.error(ResponseErrorCodeEnum.SYSTEM_ERR.getMessage(), e);
            return new ServiceResponse<User>(ResponseErrorCodeEnum.SYSTEM_ERR);
        }
    }


    /**
     * <pre>
     *     新增一个用户
     * <pre>
     * @service 新增用户
     * @scene 前端;商城业务
     * @domain BASE
     * @type COMMAND
     * @version 1.0.0
     * @author nikai
     * @return 消息体
     * @code 0#成功
     * @code 1#系统异常
     * @code 41003#参数失败
     * @code 2#操作繁忙
     * @code 42020#无效的用户备注;
     * @rollback cn.net.nikai.cloud.user.controller.UserController.delUser
     * @callback cn.net.nikai.cloud.user.controller.UserController.findUser
     */
    @PostMapping(value = "/user/add")
    @ResponseBody
    public ServiceResponse<String> saveUser(@RequestBody User user) {
        try {
            log.info("input params#{}", JsonFactory.getDateFormatGsonInstance().toJson(user));
            userService.addOne(user);
            return new ServiceResponse<>("success");
        } catch (Exception e) {
            log.error(ResponseErrorCodeEnum.SYSTEM_ERR.getMessage(), e);
            return new ServiceResponse<>(ResponseErrorCodeEnum.SYSTEM_ERR);
        }
    }

    /**
     * <pre>
     *     修改用户信息
     * <pre>
     * @service 修改用户信息
     * @scene 前端;商城业务
     * @param user 用户信息
     * @domain BASE
     * @type COMMAND
     * @version 1.0.0
     * @author 尼凯#keni@aijiatui.com
     * @code 0#成功
     * @code 404
     * @code 1#系统异常
     * @code 41003#参数失败
     * @code 2#操作繁忙
     * @code 42020#无效的用户备注;
     * @callback cn.net.nikai.cloud.user.controller.UserController.findUser
     */
    @PostMapping("/user/update")
    @ResponseBody
    public ServiceResponse updateUser(@RequestBody User user) {
        try {
            log.info("input params#{}", JsonFactory.getDateFormatGsonInstance().toJson(user));
            userService.update(user);
            return new ServiceResponse();
        } catch (Exception e) {
            log.error(ResponseErrorCodeEnum.SYSTEM_ERR.getMessage(), e);
            return new ServiceResponse(ResponseErrorCodeEnum.SYSTEM_ERR);
        }
    }

    /**
     * <pre>
     *     删除用户
     * <pre>
     * @service 删除用户
     * @scene 前端;商城业务
     * @param user 用户基本信息
     * @domain BASE
     * @type COMMAND
     * @version 1.0.0
     * @author keni@aijiatui.com
     * @code 0#成功
     * @code 1#系统异常
     * @code 41003#参数失败
     * @code 2#操作繁忙
     * @code 42020#无效的用户备注;
     * @callback cn.net.nikai.cloud.user.controller.UserController.findUser
     * @deprecated not safe
     */
    @PostMapping("/user/delete")
    @ResponseBody
    public ServiceResponse delUser(@RequestBody User user) {
        try {
            log.info("input params#{}", JsonFactory.getDateFormatGsonInstance().toJson(user));
            userService.delete(user);
            return new ServiceResponse();
        } catch (Exception e) {
            log.error(ResponseErrorCodeEnum.SYSTEM_ERR.getMessage(), e);
            return new ServiceResponse<>(ResponseErrorCodeEnum.SYSTEM_ERR);
        }
    }

    /**
     * 泛型入参测试接口
     *
     * @param users 用户列表
     * @service 泛型入参测试接口
     * @domain BASE
     * @type COMMAND
     * @author keni@aijiatui.com
     * @author 尼凯
     * @code 0#成功
     * @code -1
     * @code 1#系统异常
     * @code 41003#参数失败
     * @code 2#操作繁忙
     * @code 42020#无效的用户备注;
     * @internal TRUE
     * @deprecated DEPRECATED
     */
    @RequestMapping(value = "/api/test", method = RequestMethod.GET)
    public User testUser(@RequestParam List<User> users) {

        return null;
    }

    /**
     * 空返回泛型入参测试接口
     *
     * @service 空返回泛型入参测试接口
     * @domain BASE
     * @type COMMAND
     * @code 0#成功
     * @code -1#未知异常
     * @author keni@aijiatui.com
     * @author 尼凯#keni@aijiatui.com
     * @atom FALSE
     * @internal
     * @deprecated DEPRECATED
     */
    @RequestMapping(value = "/api/test2", method = {RequestMethod.GET, RequestMethod.POST}, headers = {"name=nikai",
        "sex=man"}, produces = {
        MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE,
        MediaType.APPLICATION_RSS_XML_VALUE})
    public void testVoidAPI(@RequestBody Map<String, User> userMap) {

    }
}
