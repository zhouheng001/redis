package com.redis.springbootredis.service;

import com.redis.springbootredis.DO.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 参考地址 ：https://blog.csdn.net/dreamhai/article/details/80642010
 */
@Service
public class ServiceImpl implements IService {

    @Override
    @Cacheable(cacheManager = "cacheManager", value = "service", key = "'test1'")
    public String ttest1() {
        System.out.println("方法内");
        return "sdljfkjskfljslfdkjafkls";
    }

    @Override
    @CacheEvict(cacheManager = "cacheManager", value = "service", key = "'test1'")
    public void clean() {

    }

    @Cacheable("cache1")//Cache是发生在cache1上的
    public User find(Integer id) {
        return null;
    }

    @Cacheable({"cache1", "cache2"})//Cache是发生在cache1和cache2上的
    public User find1(Integer id) {
        return null;
    }

    /**
     * key 是指传入时的参数
     */
    @Cacheable(value = "users", key = "#id")
    public User find2(Integer id) {
        return null;
    }

    // 表示第一个参数
    @Cacheable(value = "users", key = "#p0")
    public User find3(Integer id) {
        return null;
    }

    // 表示User中的id值
//    @Cacheable(value = "users", key = "#user.id+#user.name")
    @Cacheable(value = "users", key = "#root.targetClass")
    public User find4(User user) {
        return null;
    }

    // 表示第一个参数里的id属性值
    @Cacheable(value = "users", key = "#p0.id")
    public User find5(User user) {
        return null;
    }

    // key值为: user中的name属性的值
    @Cacheable(value = {"users", "xxx"}, key = "caches[1].name")
    public User find6(User user) {
        return null;
    }

    // 根据条件判断是否缓存
    @Cacheable(value = {"users"}, key = "#user.id", condition = "#user.id%2==0")
    public User find7(User user) {
        System.out.println("find user by user " + user);
        return user;
    }

    //@CachePut也可以标注在类上和方法上。使用@CachePut时我们可以指定的属性跟@Cacheable是一样的。
    @CachePut("users")//每次都会执行方法，并将结果存入指定的缓存中
    public User find8(Integer id) {
        return null;
    }

    // allEntries是boolean类型，表示是否需要清除缓存中的所有元素。默认为false，表示不需要。
    // 当指定了allEntries为true时，Spring Cache将忽略指定的key。有的时候我们需要Cache一下清除所有的元素，这比一个一个清除元素更有效率。
    @CacheEvict(value = "users", allEntries = true)
    public void delete(Integer id) {
        System.out.println("delete user by id: " + id);

    }
}
