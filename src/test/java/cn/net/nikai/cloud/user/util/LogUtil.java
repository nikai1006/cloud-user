package cn.net.nikai.cloud.user.util;

import org.slf4j.Logger;

/**
 * <pre>
 *     日志工具
 *     该工具主要用来打印在单元测试中经常需要打印的一些类似的日志内容
 * </pre>
 *
 * @author nikai
 * @version 1.0.0 2017/10/19 17:28
 */
public class LogUtil {

    /**
     * 日志打印器
     */
    private Logger logger;

    /**
     * 目标测试类
     */
    private Class clazz;

    /**
     * @param logger
     * @param clazz
     */
    public LogUtil(Logger logger, Class clazz) {
        this.logger = logger;
        this.clazz = clazz;
    }

    /**
     * debug 日记打印测试的方法全量路径
     *
     * @param methodName
     *     目标方法名
     */
    public <T extends Object> void debug(String methodName) {
        if (null == logger || null == clazz) {
            return;
        }
        logger.debug("Test [{}] method:[{}]", clazz.getName(), methodName);

    }

    /**
     * info 日记打印测试的方法全量路径
     *
     * @param methodName
     *     目标方法名
     */
    public void info(String methodName) {
        if (null == logger || null == clazz) {
            return;
        }
        logger.info("Test [{}] method:[{}]", clazz.getName(), methodName);
    }

    /**
     * warn 日记打印测试的方法全量路径
     *
     * @param methodName
     *     目标方法名
     */
    public void warn(String methodName) {
        if (null == logger || null == clazz) {
            return;
        }
        logger.warn("Test [{}] method:[{}]", clazz.getName(), methodName);
    }

    /**
     * trace 日记打印测试的方法全量路径
     *
     * @param methodName
     *     目标方法名
     */
    public void trace(String methodName) {
        if (null == logger || null == clazz) {
            return;
        }
        logger.trace("Test [{}] method:[{}]", clazz.getName(), methodName);
    }

    /**
     * error 日记打印测试的方法全量路径
     *
     * @param methodName
     *     目标方法名
     */
    public void error(String methodName) {
        logger.error("Test [{}] method:[{}]", clazz.getName(), methodName);
    }
}
