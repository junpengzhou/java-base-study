package clone.model;

import java.io.Serializable;

/**
 * <p>Description: 邮件业务对象</p>
 *
 * @author Junpengzhou
 * @version 1.0.0
 * @since 2019.04.21 12:19
 */
public class Email implements Serializable {
    private String account;
    private String name;
    private String content;

    public Email(String account, String name, String content) {
        this.account = account;
        this.name = name;
        this.content = content;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
