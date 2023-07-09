/**
 * Copyright 2022-9999 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.binghe.design.singleton;

/**
 * @author binghe(微信 : hacker_binghe)
 * @version 1.0.0
 * @description 懒汉模式（双重锁同步锁单例模式）, 单例实例在第一次使用的时候进行创建，这个类是线程安全的
 * @github https://github.com/binghe001
 * @copyright 公众号: 冰河技术
 */
public class SingletonExample5 {

    private SingletonExample5(){}

    //单例对象  volatile + 双重检测机制来禁止指令重排
    private volatile static SingletonExample5 instance = null;

    public static SingletonExample5 getInstance(){
        if (instance == null){
            synchronized (SingletonExample5.class){
                if(instance == null){
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}
