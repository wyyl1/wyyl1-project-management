package com.wyyl1.pm.common.util;


import java.util.function.Supplier;

/**
 * copy-zt-整个类覆盖-新增类
 * 添加原因：Preconditions 不支持可以延迟执行的函数方法；Assert 支持函数方法但可读性不好
 * 参考
 * org.springframework.util.Assert
 * com.google.common.base.Preconditions
 */
public class AssertUtils {

    private AssertUtils() {
    }

    /**
     * Assert a boolean expression, throwing an {@code IllegalArgumentException}
     * if the expression evaluates to {@code false}.
     * <pre class="code">
     * AssertUtil.isTrue(i &gt; 0, () -&gt; "The value '" + i + "' must be greater than zero");
     * </pre>
     * @param expression a boolean expression
     * @param messageSupplier a supplier for the exception message to use if the
     * assertion fails
     * @throws IllegalArgumentException if {@code expression} is {@code false}
     */
    public static void isTrue(boolean expression, Supplier<String> messageSupplier) {
        if (!expression) {
            throw new IllegalArgumentException(nullSafeGet(messageSupplier));
        }
    }

    /**
     * Assert a boolean expression, throwing an {@code IllegalArgumentException}
     * if the expression evaluates to {@code false}.
     * <pre class="code">
     * AssertUtil.checkArgument(i &gt; 0, () -&gt; "The value '" + i + "' must be greater than zero");
     * </pre>
     * @param expression a boolean expression
     * @param messageSupplier a supplier for the exception message to use if the
     * assertion fails
     * @throws IllegalArgumentException if {@code expression} is {@code false}
     */
    public static void checkArgument(boolean expression, Supplier<String> messageSupplier) {
        if (!expression) {
            throw new IllegalArgumentException(nullSafeGet(messageSupplier));
        }
    }

    private static String nullSafeGet(Supplier<String> messageSupplier) {
        return (messageSupplier != null ? messageSupplier.get() : null);
    }
}
