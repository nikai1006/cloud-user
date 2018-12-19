package cn.net.nikai.cloud.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * cloud-user cn.net.nikai.cloud.user.controller
 *
 * @author nikai
 * @Description:
 * @Date  Create in 0:04 2018/12/20
 * @Modified By:
 */
@RestController
@Api("swagger测试用controller")
public class SwaggerController {


    @GetMapping("/swagger/test1")
    @ApiOperation(value = "查询全部信息", notes = "这是查询全部信息的详细描述，测试专用，请勿调用该接口")
    public void queryAllInfo() {

    }

}
