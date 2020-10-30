package ru.yaro.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import ru.yaro.gwt.shared.User;

import java.util.List;

@RemoteServiceRelativePath("/gwtAppService")
public interface GwtAppService extends RemoteService {
    List<User> getUsers();
}
