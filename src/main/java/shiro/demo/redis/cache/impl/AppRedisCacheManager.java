package shiro.demo.redis.cache.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;
import shiro.demo.redis.cache.IGlobalCache;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author lichi
 */
@Getter
@AllArgsConstructor
public final class AppRedisCacheManager implements IGlobalCache {

    private RedisTemplate<String, Object> redisTemplate;


    /**
     * 指定缓存失效时间
     *
     * @param key
     * @param time
     * @return
     */
    @Override
    public Boolean expire(String key, Long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key,time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param key 键不能为null
     * @return 时间 秒 返回0 表示永久有效
     */
    @Override
    public Long getExpire(String key) {
        return redisTemplate.getExpire(key,TimeUnit.SECONDS);
    }

    /**
     * 是否存在key
     *
     * @param key
     * @return
     */
    @Override
    public Boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除缓存
     *
     * @param key 可以传入一个或者多个key
     */
    @Override
    @SuppressWarnings("unchecked")
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete((Collection<String>) CollectionUtils.arrayToList(key));
            }
        }
    }

    /**
     * 获取普通缓存
     *
     * @param key
     * @return
     */
    @Override
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 存入缓存
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public Boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 普通缓存放入并设置时间
     *
     * @param key
     * @param value
     * @param time  时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return
     */
    @Override
    public Boolean set(String key, Object value, Long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key,value,time,TimeUnit.SECONDS);

            } else {
                redisTemplate.opsForValue().set(key,value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 递增
     *
     * @param key
     * @param delta 要增加几（大于0）
     * @return
     */
    @Override
    public Long incr(String key, Long delta) {
        if (delta <= 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, -delta);
    }

    /**
     * 递减
     *
     * @param key
     * @param delta
     * @return
     */
    @Override
    public Long decr(String key, Long delta) {
        if (delta <= 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        return redisTemplate.opsForValue().decrement(key, -delta);
    }

    /**
     * HashGet
     *
     * @param key  键 不能为null
     * @param item 项 不能为null
     * @return
     */
    @Override
    public Object hget(String key, String item) {
        return redisTemplate.opsForHash().get(key,item);
    }

    /**
     * 获取hashKey对应的所有键值
     *
     * @param key
     * @return 对应多个键值
     */
    @Override
    public Map<Object, Object> hmget(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * HashSet
     *
     * @param key
     * @param map 对应多个键值
     * @return
     */
    @Override
    public Boolean hmset(String key, Map<String, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key,map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * HashSet 并设置时间
     *
     * @param key
     * @param map
     * @param time 时间(秒)
     * @return
     */
    @Override
    public Boolean hmset(String key, Map<String, Object> map, Long time) {
        try {
            redisTemplate.opsForHash().putAll(key,map);
            if (time > 0) {
                expire(key,time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     *
     * @param key
     * @param item  项
     * @param value
     * @return
     */
    @Override
    public Boolean hset(String key, String item, Object value) {
        try {
            redisTemplate.opsForHash().put(key,item,value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     *
     * @param key
     * @param item
     * @param value
     * @param time  时间(秒) 注意:如果已存在的hash表有时间,这里将会替换原有的时间
     * @return
     */
    @Override
    public Boolean hset(String key, String item, Object value, Long time) {
        try {
            redisTemplate.opsForHash().put(key,item,value);
            if (time > 0) {
                expire(key,time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除hash表中的值
     *
     * @param key  不能为null
     * @param item 可以使多个 不能为null
     */
    @Override
    public void hdel(String key, Object... item) {
        redisTemplate.opsForHash().delete(key,item);
    }

    /**
     * 判断hash表中是否有该项的值
     *
     * @param key  键 不能为null
     * @param item 项 不能为null
     * @return true 存在 false不存在
     */
    @Override
    public boolean hHasKey(String key, String item) {
        return redisTemplate.opsForHash().hasKey(key,item);
    }

    /**
     * hash递增 如果不存在,就会创建一个 并把新增后的值返回
     *
     * @param key  键
     * @param item 项
     * @param by   要增加几(大于0)
     * @return
     */
    @Override
    public double hincr(String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key,item,by);
    }

    /**
     * hash递减
     *
     * @param key  键
     * @param item 项
     * @param by   要减少记(小于0)
     * @return
     */
    @Override
    public double hdecr(String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key,item,-by);
    }

    /**
     * 根据key获取Set中的所有值
     *
     * @param key 键
     * @return
     */
    @Override
    public Set<Object> sGet(String key) {
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据value从一个set中查询,是否存在
     *
     * @param key   键
     * @param value 值
     * @return true 存在 false不存在
     */
    @Override
    public boolean sHasKey(String key, Object value) {
        try {
            return redisTemplate.opsForSet().isMember(key,value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将数据放入set缓存
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 成功个数
     */
    @Override
    public long sSet(String key, Object... values) {
        try {
            return redisTemplate.opsForSet().add(key,values);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 将set数据放入缓存
     *
     * @param key    键
     * @param time   时间(秒)
     * @param values 值 可以是多个
     * @return 成功个数
     */
    @Override
    public long sSetAndTime(String key, long time, Object... values) {
        try {
            Long counter = redisTemplate.opsForSet().add(key, values);
            if (time > 0 ) {
                expire(key,time);
            }
            return counter;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取set缓存的长度
     *
     * @param key 键
     * @return
     */
    @Override
    public long sGetSetSize(String key) {
        try {
            return redisTemplate.opsForSet().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 移除值为value的
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 移除的个数
     */
    @Override
    public long setRemove(String key, Object... values) {
        try {
            return redisTemplate.opsForSet().remove(key,values);
        } catch ( Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取list缓存的内容
     *
     * @param key   键
     * @param start 开始
     * @param end   结束 0 到 -1代表所有值
     * @return
     */
    @Override
    public List<Object> lGet(String key, long start, long end) {
        try {
            return redisTemplate.opsForList().range(key,start,end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取list缓存的长度
     *
     * @param key 键
     * @return
     */
    @Override
    public long lGetListSize(String key) {
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 通过索引 获取list中的值
     *
     * @param key   键
     * @param index 索引 index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
     * @return
     */
    @Override
    public Object lGetIndex(String key, long index) {
        try {
            return redisTemplate.opsForList().index(key,index);
        } catch (Exception exception ) {
            exception.printStackTrace();
            return null;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    @Override
    public boolean lSet(String key, Object value) {
        try {
            redisTemplate.opsForList().leftPushIfPresent(key,value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time
     * @return
     */
    @Override
    public boolean lSet(String key, Object value, long time) {
        try {
            redisTemplate.opsForList().leftPush(key,value);
            if (time > 0) {
                expire(key,time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    @Override
    public boolean lSetAll(String key, List<Object> value) {
        try {
            redisTemplate.opsForList().leftPushAll(key,value);
            return true;
        } catch (Exception e ){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    @Override
    public boolean lSetAll(String key, List<Object> value, long time) {
        try {
            redisTemplate.opsForList().leftPushAll(key, value);
            if (time> 0) {
                expire(key,time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    @Override
    public boolean rSet(String key, Object value) {
        try {
            redisTemplate.opsForList().rightPush(key,value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    @Override
    public boolean rSet(String key, Object value, long time) {
        try {
            redisTemplate.opsForList().rightPush(key,value);
            if (time > 0) {
                expire(key,time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    @Override
    public boolean rSetAll(String key, List<Object> value) {
        try {
            redisTemplate.opsForList().rightPushAll(key,value);
            return true;
        } catch (Exception e ) {
            e.printStackTrace();
            return  false;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    @Override
    public boolean rSetAll(String key, List<Object> value, long time) {
        try {
            redisTemplate.opsForList().rightPushAll(key,value);
            if (time > 0) {
                expire(key,time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据索引修改list中的某条数据
     *
     * @param key   键
     * @param index 索引
     * @param value 值
     * @return
     */
    @Override
    public boolean lUpdateIndex(String key, long index, Object value) {
        try {
            redisTemplate.opsForList().set(key,index,value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 移除N个值为value
     *
     * @param key   键
     * @param count 移除多少个
     * @param value 值
     * @return 移除的个数
     */
    @Override
    public long lRemove(String key, long count, Object value) {
        try {
            Long counter = redisTemplate.opsForList().remove(key,count,value);
            return counter;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 从redis集合中移除[start,end]之间的元素
     *
     * @param key
     * @param stard
     * @param end
     * @return
     */
    @Override
    public void rangeRemove(String key, Long stard, Long end) {
        try {
            redisTemplate.opsForList().trim(key,stard,end);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
