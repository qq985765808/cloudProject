package com.wupeng.cloud.redis.server8558.service;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis公共服务接口
 * @author Administrator
 * @date 2020-04-12
 */
@Service
public class RedisService {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    public void set(String key, Object value) {
        //更改在redis里面查看key编码问题
        RedisSerializer redisSerializer =new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
        vo.set(key, value);
    }



    /**
     * 设置过期时间<br>
     *  timeout:设置多少秒,unit是时间单位（年月日时分秒，具体可看此类）
     * @param key
     * @param value
     * @param timeout
     * @param unit
     *
     * */
    public void set(String key, Object value, Long timeout, TimeUnit unit){
        //更改在redis里面查看key编码问题
        RedisSerializer redisSerializer =new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        //redisTemplate.opsForValue().set("key","value",5l,TimeUnit.SECONDS);
        redisTemplate.opsForValue().set(key,value,timeout,unit);
    }

    /**
     *
     * @author Administrator
     * @date 2020-04-15
     * @param key
     * @return
     */
    public Object get(String key) {
        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
        return vo.get(key);
    }

    /**
     *  获取key键对应的值
     * */
    public Long getSize(String key){
        return  redisTemplate.opsForValue().size(key);
    }


    /**
     * 新增hashMap值
     * */
    public  void put(String key,Object hashKey,Object value){
        //更改在redis里面查看key编码问题
        RedisSerializer redisSerializer =new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        hashOperations.put(key,hashKey,value);
    }

    /**
     * 以map集合的形式添加键值对
     * @author Administrator
     * @date 2020-04-15
     * @param key
     * @param map
     * @return
     */
    public void putAll(String key,  Map<? extends Object,? extends Object> map){
        //更改在redis里面查看key编码问题
        RedisSerializer redisSerializer =new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.opsForHash().putAll(key,map);
    }

    /**
     * 删除变量中的键值对，可以传入多个参数，删除多个键值对
     * @author Administrator
     * @date 2020-04-15
     * @param key
     * @param hashKeys
     * @return
     */
    public  void delete(String key,Object... hashKeys){
        redisTemplate.opsForHash().delete(key,hashKeys);
    }

    /**
     * 获取指定key中的hashMap值
     * @author Administrator
     * @date 2020-04-15
     * @param key
     * @return
     */
    public  Object values(String key){
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        return  hashOperations.values(key);
    }

    /**
     * 获取key中的键值对
     * @author Administrator
     * @date 2020-04-15
     * @param key
     * @return
     */
    public  Object entries(String key){
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        return  hashOperations.entries(key);
    }


    /**
     * 获取key键对应的值
     * @author Administrator
     * @date 2020-04-15
     * @param key
     * @param hashKey
     * @return
     */
    public  Object get(String key,Object hashKey){
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        return  hashOperations.hasKey(key,hashKey);
    }

    /**
     * 获取key键获取长度（hash）
     * @author Administrator
     * @date 2020-04-15
     * @param key
     * @return
     */
    public Long hsize(String key){
        return redisTemplate.opsForHash().size(key);
    }

    /**
     * 过期锁
     * @param key
     * @param timeout
     * @param unit
     * */
    public boolean expire(String key, Long timeout, TimeUnit unit){
        return redisTemplate.expire(key,timeout,unit);
    }

    /**
     *添加一个元素, zset与set最大的区别就是每个元素都有一个score，因此有个排序的辅助功能;  zadd
     * @author Administrator
     * @date 2020-04-15
     * @param key
     * @param value
     * @param score
     * @return
     */
    public void add(String key, String value, double score) {
        redisTemplate.opsForZSet().add(key, value, score);
    }
     
    /**
     * 删除元素 zrem
     * @author Administrator
     * @date 2020-04-15 
     * @param key
     * @param value
     * @return
     */
    public void remove(String key, String value) {
        redisTemplate.opsForZSet().remove(key, value);
    }
    
   /**
    * 修改score</br>
    * score的增加or减少 zincrby
    * @author Administrator
    * @date 2020-04-15 
    * @param key
    * @param value
    * @param score
    * @return
    */
    public Double incrScore(String key, String value, double score) {
        return redisTemplate.opsForZSet().incrementScore(key, value, score);
    }

    /**
     * 获取value对应的score
     * @author Administrator
     * @date 2020-04-15 
     * @param key
     * @param value
     * @return
     */
    public Double score(String key, String value) {
        return redisTemplate.opsForZSet().score(key, value);
    }

    /**
     * 获取value在zset中的排名  zrank
     * @author Administrator
     * @date 2020-04-15 
     * @param key
     * @param value
     * @return
     */
    public Long rank(String key, String value) {
        return redisTemplate.opsForZSet().rank(key, value);
    }

    /**
     * 返回集合的长度(zset)
     * @author Administrator
     * @date 2020-04-15 
     * @param key
     * @return
     */
    public Long zsize(String key) {
        return redisTemplate.opsForZSet().zCard(key);
    }

    /**
     * 查询集合中指定顺序的值， 0 -1 表示获取全部的集合内容  zrange</br>
     * 返回有序的集合，score小的在前面
     * @author Administrator
     * @date 2020-04-15 
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<Object> range(String key, int start, int end) {
        return redisTemplate.opsForZSet().range(key, start, end);
    }

    /**
     * 查询集合中指定顺序的值和score，0, -1 表示获取全部的集合内容
     * @author Administrator
     * @date 2020-04-15
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<ZSetOperations.TypedTuple<Object>> rangeWithScore(String key, int start, int end) {
        return redisTemplate.opsForZSet().rangeWithScores(key, start, end);
    }

    /**
     * 查询集合中指定顺序的值  zrevrange</br>
     * 返回有序的集合中，score大的在前面
     * @author Administrator
     * @date 2020-04-15
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<Object> revRange(String key, int start, int end) {
        return redisTemplate.opsForZSet().reverseRange(key, start, end);
    }

    /**
     * 根据score的值，来获取满足条件的集合  zrangebyscore
     * @author Administrator
     * @date 2020-04-15 
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Set<Object> sortRange(String key, int min, int max) {
        return redisTemplate.opsForZSet().rangeByScore(key, min, max);
    }


}
