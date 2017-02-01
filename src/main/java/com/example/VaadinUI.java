package com.example;

import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.inject.Inject;
import java.util.List;

@CDIUI("")
@Theme("valo")
public class VaadinUI extends UI {

    @Inject
    private EmployeeRepository repository;

    private Grid<Employee> grid = new Grid<>();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        TextField filter = new TextField("Filter by name:");
        filter.addValueChangeListener(e -> updateGrid(e.getValue()));

        grid.addColumn(Employee::getName).setCaption("Name");
        grid.addColumn(Employee::getEmail).setCaption("Email");

        VerticalLayout layout = new VerticalLayout(filter, grid);
        setContent(layout);
        updateGrid("");
    }

    private void updateGrid(String filter) {
        List<Employee> employees = repository.findByNameLikeIgnoreCase("%" + filter + "%");
        grid.setItems(employees);
    }
}
