package cn.net.nikai.cloud.user.controller;

import cn.net.nikai.cloud.user.dto.BusinessDto;
import cn.net.nikai.cloud.user.dto.BusinessNodeDto;
import cn.net.nikai.cloud.user.dto.TaskDto;
import com.oeasy.base.spi.ServiceResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <pre>
 *     任务服务
 * </pre>
 *
 * @author nikai
 * @version 1.0.0
 * @date 2023/2/28
 * @domain WORKFLOW 工作流
 * @since 1.0.0
 */
@RestController
public class TaskController {

    /**
     * <pre>
     *   查询任务
     *  </pre>
     *
     * @param id 任务ID
     * @return 目标任务
     * @author nikai
     * @version 1.0.6
     * @date 2023/2/28
     * @since 1.6.0
     */
    @GetMapping("/task/query")
    @ResponseBody
    public TaskDto queryTask(String id) {
        return new TaskDto();
    }

    /**
     * <pre>
     *   创建新任务
     *  </pre>
     *
     * @param task 新任务
     * @return 创建结果
     * @author nikai
     * @version 1.8.0
     * @date 2023/2/28
     * @code 0 成功
     * @code 1 系统异常
     * @code 41003 参数失败
     * @code 2 操作繁忙
     * @code 42020 无效的用户备注;
     * @atom true
     * @since 4.0.7
     */
    @PostMapping("/task/create")
    @ResponseBody
    public ServiceResponse addTask(@RequestBody TaskDto task) {
        return new ServiceResponse();
    }

    /**
     * <pre>
     *   根据ID查询业务
     *  </pre>
     *
     * @param id 业务编号
     * @return 目标业务
     * @service 查询业务详情
     * @author nikai
     * @version 1.7.0
     * @date 2023/2/28
     * @scene 新增用户;前端;商城业务
     * @code 0 成功
     * @code 1 系统异常
     * @code 41003 参数失败
     * @code 2 操作繁忙
     * @code 42020 无效的用户备注;
     * @atom true
     * @since 2.0.6
     */
    @GetMapping("/business/query-by-id")
    @ResponseBody
    public ServiceResponse<BusinessDto> findBusinessDto(@RequestParam Integer id) {
        return new ServiceResponse<BusinessDto>();
    }

    /**
     * <pre>
     * 新增业务
     *  </pre>
     *
     * @param businessDto 业务
     * @return 操作结果
     * @author nikai
     * @version 2.0.6
     * @date 2023/2/28
     * @code 0 成功
     * @code 1 系统异常
     * @code 41003 参数失败
     * @code 2 操作繁忙
     * @code 42020 无效的用户备注;
     * @atom true
     * @since 3.0.0
     */
    @PostMapping("/business/add")
    @ResponseBody
    public ServiceResponse addBusiness(@RequestBody BusinessDto businessDto) {
        return new ServiceResponse();
    }

    /**
     * <pre>
     * 创建业务节点
     *  </pre>
     *
     * @param businessNodeDto 业务节点
     * @return 操作结果
     * @author nikai
     * @version 1.4.0
     * @date 2023/2/28
     * @code 0 成功
     * @code 1 系统异常
     * @code 41003 参数失败
     * @code 2 操作繁忙
     * @code 42020 无效的用户备注;
     * @atom true
     * @since 1.0.0
     */
    @PostMapping("/buniess-node/create")
    @ResponseBody
    public ServiceResponse addBusinessNode(@RequestBody BusinessNodeDto businessNodeDto) {
        return new ServiceResponse();
    }

    /**
     * <pre>
     * 上传单个文件RequestPart
     *  </pre>
     *
     * @param file 单个文件
     * @return 操作结果
     * @author nikai
     * @version 1.4.0
     * @date 2023/2/28
     * @code 0 成功
     * @code 1 系统异常
     * @code 41003 参数失败
     * @code 2 操作繁忙
     * @code 42020 无效的用户备注;
     * @atom true
     * @since 1.0.0
     */
    @PostMapping("/file/upload")
    @ResponseBody
//    @ApiOperation(value = "上传单个文件RequestPart", notes = "上传单个文件RequestPart描述")
    public org.and.api.base.spi.ServiceResponse<String> uploadFile(@RequestPart MultipartFile file) {
        return new org.and.api.base.spi.ServiceResponse(file.getOriginalFilename());
    }

    /**
     * <pre>
     * 上传多个文件RequestPart
     *  </pre>
     *
     * @param files 多个文件
     * @return 操作结果
     * @author nikai
     * @version 1.4.0
     * @date 2023/2/28
     * @code 0 成功
     * @code 1 系统异常
     * @code 41003 参数失败
     * @code 2 操作繁忙
     * @code 42020 无效的用户备注;
     * @atom true
     * @since 1.0.0
     */
    @PostMapping("/files/upload")
    @ResponseBody
//    @ApiOperation(value = "上传多个文件RequestPart", notes = "上传多个文件RequestPart描述")
    public org.and.api.base.spi.ServiceResponse<Integer> uploadFiles(@RequestPart MultipartFile[] files) {
        return new org.and.api.base.spi.ServiceResponse<>(files.length);
    }

    /**
     * <pre>
     * 上传单个文件RequestParam
     *  </pre>
     *
     * @param file 单个文件
     * @return 操作结果
     * @author nikai
     * @version 1.4.0
     * @date 2023/2/28
     * @code 0 成功
     * @code 1 系统异常
     * @code 41003 参数失败
     * @code 2 操作繁忙
     * @code 42020 无效的用户备注;
     * @atom true
     * @since 1.0.0
     */
    @PostMapping("/file1/upload")
    @ResponseBody
//    @ApiOperation(value = "上传单个文件RequestParam", notes = "上传单个文件RequestParam描述")
    public org.and.api.base.spi.ServiceResponse<String> uploadFile1(@RequestParam MultipartFile file) {
        return new org.and.api.base.spi.ServiceResponse(file.getOriginalFilename());
    }

    /**
     * <pre>
     * 上传多个文件RequestParam
     *  </pre>
     *
     * @param files 多个文件
     * @return 操作结果
     * @author nikai
     * @version 1.4.0
     * @date 2023/2/28
     * @code 0 成功
     * @code 1 系统异常
     * @code 41003 参数失败
     * @code 2 操作繁忙
     * @code 42020 无效的用户备注;
     * @atom true
     * @since 1.0.0
     */
    @PostMapping("/files1/upload")
    @ResponseBody
//    @ApiOperation(value = "上传多个文件RequestParam", notes = "上传多个文件RequestParam描述")
    public org.and.api.base.spi.ServiceResponse<Integer> uploadFiles1(@RequestParam MultipartFile[] files) {
        return new org.and.api.base.spi.ServiceResponse<>(files.length);
    }
}
