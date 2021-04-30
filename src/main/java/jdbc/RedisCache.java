package jdbc;

import redis.clients.jedis.Jedis;

/**
 * 缓存击穿:缓存中没有但是数据库中有，当缓存存在时间失效时，高并发情形下，数据库压力陡增
 * 缓存穿透:缓存和数据库都没有的数据，用户不断请求不存在key时
 * 缓存雪崩:
 */
public class RedisCache {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //设置 redis 字符串数据
        jedis.set("runoobkey", "www.runoob.com");
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));
        jedis.expire("name", 20);
        jedis.get("name");
    }
}
