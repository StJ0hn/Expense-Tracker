package com.tracker.view;

import com.tracker.model.Expense;
import com.tracker.repository.ExpenseRepository;
import com.tracker.service.ExpenseService;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExpenseView {

    private final ExpenseService service = new ExpenseService(
        new ExpenseRepository()
    );
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("=== MENU ===");
            System.out.println("1. ADD");
            System.out.println("2. LIST");
            System.out.println("3. REMOVE BY ID");
            System.out.println("4. TOTAL SUMMARY");
            System.out.println("5. SUMMARY BY MONTH");
            System.out.println("0. EXIT");
            System.out.print("Option: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    addInMenu();
                    break;
                case "2":
                    System.out.println(service.listExpenses());
                    break;
                case "3":
                    removeInMenu();
                    break;
                case "4":
                    System.out.printf(
                        "Total amount: R$ %.2f\n",
                        service.totalSummary()
                    );
                    break;
                case "5":
                    summaryByMonthMenu();
                    break;
                case "0":
                    System.exit(0);
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private void addInMenu() {
        try {
            System.out.print("Category: \n");
            String category = scanner.nextLine();

            System.out.print("Name: \n");
            String name = scanner.nextLine();

            System.out.print("Value: \n");
            float value = Float.parseFloat(scanner.nextLine());

            System.out.print("Date (AAAA-MM-DD): \n");
            LocalDate date = LocalDate.parse(scanner.nextLine());

            Expense e = new Expense(category, name, value, date);
            service.addExpense(e);
            System.out.println(name + " added successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void removeInMenu() {
        System.out.println(service.listExpenses());
        System.out.println("To remove. Insert ID of expense: \n");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            service.removeExpenseById(id);
            System.out.println("Expense removed.");
        } catch (Exception e) {
            System.out.println("Invalid ID.");
        }
    }

    private void summaryByMonthMenu() {
        try {
            System.out.print("Year (YYYY): ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.print("Month (MM): ");
            int month = Integer.parseInt(scanner.nextLine());
            float sum = service.summaryByMonth(year, month);
            System.out.printf("Total for %d-%02d: R$ %.2f\n", year, month, sum);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }
}
