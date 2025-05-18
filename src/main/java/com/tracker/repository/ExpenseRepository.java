package com.tracker.repository;

import com.tracker.model.Expense;
import java.util.ArrayList;
import java.util.List;

public class ExpenseRepository {

    private final List<Expense> expenses = new ArrayList<>();

    public void add(Expense e) {
        expenses.add(e);
    }

    public void remove(Expense e) {
        expenses.remove(e);
    }

    public String list() {
        if (expenses.isEmpty()) return "No expenses registered.";
        StringBuilder sb = new StringBuilder("Despesas:\n");
        for (Expense e : expenses) sb.append(e).append("\n");
        return sb.toString();
    }

    public float summary() {
        float sum = 0;
        for (Expense e : expenses) sum += e.getValue();
        return sum;
    }

    public float summaryByMonth(int year, int month) {
        float sum = 0;
        for (Expense e : expenses) {
            if (
                e.getDate().getYear() == year &&
                e.getDate().getMonthValue() == month
            ) {
                sum += e.getValue();
            }
        }
        return sum;
    }

    public List<Expense> getAll() {
        return expenses;
    }
}
