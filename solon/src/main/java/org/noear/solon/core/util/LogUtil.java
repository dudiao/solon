package org.noear.solon.core.util;

import org.noear.solon.Utils;

/**
 * 日志打印小工具（仅限内部使用）
 *
 * @author noear
 * @since 1.10
 * */
public class LogUtil {
    private static LogUtil global = new LogUtil();

    public static LogUtil global() {
        return global;
    }

    /**
     * 全局打印工具（用于改改日志实现）
     */
    public static void globalSet(LogUtil instance) {
        if (instance != null) {
            LogUtil.global = instance;
        }
    }

    public void infoAsync(String content) {
        RunUtil.async(() -> {
            info(content);
        });
    }


    public void trace(String content) {
        System.out.print("[Solon] ");
        PrintUtil.purpleln(content);
    }

    public void debug(String content) {
        System.out.print("[Solon] ");
        PrintUtil.blueln(content);
    }

    public void info(String content) {
        System.out.println("[Solon] " + content);
    }

    public void warn(String content) {
        System.out.print("[Solon] ");
        PrintUtil.yellowln("WARN: " + content);
    }

    public void error(String content) {
        System.out.print("[Solon] ");
        PrintUtil.redln("ERROR: " + content);
    }
}
