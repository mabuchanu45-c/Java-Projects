# ATM Interface — Java Development (OIBSIP)

## Objective
Console-based ATM simulation with PIN authentication and standard 
banking transactions (withdraw, deposit, transfer, transaction history).

## Tech Stack
Java (console application, Object-Oriented design)

## Classes
- `ATM` — handles login and menu flow
- `Account` — stores balance, PIN, and transaction history
- `Transaction` — represents a single transaction record
- `Bank` — manages all accounts
- `Main` — entry point

## Features
- User ID + PIN login (denies access after 3 incorrect attempts)
- Transaction History
- Withdraw (with insufficient funds check)
- Deposit
- Transfer between accounts
- Quit with goodbye message

## Test Accounts
- User ID: `1001`, PIN: `1234`
- User ID: `1002`, PIN: `5678`

## How to Run
1. Compile: `javac *.java`
2. Run: `java Main`

## Demo Video
[LinkedIn link here]