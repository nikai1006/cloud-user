package cn.net.nikai.cloud.user.controller.multi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping(method = {RequestMethod.GET, RequestMethod.DELETE})
public class MultiMethodController {

    /**
     * <pre>
     *     多方法测试接口
     * <pre>
     * @service 多方法测试接口
     * @scene 新增用户;前端;商城业务
     * @type QUERY
     * @code 0 成功
     * @code 1 系统异常
     * @code 41003 参数失败
     * @code 2 操作繁忙
     * @code 42020 无效的用户备注;
     * @author 尼凯 keni@aijiatui.com
     * @return 多方法测试接口
     * @atom false
     * @unignore
     */
    @RequestMapping("/multi-method0")
    public String multiMehodApi() {
        return null;
    }


    /**
     * <pre>
     *     多方法测试接口1
     * <pre>
     * @service 多方法测试接口1
     * @scene 新增用户;前端;商城业务
     * @type QUERY
     * @code 0 成功
     * @code 1 系统异常
     * @code 41003 参数失败
     * @code 2 操作繁忙
     * @code 42020 无效的用户备注;
     * @author 尼凯 keni@aijiatui.com
     * @return 多方法测试接口1
     * @atom false
     * @unignore
     */
    @RequestMapping(value = "/multi-method1", method = RequestMethod.POST)
    public String multiMehodApi1() {
        return null;
    }

    /**
     * <pre>
     *     多方法测试接口2
     * <pre>
     * @service 多方法测试接口2
     * @scene 新增用户;前端;商城业务
     * @type QUERY
     * @code 0 成功
     * @code 1 系统异常
     * @code 41003 参数失败
     * @code 2 操作繁忙
     * @code 42020 无效的用户备注;
     * @author 尼凯 keni@aijiatui.com
     * @return 多方法测试接口2
     * @atom false
     * @unignore
     */
    @RequestMapping(value = "/multi-method2", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public String multiMehodApi2() {
        return null;
    }
    /**
     * <pre>
     *     多方法测试接口3
     * <pre>
     * @service 多方法测试接口3
     * @scene 新增用户;前端;商城业务
     * @type QUERY
     * @code 0 成功
     * @code 1 系统异常
     * @code 41003 参数失败
     * @code 2 操作繁忙
     * @code 42020 无效的用户备注;
     * @author 尼凯 keni@aijiatui.com
     * @return 多方法测试接口3
     * @atom false
     * @unignore
     */
    @PostMapping("/multi-method3")
    public String multiMehodApi3() {
        return null;
    }
    /**
     * <pre>
     *     多方法测试接口4
     * <pre>
     * @service 多方法测试接口4
     * @scene 新增用户;前端;商城业务
     * @type QUERY
     * @code 0 成功
     * @code 1 系统异常
     * @code 41003 参数失败
     * @code 2 操作繁忙
     * @code 42020 无效的用户备注;
     * @author 尼凯 keni@aijiatui.com
     * @return 多方法测试接口4
     * @atom false
     * @unignore
     */
    @GetMapping("/multi-method3")
    public String multiMehodApi4() {
        return null;
    }
}
