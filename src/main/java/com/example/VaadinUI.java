package com.example;

import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

@CDIUI("")
@Theme("valo")
public class VaadinUI extends UI {

    @Inject
    private EmployeeRepository repository;

    private Grid grid = new Grid();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        TextField filter = new TextField("Filter by name:");
        filter.addTextChangeListener(e -> updateGrid(e.getText()));

        VerticalLayout layout = new VerticalLayout(filter, grid);
        layout.setMargin(true);
        layout.setSpacing(true);
        setContent(layout);
        updateGrid("");
        grid.setColumns("name", "email");
    }

    @PostConstruct
    public void addEmployee() {
        Employee e = new Employee();
        e.setName("test1");
        e.setEmail("test1@test.com");
        repository.saveAndFlush(e);
    }

    private void updateGrid(String filter) {
        List<Employee> employees = repository.findByNameLikeIgnoreCase("%" + filter + "%");
        grid.setContainerDataSource(new BeanItemContainer<>(Employee.class, employees));
    }
}
