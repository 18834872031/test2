package com.example.demo.bean.exception;


/**
 * @author not_simple
 * @version 1.0
 * @date 2020/8/18 18:47
 *
 * 实现了Assert的newException方法  返回一个自定义业务异常 该异常的父类继承了runtimeException异常
 *
 */
public interface BusinessExceptionAssert extends IResponseEnum,Assert {
    @Override
    default BaseException newException(Object... args) {
        return new BusinessException(this,args);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        return null;
    }
}
