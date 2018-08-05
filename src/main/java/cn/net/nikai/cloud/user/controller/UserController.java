package cn.net.nikai.cloud.user.controller;

import cn.net.nikai.cloud.user.dto.User;
import cn.net.nikai.cloud.user.service.UserService;
import com.jiatui.spi.ServiceResponse;
import com.jiatui.spi.enums.ResponseErrorCodeEnum;
import com.jiatui.spi.util.JsonFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 服务发布器
 *
 * @author nikai
 * @version 1.0.0
 */
@RestController
@CrossOrigin
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * <pre>
     *     查询所有的用户信息
     * <pre>
     * @service 所有用户信息查询
     * @serviceRequestName cn.net.nikai.cloud.user.controller.UserController.queryUsers
     * @scene 新增用户;前端;商城业务
     * @domain BASE
     * @serviceType QUERY
     * @returnDataType com.jiatui.spi.ServiceResponse<java.util.List<cn.net.nikai.cloud.user.dto.User:用户>>
     * @version 1.0.0
     * @returnCode 0:成功;1:系统异常; 41003:参数失败;2:操作繁忙;42020:无效的用户备注;
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
     * @serviceRequestName cn.net.nikai.cloud.user.controller.UserController.queryOne
     * @param java.lang.Long{id:required}:用户id
     * @scene 新增用户;前端;商城业务
     * @domain BASE
     * @serviceType QUERY
     * @returnDataType com.jiatui.spi.ServiceResponse<cn.net.nikai.cloud.user.dto.User:用户信息>
     * @version 1.0.0
     * @returnCode 0:成功;1:系统异常;41003:参数失败;2:操作繁忙;42021:无效的id;
     */
    @GetMapping("/user/query")
    @ResponseBody
    public ServiceResponse<User> queryUserById(@RequestParam Long id) {
        log.info("input params: id={}", id);
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
     * @serviceRequestName cn.net.nikai.cloud.user.controller.UserController.findUser
     * @param java.lang.Long{userId:required}:用户id
     * @param java.lang.String{userName}:用户姓名
     * @scene 新增用户;前端;商城业务
     * @domain BASE
     * @serviceType QUERY
     * @returnDataType com.jiatui.spi.ServiceResponse<cn.net.nikai.cloud.user.dto.User:用户信息>:返回消息
     * @version 1.0.0
     * @returnCode 0:成功;1:系统异常;41003:参数失败;2:操作繁忙;42021:无效的id;
     */
    @GetMapping("/user/find")
    @ResponseBody
    public ServiceResponse<User> findUser(Long userId,String userName){
        log.info("input params: id={},name={}", userId,userName);
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
     * @serviceRequestName cn.net.nikai.cloud.user.controller.UserController.saveUser
     * @param cn.net.nikai.cloud.user.dto.User
     * @scene 前端;商城业务
     * @domain BASE
     * @serviceType COMMAND
     * @returnDataType com.jiatui.spi.ServiceResponse<java.lang.String>
     * @version 1.0.0
     * @returnCode 0:成功;1:系统异常;41003:参数失败;2:操作繁忙;
     */
    @PostMapping(value = "/user/add")
    @ResponseBody
    public ServiceResponse<String> saveUser(@RequestBody User user) {
        try {
            log.info("input params:{}", JsonFactory.getDateFormatGsonInstance().toJson(user));
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
     * @serviceRequestName cn.net.nikai.cloud.user.controller.UserController.updateUser
     * @param cn.net.nikai.cloud.user.dto.User
     * @scene 前端;商城业务
     * @domain BASE
     * @serviceType COMMAND
     * @returnDataType com.jiatui.spi.ServiceResponse
     * @version 1.0.0
     * @returnCode 0:成功;1:系统异常;41003:参数失败;2:操作繁忙;
     */
    @PostMapping("/user/update")
    @ResponseBody
    public ServiceResponse updateUser(@RequestBody User user) {
        try {
            log.info("input params:{}", JsonFactory.getDateFormatGsonInstance().toJson(user));
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
     * @serviceRequestName cn.net.nikai.cloud.user.controller.UserController.delUser
     * @param cn.net.nikai.cloud.user.dto.User
     * @scene 前端;商城业务
     * @domain BASE
     * @serviceType COMMAND
     * @returnDataType com.jiatui.spi.ServiceResponse
     * @version 1.0.0
     * @returnCode 0:成功;1:系统异常;41003:参数失败;2:操作繁忙;
     */
    @PostMapping("/user/delete")
    @ResponseBody
    public ServiceResponse delUser(@RequestBody User user) {
        try {
            log.info("input params:{}", JsonFactory.getDateFormatGsonInstance().toJson(user));
            userService.delete(user);
            return new ServiceResponse();
        } catch (Exception e) {
            log.error(ResponseErrorCodeEnum.SYSTEM_ERR.getMessage(), e);
            return new ServiceResponse<>(ResponseErrorCodeEnum.SYSTEM_ERR);
        }
    }
}
