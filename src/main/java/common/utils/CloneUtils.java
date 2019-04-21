package common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * <p>Description: 深复制和浅复制工具</p>
 *
 * @author Junpengzhou
 * @version 1.0.0
 * @since 2019.04.21 10:23
 */
public class CloneUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(CloneUtils.class);

    /**
     * 基于流的方式进行深复制
     * 如何利用序列化来完成对象的拷贝呢？在内存中通过字节流的拷贝是比较容易实现的。把母对象写入到一个字节流中，再从字节流中将其读出来，
     * 这样就可以创建一个新的对象了，并且该新对象与母对象之间并不存在引用共享的问题，真正实现对象的深拷贝。
     *
     * @param obj 说明使用该工具的对象必须实现 Serializable
     * @param <T> 拷贝的类
     * @return 深复制的对象
     */
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T clone(T obj) {
        T cloneObj = null;
        ByteArrayOutputStream out = null;
        ObjectOutputStream obs = null;
        ByteArrayInputStream ios = null;
        ObjectInputStream ois = null;
        try {
            //写入字节流
            out = new ByteArrayOutputStream();
            obs = new ObjectOutputStream(out);
            obs.writeObject(obj);
            obs.close();

            //分配内存，写入原始对象，生成新对象
            ios = new ByteArrayInputStream(out.toByteArray());
            ois = new ObjectInputStream(ios);
            //返回生成的新对象
            cloneObj = (T) ois.readObject();
            ois.close();
        } catch (Exception e) {
            LOGGER.error("对象深复制出现异常", e);
        }
        return cloneObj;
    }
}
