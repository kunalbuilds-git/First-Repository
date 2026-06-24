Java Programming Repository
This repository contains my hands-on Java projects, covering Object-Oriented Programming (OOP) fundamentals, data structures, and logic challenges.

Project 1: Bank Account System
A console-based banking application that simulates real-world account management, deposits, and withdrawals across multiple account types.

Key Concepts Applied:
Inheritance & Polymorphism: Built a base Account class extended by specific SavingsAccount and CurrentAccount child classes to handle unique behaviors.

Encapsulation: Marked sensitive fields like balance and accountHolderName as private, protecting them from direct outside modification.

Method Overriding: Customized the display and withdrawal logic specifically for each account type (such as handling overdraft limits for current accounts).

Constructor Chaining: Used the super() keyword to pass initialization data from child classes back to the parent class constructor smoothly.

Features:
Validation rules that reject negative deposits or invalid transaction amounts.

Overdraft protection logic allowing current accounts to maintain a negative balance down to a set limit.

Automatic interest calculation and deposits for savings accounts.

Project 2: Student Score Calculator
A utility class designed to process student grades, calculate averages, and assign milestone marks based on academic metrics.

Project 3: Palindrome Checker
A string processing utility that checks whether a word or phrase reads the same backward as forward by evaluating characters from both ends.

Next Steps & Roadmap
Organize the repository by moving standalone tasks into dedicated project sub-folders.

Implement an interactive CLI menu in the banking system using java.util.Scanner.