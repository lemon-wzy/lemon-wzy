package shiro.demo.redis.cache;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 系统全局Cache接口，具体缓存方式需要实现该接口
 * @author lichi
 */
public interface IGlobalCache {

    /**
     * 指定缓存失效时间
     * @param key
     * @return
     */
    Boolean expire(String key,Long time);

    /**
     *
     * @param key 键不能为null
     * @return 时间 秒 返回0 表示永久有效
     */
    Long getExpire(String key);

    /**
     * 是否存在key
     * @param key
     * @return
     */
    Boolean hasKey(String key);

    /**
     * 删除缓存
     * @param key 可以传入一个或者多个key
     */
    void del(String... key);

    /**
     * 获取普通缓存
     * @param key
     * @return
     */
    Object get(String key);

    /**
     * 存入缓存
     * @param key
     * @param value
     * @return
     */
    Boolean set(String key, Object value);

    /**
     * 普通缓存放入并设置时间
     * @param key
     * @param value
     * @param time  时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return
     */
    Boolean set(String key, Object value, Long time);

    /**
     * 递增
     * @param key
     * @param delta 要增加几（大于0）
     * @return
     */
    Long incr(String key, Long delta);

    /**
     * 递减
     * @param key
     * @param delta
     * @return
     */
    Long decr(String key, Long delta);

    /**
     * HashGet
     * @param key 键 不能为null
     * @param item 项 不能为null
     * @return
     */
    Object hget(String key, String item);

    /**
     * 获取hashKey对应的所有键值
     * @param key
     * @return 对应多个键值
     */
    Map<Object, Object> hmget(String key);

    /**
     * HashSet
     * @param key
     * @param map 对应多个键值
     * @return
     */
    Boolean hmset(String key, Map<String, Object> map);

    /**
     * HashSet 并设置时间
     * @param key
     * @param map
     * @param time 时间(秒)
     * @return
     */
    Boolean hmset(String key, Map<String, Object> map, Long time);

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     * @param key
     * @param item 项
     * @param value
     * @return
     */
    Boolean hset(String key, String item, Object value);


    /**
     * 向一张hash表中放入数据,如果不存在将创建
     * @param key
     * @param item
     * @param value
     * @param time 时间(秒) 注意:如果已存在的hash表有时间,这里将会替换原有的时间
     * @return
     */
    Boolean hset(String key,String item, Object value, Long time);

    /**
     * 删除hash表中的值
     * @param key 不能为null
     * @param item 可以使多个 不能为null
     */
    void hdel(String key, Object... item);

    /**
     * 判断hash表中是否有该项的值
     *
     * @param key  键 不能为null
     * @param item 项 不能为null
     * @return true 存在 false不存在
     */
    boolean hHasKey(String key, String item);

    /**
     * hash递增 如果不存在,就会创建一个 并把新增后的值返回
     *
     * @param key  键
     * @param item 项
     * @param by   要增加几(大于0)
     * @return
     */
    double hincr(String key, String item, double by);

    /**
     * hash递减
     *
     * @param key  键
     * @param item 项
     * @param by   要减少记(小于0)
     * @return
     */
    double hdecr(String key, String item, double by);

    /**
     * 根据key获取Set中的所有值
     *
     * @param key 键
     * @return
     */
    Set<Object> sGet(String key);

    /**
     * 根据value从一个set中查询,是否存在
     *
     * @param key   键
     * @param value 值
     * @return true 存在 false不存在
     */
    boolean sHasKey(String key, Object value);

    /**
     * 将数据放入set缓存
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 成功个数
     */
    long sSet(String key, Object... values);

    /**
     * 将set数据放入缓存
     *
     * @param key    键
     * @param time   时间(秒)
     * @param values 值 可以是多个
     * @return 成功个数
     */
    long sSetAndTime(String key, long time, Object... values);


    /**
     * 获取set缓存的长度
     *
     * @param key 键
     * @return
     */
    long sGetSetSize(String key);

    /**
     * 移除值为value的
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 移除的个数
     */
    long setRemove(String key, Object... values);

    /**
     * 获取list缓存的内容
     *
     * @param key   键
     * @param start 开始
     * @param end   结束 0 到 -1代表所有值
     * @return
     */
    List<Object> lGet(String key, long start, long end);

    /**
     * 获取list缓存的长度
     *
     * @param key 键
     * @return
     */
    long lGetListSize(String key);

    /**
     * 通过索引 获取list中的值
     *
     * @param key   键
     * @param index 索引 index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
     * @return
     */
    Object lGetIndex(String key, long index);

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    boolean lSet(String key, Object value);

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    boolean lSet(String key, Object value, long time);

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    boolean lSetAll(String key, List<Object> value);


    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    boolean lSetAll(String key, List<Object> value, long time);

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */

    boolean rSet(String key, Object value);

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */

    boolean rSet(String key, Object value, long time);

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    boolean rSetAll(String key, List<Object> value);

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    boolean rSetAll(String key, List<Object> value, long time);

    /**
     * 根据索引修改list中的某条数据
     *
     * @param key   键
     * @param index 索引
     * @param value 值
     * @return
     */
    boolean lUpdateIndex(String key, long index, Object value);

    /**
     * 移除N个值为value
     *
     * @param key   键
     * @param count 移除多少个
     * @param value 值
     * @return 移除的个数
     */
    long lRemove(String key, long count, Object value);

    /**
     * 从redis集合中移除[start,end]之间的元素
     *
     * @param key
     * @param stard
     * @param end
     * @return
     */
    void rangeRemove(String key, Long stard, Long end);

    /**
     * 返回当前redisTemplate
     *
     * @return
     */
    RedisTemplate getRedisTemplate();


}
