package cn.net.nikai.cloud.user.controller;

import cn.net.nikai.cloud.user.dto.CompanyBase;
import cn.net.nikai.cloud.user.dto.Order;
import com.jiatui.spi.ServiceResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * cloud-user cn.net.nikai.cloud.user.controller
 *
 * @author nikai
 * @Description:
 * @Date Create in 0:04 2018/12/20
 * @Modified By:
 */
@RestController
@Api("swagger测试用controller")
public class SwaggerController {


    @GetMapping("/swagger/test1")
    @ApiOperation(value = "查询全部信息", notes = "这是查询全部信息的详细描述，测试专用，请勿调用该接口")
    public void queryAllInfo(@ApiParam(value = "姓名", required = true) String name,
        @ApiParam(value = "密码", required = true) String password) {

    }


    @PostMapping("/swagger/nothing")
//    @ApiImplicitParam(value = "body类型入参")
    @ApiOperation(value = "post测试用", notes = "post测试详细说明")
    public ServiceResponse nothing(@RequestBody Order order) {
        return null;
    }


    @ApiOperation(value = "根据登录帐号获取公司的信息", notes = "联系人：肖振华")
    @PostMapping(value = {"/company/info/byloginname"})
    public CompanyBase tojson() {
        return null;
    }
}
