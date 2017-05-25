package com.acedata.boot.util.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils {

    /* 远程连接地址 */
    private static final String ADDR = "123.206.85.204";
    /* 连接端口号*/
    private static final Integer PORT = 6379;
    /* 验证密码*/
    private static final String AUTH = "redis";
    /* 最大连接数*/
    private static final Integer MAX_ACTIVE = 1024;
    /* 最大空閑數*/
    private static final Integer MAX_IDLE = 200;
    /* 最长等待时间*/
    private static final Integer MAX_WAIT = 10000;
    /* 断链时间 */
    private static final Integer TIME_OUT = 10000;
    /*在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用；*/
    private static final boolean TEST_ON_BORROW = true;

    private static JedisPool jedisPool = null;


    /* 初始化连接池 */

    static {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxWaitMillis(MAX_WAIT);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxTotal(MAX_ACTIVE);
            config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(config, ADDR, PORT, TIME_OUT, AUTH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized static Jedis getJedis() {
        try {
            if (jedisPool != null) {
                return jedisPool.getResource();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void returnResource(final Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }


}
