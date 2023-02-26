package org.noear.solon.proxy.integration;

import org.noear.solon.Utils;
import org.noear.solon.proxy.ProxyUtil;
import org.noear.solon.annotation.ProxyComponent;
import org.noear.solon.core.AopContext;
import org.noear.solon.core.Plugin;
import org.noear.solon.aspect.annotation.Dao;
import org.noear.solon.aspect.annotation.Repository;
import org.noear.solon.aspect.annotation.Service;

public class XPluginImp implements Plugin {
    @Override
    public void start(AopContext context) {
        context.beanBuilderAdd(ProxyComponent.class, (clz, bw, anno) -> {
            String beanName = Utils.annoAlias(anno.value(), anno.name());

            ProxyUtil.binding(bw, beanName, anno.typed());
        });

        //@deprecated 2.2
        context.beanBuilderAdd(Dao.class, (clz, bw, anno) -> {
            String beanName = Utils.annoAlias(anno.value(), anno.name());

            ProxyUtil.binding(bw, beanName, anno.typed());
        });

        //@deprecated 2.2
        context.beanBuilderAdd(Service.class, (clz, bw, anno) -> {
            String beanName = Utils.annoAlias(anno.value(), anno.name());

            ProxyUtil.binding(bw, beanName, anno.typed());
        });

        //@deprecated 2.2
        context.beanBuilderAdd(Repository.class, (clz, bw, anno) -> {
            String beanName = Utils.annoAlias(anno.value(), anno.name());

            ProxyUtil.binding(bw, beanName, anno.typed());
        });
    }
}
