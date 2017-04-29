package com.qchery.funda.props;

import com.qchery.funda.modules.sys.entity.User;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author Chery
 * @date 2017/4/29 - 下午2:24
 */
@ConfigurationProperties(prefix = "sys")
public class SystemProperties {

    @NotEmpty
    @Valid
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
