package cn.net.nikai.cloud.user.controller;

import cn.net.nikai.cloud.user.dto.Card;
import cn.net.nikai.cloud.user.dto.Friend;
import cn.net.nikai.cloud.user.dto.Goods;
import cn.net.nikai.cloud.user.dto.LangTypeDto;
import cn.net.nikai.cloud.user.dto.Rank;
import cn.net.nikai.cloud.user.dto.Sort;
import cn.net.nikai.cloud.user.dto.User;
import com.oeasy.base.spi.Page;
import com.oeasy.base.spi.ServiceResponse;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务发布器
 *
 * @author nikai
 * @version 1.0.0
 * @domain BASE 基础平台
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
     * @code 0 成功
     * @code 1 系统异常
     * @code 41003 参数失败
     * @code 2 操作繁忙
     * @code 42020 无效的用户备注;
     * @author 尼凯 keni@aijiatui.com
     * @return 用户信息列表
     * @atom false
     * @unignore
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
     * @version 1.6.2
     * @author 尼凯 keni@aijiatui.com
     * @code 0 成功
     * @code 1 系统异常
     * @code 41003 参数失败
     * @code 2 操作繁忙
     * @code 42020 无效的用户备注;
     * @example id 99
     * @default id 77
     * @unignore
     */
    @GetMapping(value = "/user/query", params = {"id=1", "id"}, headers = {"Origin"}, consumes = {
        MediaType.TEXT_HTML_VALUE, MediaType.TEXT_PLAIN_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    @ResponseBody
    public User queryUserById(@RequestParam(required = true, defaultValue = "88") Long id) {
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
     * @version 1.4.5
     * @author 尼凯 keni@aijiatui.com
     * @return 单个用户信息
     * @code 0 成功
     * @code 1 系统异常
     * @code 41003 参数失败
     * @code 2 操作繁忙
     * @code 42020 无效的用户备注;
     * @unignore
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
     * @version 1.3.4
     * @author nikai
     * @return 消息体
     * @code 0 成功
     * @code 1 系统异常
     * @code 41003 参数失败
     * @code 2 操作繁忙
     * @code 42020 无效的用户备注;
     * @rollback cn.net.nikai.cloud.user.controller.UserController.delUser
     * @callback cn.net.nikai.cloud.user.controller.UserController.findUser
     * @unignore
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
     * @version 1.0.1
     * @author 尼凯 keni@aijiatui.com
     * @code 0 成功
     * @code 404
     * @code 1 系统异常
     * @code 41003 参数失败
     * @code 2 操作繁忙
     * @code 42020 无效的用户备注;
     * @callback cn.net.nikai.cloud.user.controller.UserController.findUser
     * @unignore
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
     * @version 1.2.0
     * @author keni@aijiatui.com
     * @code 0 成功
     * @code 1 系统异常
     * @code 41003 参数失败
     * @code 2 操作繁忙
     * @code 42020 无效的用户备注;
     * @callback cn.net.nikai.cloud.user.controller.UserController.findUser
     * @deprecated not safe
     * @unignore
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
     * @code 0 成功
     * @code -1
     * @code 1 系统异常
     * @code 41003 参数失败
     * @code 2 操作繁忙
     * @code 42020 无效的用户备注;
     * @internal TRUE
     * @version 1.3.3
     * @unignore
     * @deprecated DEPRECATED
     */
    @RequestMapping(value = "/api/test", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
    @Deprecated
    public User testUser(@RequestParam List<User> users) {

        return null;
    }

    /**
     * 空返回泛型入参测试接口
     *
     * @service 空返回泛型入参测试接口
     * @domain BASE
     * @type COMMAND
     * @code 0 成功
     * @code -1 未知异常
     * @author keni@aijiatui.com
     * @author 尼凯 keni@aijiatui.com
     * @atom FALSE
     * @internal
     * @version 2.0.0
     * @unignore
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

    /**
     * get user map
     *
     * @service get user map
     * @version 3.1.2
     * @unignore
     */
    @PostMapping("/user-map/get")
    public Map<String, User> getUserMap() {
        return null;
    }

    /**
     * 列出用户
     *
     * @service 列出用户
     * @version 1.1.1
     * @unignore
     */
    @GetMapping("/all-users/list")
    public List<User> queryAllUsers(@RequestParam(defaultValue = "nikai") String filter) {
        log.info(filter);
        return null;
    }

    /**
     * get user map
     *
     * @service get user map
     * @version 2.1.5
     * @unignore
     */
    @PostMapping("/user-map/map")
    public HashMap<String, User> mapUsers(User user, Card card) {
        return null;
    }

    /**
     * array all users
     *
     * @return all users
     * @service array all users
     * @version 1.4.1
     * @unignore
     */
    @GetMapping("/users-all/array")
    public ArrayList<User> listAllUsers(@RequestBody User user, @RequestPart Friend friend) {
        return null;
    }

    /**
     * servlet测试
     *
     * @return 用户信息
     * @version 2.0.5
     * @unignore
     * @since servlet测试
     */
    @GetMapping("/servlet/test")
    public User createUser(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    /**
     * 获取用户数组
     *
     * @param ids 用户id集合
     * @return 获取用户数组
     * @service 获取用户数组
     * @unignore
     */
    @GetMapping("/user-array/get")
    @ResponseBody
    public User[] getUserArray(Integer[] ids) {
        return null;
    }

    /**
     * @param id
     * @return 结果
     * @version 2.8.4
     * @unignore
     */
    @PostMapping("/complex-type/got")
    public ServiceResponse<User>[] getComplexType(@RequestParam(required = false) BigInteger id) {
        return null;
    }

    /**
     * <pre>
     *   根据姓名和编号获取人员信息
     *  </pre>
     *
     * @param name 姓名
     * @param id   编号
     * @return 人员信息
     * @service 根据姓名和编号获取人员信息
     * @domain BASE
     * @author nikai
     * @version 1.0.0
     * @date 2022/11/18
     * @code 0 成功
     * @code -1
     * @code 1 系统异常
     * @code 41003 参数失败
     * @code 2 操作繁忙
     * @unignore
     * @since 1.7.5
     */
    @GetMapping("/user/{name}/{id}")
    public ServiceResponse getUserByNameAndId(@PathVariable("name") String name, @PathVariable("id") String id) {
        return null;
    }

    /**
     * 获取名字
     *
     * @return 名字
     * @version 1.9.1
     * @unignore
     */
    @GetMapping("/name/get")
    public String getName() {
        return "hello";
    }

    /**
     * 获取年龄
     *
     * @return 年龄
     * @version 3.0.2
     * @unignore
     */
    @GetMapping("/age/get")
    public Integer getAge() {
        return 18;
    }

    /**
     * 获取性别
     *
     * @return 性别
     * @version 3.4.5
     * @unignore
     */
    @GetMapping("/sex/get")
    public Boolean getSex() {
        return true;
    }

    /**
     * 获取身高
     *
     * @return 身高
     * @version 1.0.5
     * @unignore
     */
    @GetMapping("/height/get")
    public Double getHeight() {
        return 18.35;
    }

    /**
     * <pre>
     *   基本类型和包装类型测试接口
     *  </pre>
     *
     * @param typeDto 包装类型测试入参
     * @return 包装类型
     * @service 基本类型和包装类型测试接口
     * @scene 测试;
     * @type COMMAND
     * @author 尼凯 nikai.zh@ccbft.com
     * @version 1.0.0
     * @atom TRUE
     * @internal FALSE
     * @date 2023/6/29
     * @unignore
     * @since 1.0.0
     */
    @PostMapping("/lang-type/compute")
    @ResponseBody
    public LangTypeDto computeType(@RequestBody LangTypeDto typeDto) {
        return new LangTypeDto();
    }

    /**
     * <pre>
     *   测试基本类型(非包装)
     *  </pre>
     *
     * @param id 编号
     * @return 数量
     * @service 测试基本类型(非包装)
     * @scene 测试;
     * @type QUERY
     * @author 尼凯 nikai.zh@ccbft.com
     * @version 1.0.0
     * @atom TRUE
     * @min 200 1
     * @min id 0
     * @max id 1000000
     * @max 99999
     * @internal FALSE
     * @date 2023/6/29
     * @unignore
     * @since 1.0.0
     */
    @GetMapping("/num/get")
    public int getNums(@RequestParam long id) {
        return 1;
    }

    /**
     * <pre>
     *   测试基本类型(非包装)2
     *  </pre>
     *
     * @param first 姓
     * @return 体重
     * @service 测试基本类型(非包装)2
     * @scene 测试;
     * @type QUERY
     * @author 尼凯 nikai.zh@ccbft.com
     * @version 1.0.0
     * @atom TRUE
     * @internal FALSE
     * @date 2023/6/29
     * @code 0 成功
     * @code -1 未知错误
     * @example first 尼
     * @example 70.56
     * @unignore
     * @since 1.0.0
     */
    @GetMapping("/doub/get")
    public double getDouble(@RequestParam char first) {
        return 0.0;
    }

    /**
     * @return
     * @unignore
     */
    @GetMapping("/users-by-page/query")
    @ResponseBody
    public ServiceResponse<Page<User>> queryUserByPage() {
        return null;
    }

    /**
     * @return
     * @unignore
     */
    @GetMapping("/user-by-sort/find")
    @ResponseBody
    public ServiceResponse<Sort<String, User>> sortUsers() {
        return null;
    }

    /**
     * @unignore
     * @return
     */
    @GetMapping("/cards-rank/query")
    @ResponseBody
    public ServiceResponse<Rank<String, User, Card>> rankCards() {
        return null;
    }

    /**
     * 测试复杂类型及待遇context-path的tag属性
     *
     * @return
     * @context-path /goods
     */
    @GetMapping("/my-good/find")
    @ResponseBody
    public ServiceResponse<Goods> queryGoods() {
        return null;
    }

    /**
     * 多个参数顺序测试
     *
     * @param e 1
     * @param f 2
     * @param d 3
     * @param c 4
     * @param b 5
     * @param a 6
     * @unignore
     * @return
     */
    @GetMapping("/multi-param-orinal/test")
    @ResponseBody
    public ServiceResponse multiParams(@RequestParam String e, @RequestParam("x") Integer f, @RequestParam String d,
        @RequestParam Long c, @RequestParam Boolean b, @RequestHeader("TOKEN") Double a) {
        return null;
    }
}
