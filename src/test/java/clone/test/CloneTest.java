package clone.test;

import clone.model.Email;
import clone.model.Person;
import common.utils.CloneUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * <p>Description: 深复制与浅复制研究示例</p>
 *
 * @author Junpengzhou
 * @version 1.0.0
 * @since 2019.04.21 12:18
 */
@SuppressWarnings("all")
public class CloneTest {
    Email email;
    Person person1;
    Person person2;
    Person person3;

    @BeforeEach
    public void init() {
        email = new Email("jeepzhou11@163.com", "大葛格", "hello-clone");
        person1 = new Person("张三", 11, email);
    }

    @AfterEach
    public void log() {
        System.out.println("person1=" + person1);
        System.out.println("person2=" + person2);
        System.out.println("person3=" + person3);

        System.out.println("person1.email=" + person1.getEmail());
        System.out.println("person2.email=" + person2.getEmail());
        System.out.println("person3.email=" + person3.getEmail());

        System.out.println(person1.getName() + "的邮件内容是：" + person1.getEmail().getContent());
        System.out.println(person2.getName() + "的邮件内容是：" + person2.getEmail().getContent());
        System.out.println(person3.getName() + "的邮件内容是：" + person3.getEmail().getContent());
    }

    @Test
    public void toubleAnalyze() {
        person2 = person1.clone();
        person2.setName("李四");
        person3 = person1.clone();
        person3.setName("王五");
        person1.getEmail().setContent("请与今天12:00到二会议室参加会议...");
    }

    /* 浅拷贝只是Java提供的一种简单的拷贝机制，有些业务下不便于直接使用
     * 我们可以在Person中的clone中加入此句，person.setEmail(new Email(person.getEmail().getObject(),person.getEmail().getContent()));
     * 但是如果我们每一个类都写一个clone()方法，并将还需要进行深拷贝，新建大量的对象，这个工程是非常大的，这里我们可以利用序列化来实现对象的拷贝
     */
    @Test
    public void deepClone() {
        person2 = CloneUtils.clone(person1);
        person2.setName("李四");
        person3 = CloneUtils.clone(person1);
        person3.setName("王五");
        person1.getEmail().setContent("请与今天12:00到二会议室参加会议...");
    }

}
