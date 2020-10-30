package ru.yaro.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import ru.yaro.gwt.shared.User;

import java.util.List;

public class GwtApp implements EntryPoint {

    private final GwtAppServiceAsync gwtAppServiceAsync = GWT.create(GwtAppService.class);


    @Override
    public void onModuleLoad() {
        AsyncCallback<List<User>> callback = new AsyncCallback<List<User>>() {

            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(List<User> res) {
                CellTable<User> table = new CellTable<>();
                List<User> users = res;
                // Create name column.
                TextColumn<User> loginColumn = new TextColumn<User>() {
                    public String getValue(User user) {
                        return user.login;
                    }
                };
                TextColumn<User> passwordColumn = new TextColumn<User>() {
                    public String getValue(User user) {
                        return user.password;
                    }
                };
                TextColumn<User> nameColumn = new TextColumn<User>() {
                    public String getValue(User user) {
                        return user.name;
                    }
                };


                // Add the columns.
                table.addColumn(nameColumn, "Login");
                table.addColumn(nameColumn, "Password");
                table.addColumn(nameColumn, "Name");

                // Set the total row count. This isn't strictly necessary, but it affects
                // paging calculations, so its good habit to keep the row count up to date.
                table.setRowCount(users.size(), true);

                // Push the data into the widget.
                table.setRowData(0, users);

                // Add it to the root panel.
                RootPanel.get().

                        add(table);

            }
        };
        gwtAppServiceAsync.getUsers(callback);
    }
}


