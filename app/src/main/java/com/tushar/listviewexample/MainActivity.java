package com.tushar.listviewexample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.tushar.listviewexample.adapter.DataAdapter;
import com.tushar.listviewexample.model.Employee;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DataAdapter dataAdapter;
    RecyclerView recyclerView;
    ArrayList<Employee> employees;
    EditText etAddress;
    Button btnSubmit;
    Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        employees = new ArrayList<>();
        initializeEmployeesList();
        dataAdapter = new DataAdapter(this, employees);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(dataAdapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String address = etAddress.getText().toString();

                if (!TextUtils.isEmpty(address)) {
                    employee = new Employee(address);
                    employees.add(employee);
                    dataAdapter.notifyDataSetChanged();
                }
                hideKeyboard(etAddress);
            }
        });
    }

    private void hideKeyboard(EditText editText) {
        editText.setText("");
        InputMethodManager imm =
                (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);

    }

    private void initializeViews() {
        recyclerView = findViewById(R.id.recyclerView);
        etAddress = findViewById(R.id.etAddress);
        btnSubmit = findViewById(R.id.btnSubmit);
    }

    public void initializeEmployeesList() {
        employees.add(new Employee("Cecilia Chapman 711-2880 Nulla St. Mankato Mississippi 96522 (257) 563-7401"));
        employees.add(new Employee("Cecilia Chapman 711-2880 Nulla St. Mankato Mississippi 96522 (257) 563-7401 Cecilia Chapman 711-2880 Nulla St. Mankato Mississippi 96522 (257) 563-7401 "));
        employees.add(new Employee("Cecilia Chapman 711-2880 Nulla St. Mankato Mississippi 96522 (257) 563-7401"));
        employees.add(new Employee("Cecilia Chapman 711-2880 Nulla St. Mankato Mississippi 96522 (257) 563-7401. Cecilia Chapman 711-2880 Nulla St. Mankato Mississippi 96522 (257) 563-7401"));
        employees.add(new Employee("Cecilia Chapman 711-2880 Nulla St. Mankato Mississippi 96522 (257) 563-7401"));
        employees.add(new Employee("Cecilia Chapman 711-2880 Nulla St. Mankato Mississippi 96522 (257) 563-7401 Cecilia Chapman 711-2880 Nulla St. Mankato Mississippi 96522 (257) 563-7401 "));
        employees.add(new Employee("Cecilia Chapman 711-2880 Nulla St. Mankato Mississippi 96522 (257) 563-7401"));
        employees.add(new Employee("Cecilia Chapman 711-2880 Nulla St. Mankato Mississippi 96522 (257) 563-7401. Cecilia Chapman 711-2880 Nulla St. Mankato Mississippi 96522 (257) 563-7401"));

    }
}
