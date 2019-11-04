package com.test.springboot.tools.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * <p>描述: Redis工具类
 * <p>日期: 2019/10/3 17:25
 * <p>作者: hamish
 * 直接用RedisTemplate操作Redis，需要很多行代码，
 * 因此直接封装好一个RedisUtil，这样写代码更方便点。这个RedisUtil交给Spring容器实例化，使用时直接注解注入
 */
public class RedisUtil {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    // ============================Common=============================

    /**
     * <p>描述: 指定缓存失效时间
     * <p>日期: 2019/10/3 5:30 PM
     * <p>作者: hamish
     * @param key 键
     * @param time 时间(秒)
     * @return true成功 false失败
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * <p>描述: 判断key是否存在
     * <p>日期: 2019/10/3 5:34 PM
     * <p>作者: hamish
     * @param key 键
     * @return true 存在 false 不存在
     */
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * <p>描述: 删除缓存
     * <p>日期: 2019/10/3 8:34 PM
     * <p>作者: hamish
     * @param key 可以传一个值或者多个值
     * @return
     */
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    // ============================String=============================

    /**
     * <p>描述: 缓存普通数据
     * <p>日期: 2019/10/3 5:38 PM
     * <p>作者: hamish
     * @param key 键
     * @param value 值
     * @return true成功 false 失败
     */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * <p>描述: 缓存普通数据并设置时间
     * <p>日期: 2019/10/3 8:37 PM
     * <p>作者: hamish
     * @param key 键
     * @param value 值
     * @param time 时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    public boolean set(String key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * <p>描述: 普通缓存获取
     * <p>日期: 2019/10/3 8:28 PM
     * <p>作者: hamish
     * @param key 键
     * @return
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * <p>描述: 递增
     * <p>日期: 2019/10/3 8:42 PM
     * <p>作者: hamish
     * @param key 键
     * @param delta 要增加几(大于0)
     * @return
     */
    public long incr(String key, long delta) {
        if (delta <= 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * <p>描述: 递减
     * <p>日期: 2019/10/3 8:42 PM
     * <p>作者: hamish
     * @param key 键
     * @param delta 要减少几(大于0)
     * @return
     */
    public long decr(String key, long delta) {
        if (delta <= 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, -delta);
    }

    // ================================Map=================================

    /**
     * <p>描述: HashGet
     * <p>日期: 2019/10/3 9:04 PM
     * <p>作者: hamish
     * @param key 键 不能为null
     * @param item 项 不能为null
     * @return
     */
    public Object hget(String key, String item) {
        return redisTemplate.opsForHash().get(key, item);
    }

    /**
     * <p>描述: 获取hashKey对应的所有键值
     * <p>日期: 2019/10/3 9:07 PM
     * <p>作者: hamish
     * @param key 键
     * @return
     */
    public Object hmget(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * <p>描述: HashSet
     * <p>日期: 2019/10/3 9:11 PM
     * <p>作者: hamish
     * @param key 键
     * @param map 对应多个键值
     * @return
     */
    public boolean hmset(String key, Map<String, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * <p>描述: HashSet 并设置时间
     * <p>日期: 2019/10/3 9:11 PM
     * <p>作者: hamish
     * @param key 键
     * @param map 对应多个键值
     * @param time 时间(秒)
     * @return
     */
    public boolean hmset(String key, Map<String, Object> map, long time) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * <p>描述: 向一张hash表中放入数据,如果不存在将创建
     * <p>日期: 2019/10/3 9:17 PM
     * <p>作者: hamish
     * @param key 键
     * @param item 项
     * @param value 值
     * @return 
     */
    public boolean hset(String key, String item, Object value) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * <p>描述: 向一张hash表中放入数据,如果不存在将创建，并设置时间
     * <p>日期: 2019/10/3 9:17 PM
     * <p>作者: hamish
     * @param key 键
     * @param item 项
     * @param value 值
     * @param time 时间(秒)
     * @return
     */
    public boolean hset(String key, String item, Object value, long time) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * <p>描述: 删除hash表中的值
     * <p>日期: 2019/10/3 9:21 PM
     * <p>作者: hamish
     * @param key 键 不能为null
     * @param item 项 可以是多个 不能为null
     * @return 
     */
    public void hdel(String key, String... item) {
        redisTemplate.opsForHash().delete(key, item);
    }

    /**
     * <p>描述: 判断hash表中是否有该项的值
     * <p>日期: 2019/10/3 9:22 PM
     * <p>作者: hamish
     * @param key 键
     * @param item 项
     * @return 
     */
    public boolean hhasKsy(String key, String item) {
        return redisTemplate.opsForHash().hasKey(key, item);
    }

    /**
     * <p>描述: hash递增 如果不存在,就会创建一个 并把新增后的值返回
     * <p>日期: 2019/10/3 9:25 PM
     * <p>作者: hamish
     * @param key 键
     * @param item 项
     * @param num 要增加几(大于0)
     * @return 
     */
    public double hincr(String key, String item, double num) {
        return redisTemplate.opsForHash().increment(key, item, num);
    }

    /**
     * <p>描述: hash递减
     * <p>日期: 2019/10/3 9:25 PM
     * <p>作者: hamish
     * @param key 键
     * @param item 项
     * @param num 要减少几(大于0)
     * @return
     */
    public double hdecr(String key, String item, double num) {
        return redisTemplate.opsForHash().increment(key, item, -num);
    }

    // ================================Set=================================

    /**
     * <p>描述: 根据key获取Set中的所有值
     * <p>日期: 2019/10/3 9:29 PM
     * <p>作者: hamish
     * @param key 键
     * @return 
     */
    public Set<Object> sGet(String key) {
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * <p>描述: 根据value从一个set中查询,是否存在
     * <p>日期: 2019/10/3 9:33 PM
     * <p>作者: hamish
     * @param key 键
     * @param value 值
     * @return 
     */
    public boolean sHashKey(String key, Object value) {
        try {
            return redisTemplate.opsForSet().isMember(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * <p>描述: 将数据放入set缓存
     * <p>日期: 2019/10/3 9:30 PM
     * <p>作者: hamish
     * @param key 键
     * @param values 值 可以是多个
     * @return 成功个数
     */
    public long sSet(String key, Object... values) {
        try {
            return redisTemplate.opsForSet().add(key, values);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * <p>描述: 将数据放入set缓存，并设置时间
     * <p>日期: 2019/10/3 9:30 PM
     * <p>作者: hamish
     * @param key 键
     * @param time 时间(秒)
     * @param values 值 可以是多个
     * @return 成功个数
     */
    public long sSetAndTime(String key, long time, Object... values) {
        try {
            Long count = redisTemplate.opsForSet().add(key, values);
            if (time > 0) {
                expire(key, time);
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * <p>描述: 获取Set缓存的长度
     * <p>日期: 2019/10/4 10:51 AM
     * <p>作者: hamish
     * @param key 键
     * @return
     */
    public long sGetSize(String key) {
        try {
            return redisTemplate.opsForSet().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * <p>描述: 移除值为value的
     * <p>日期: 2019/10/4 11:24 AM
     * <p>作者: hamish
     * @param key 键
     * @param values 值 可以是多个
     * @return
     */
    public long sRemove(String key, Object... values) {
        try {
            return redisTemplate.opsForSet().remove(key, values);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


    // ===============================list=================================

    /**
     * <p>描述: 获取List缓存的内容
     * <p>日期: 2019/10/4 11:23 AM
     * <p>作者: hamish
     * @param key 键
     * @param start 开始
     * @param end 结束
     * 说明：0 到 -1代表所有值
     * @return 
     */
    public List<Object> lGet(String key, long start, long end) {
        try {
            return redisTemplate.opsForList().range(key,start,end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * <p>描述: 获取List缓存的长度
     * <p>日期: 2019/10/4 11:26 AM
     * <p>作者: hamish
     * @param key 键
     * @return 
     */
    public long lGetListSize(String key) {
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
