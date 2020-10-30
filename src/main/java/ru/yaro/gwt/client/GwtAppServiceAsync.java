package ru.yaro.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import ru.yaro.gwt.shared.User;

import java.util.List;

public interface GwtAppServiceAsync {
    void getUsers(AsyncCallback<List<User>> async);
}
