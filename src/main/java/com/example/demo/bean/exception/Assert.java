package com.example.demo.bean.exception;

/**
 * @author not_simple
 * @version 1.0
 * @date 2020/8/14 8:41
 *
 * Assert  断言接口 子类实现newException方法
 *  assertNotNull 如果对象为空抛出异常   调用newException方法  而实现接口子类需要实现newException方法
 *                返回值类型就是抛出异常的类型
 */

public interface Assert {
    /**
     * 创建异常
     * @param args
     * @return
     */
    BaseException newException(Object... args);

    /**
     * 创建异常
     * @param t
     * @param args
     * @return
     */
    BaseException newException(Throwable t, Object... args);

    /**
     * <p>断言对象<code>obj</code>非空。如果对象<code>obj</code>为空，则抛出异常
     *
     * @param obj 待判断对象
     */
    default void assertNotNull(Object obj) {
        if (obj == null) {
            throw newException(obj);
        }
    }

    /**
     * <p>断言 。如果传入bool为true，则抛出异常

     */
    default void assertIsTrue(Boolean bool) {
        if (bool ) {
            throw newException();
        }
    }


    /**
     * <p>断言对象<code>obj</code>非空。如果对象<code>obj</code>为空，则抛出异常
     * <p>异常信息<code>message</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param obj 待判断对象
     * @param args message占位符对应的参数列表
     */
    default void assertNotNull(Object obj, Object... args) {
        if (obj == null) {
            throw newException(args);
        }
    }
}
