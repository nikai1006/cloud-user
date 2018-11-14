package cn.net.nikai.cloud.user.controller;

import cn.net.nikai.cloud.user.dto.User;
import com.jiatui.spi.ServiceResponse;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


    /**
     * <pre>
     *     查询所有的用户信息
     * <pre>
     * @service 所有用户信息查询
     * @scene 新增用户;前端;商城业务
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
        return null;
    }

    /**
     * <pre>
     *     根据用户id查询用户信息
     * <pre>
     * @service 根据用户id查询用户信息
     * @scene 新增用户;前端;商城业务
     * @param id 用户id
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
    public ServiceResponse<User> queryUserById(@RequestParam(required = true) Long id) {
        return null;
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
        return null;
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
        return null;
    }

    /**
     * <pre>
     *     修改用户信息
     * <pre>
     * @service 修改用户信息
     * @scene 前端;商城业务
     * @param user 用户信息
     * @domain BASE
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
        return null;
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
        return null;
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
    @RequestMapping(value = "/api/test2/{myAge}", method = {RequestMethod.GET, RequestMethod.POST}, headers = {
        "name=nikai",
        "sex=man"}, produces = {
        MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE,
        MediaType.APPLICATION_RSS_XML_VALUE})
    public void testVoidAPI(@PathVariable(value = "myAge", required = false) String age,
        @RequestBody Map<String, User> userMap) {
        System.out.println(age);
    }
}
