package com.tracker.service;

import com.tracker.model.Expense;
import com.tracker.repository.ExpenseRepository;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;

public class ExpenseService {

    private final ExpenseRepository repository;
    private final String FILE_PATH = "expenses.csv";

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
        loadFromFile();
    }

    public void addExpense(Expense expense) {
        repository.add(expense);
        appendToFile(expense);
    }

    public void removeExpenseById(int id) {
        Expense toRemove = findById(id);
        if (toRemove != null) {
            repository.remove(toRemove);
            saveAllToFile();
        }
    }

    public String listExpenses() {
        return repository.list();
    }

    public float totalSummary() {
        return repository.summary();
    }

    public float summaryByMonth(int year, int month) {
        return repository.summaryByMonth(year, month);
    }

    private Expense findById(int id) {
        for (Expense e : repository.getAll()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    private void appendToFile(Expense e) {
        try (
            BufferedWriter writer = new BufferedWriter(
                new FileWriter(FILE_PATH, true)
            )
        ) {
            writer.write(format(e));
            writer.newLine();
        } catch (IOException ex) {
            System.err.println("Erro ao gravar no arquivo: " + ex.getMessage());
        }
    }

    private void saveAllToFile() {
        try (
            BufferedWriter writer = new BufferedWriter(
                new FileWriter(FILE_PATH)
            )
        ) {
            for (Expense e : repository.getAll()) {
                writer.write(format(e));
                writer.newLine();
            }
        } catch (IOException ex) {
            System.err.println(
                "Erro ao sobrescrever o arquivo: " + ex.getMessage()
            );
        }
    }

    private void loadFromFile() {
        if (!Files.exists(Paths.get(FILE_PATH))) return;

        try (
            BufferedReader reader = new BufferedReader(
                new FileReader(FILE_PATH)
            )
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                Expense e = parse(line);
                repository.add(e);
            }
        } catch (IOException ex) {
            System.err.println("Erro ao ler o arquivo: " + ex.getMessage());
        }
    }

    private Expense parse(String line) {
        String[] parts = line.split(";");
        int id = Integer.parseInt(parts[0]);
        String name = parts[1];
        String category = parts[2];
        float value = Float.parseFloat(parts[3]);
        LocalDate date = LocalDate.parse(parts[4]);

        return new Expense(category, name, value, id, date);
    }

    private String format(Expense e) {
        return String.format(
            "%d;%s;%s;%.2f;%s",
            e.getId(),
            e.getName(),
            e.getCategory(),
            e.getValue(),
            e.getDate().toString()
        );
    }
}
