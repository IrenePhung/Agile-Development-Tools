# ASHES Restaurant Ordering System

ASHES is a console-based restaurant ordering and menu-management application written in Java. It supports customer registration and authentication, menu browsing, cart management, order placement, and a set of administrative operations.

The project was developed as part of the **Lab01 Richard Group04 A1** coursework and demonstrates Java fundamentals, file-based persistence, object-oriented programming, Gradle build automation, Git workflows, and unit testing with JUnit 5.

## Features

### Customer features

- Register a new account
- Log in with an existing account
- Browse restaurant menu categories and items
- Add menu items and quantities to an order cart
- Review cart contents
- Place an order

### Administrator features

- Access a dedicated administration menu
- Place orders through the standard restaurant workflow
- Add new menu items
- Remove menu items
- Edit existing menu items
- View the total number of processed orders
- View order history
- Load and manage registered-user information

### Data persistence

The application uses plain-text files for local persistence:

- `registration.txt` stores registration and login data
- `orders.txt` stores submitted orders

This approach keeps the project simple and self-contained; no external database is required.

## Technology Stack

- **Language:** Java
- **Build tool:** Gradle 7.5.1 Wrapper
- **Testing:** JUnit Jupiter 5.8.2
- **Utility library:** Google Guava 31.0.1-jre
- **Version control:** Git
- **Interface:** Command-line interface (CLI)

## Project Structure

```text
Agile-Development-Tools/
├── app/
│   ├── build.gradle
│   ├── registration.txt
│   └── src/
│       ├── main/java/lab01/richard/group04/a1/
│       │   ├── App.java
│       │   ├── Login.java
│       │   ├── RegistrationApp.java
│       │   ├── OrderSystem.java
│       │   ├── OrderCart.java
│       │   ├── MenuCategories.java
│       │   ├── ExistingMenu.java
│       │   ├── Additems.java
│       │   ├── RemoveItems.java
│       │   ├── Admin.java
│       │   ├── Items.class
│       │   ├── registration.txt
│       │   └── orders.txt
│       └── test/java/lab01/richard/group04/a1/
│           ├── AppTest.java
│           ├── LoginTest.java
│           ├── AdminTest.java
│           └── OrderSystemTest.java
├── gradle/wrapper/
├── gradlew
├── gradlew.bat
├── settings.gradle
└── README.md
```

## Main Components

| Component | Responsibility |
| --- | --- |
| `App` | Starts the application and directs users to registration or login |
| `RegistrationApp` | Collects account details and stores new registrations |
| `Login` | Loads credentials and authenticates users |
| `OrderSystem` | Coordinates menu selection and the ordering workflow |
| `OrderCart` | Stores selected menu items and quantities |
| `MenuCategories` | Displays menu categories and available items |
| `Admin` | Provides menu maintenance and order-reporting functions |
| `Additems` | Adds items to the menu |
| `RemoveItems` | Removes items from the menu |
| `ExistingMenu` | Displays and edits existing menu data |

## Prerequisites

Before running the project, install:

- Java Development Kit (JDK) 11 or later
- Git, if cloning the repository

A separate Gradle installation is not required because the repository includes the Gradle Wrapper.

Confirm Java is available:

```bash
java -version
```

## Installation

Clone the repository and enter its root directory:

```bash
git clone <repository-url>
cd Agile-Development-Tools
```

Replace `<repository-url>` with the actual Git repository URL.

On macOS or Linux, make the Gradle Wrapper executable if necessary:

```bash
chmod +x gradlew
```

## Running the Application

Run the application from the repository root.

### macOS or Linux

```bash
./gradlew run
```

### Windows

```powershell
gradlew.bat run
```

At the opening prompt, enter one of the supported commands:

```text
register
login
exit
```

Input is not case-sensitive.

## Typical Usage

1. Start the application.
2. Enter `register` and provide your name, email address, username, and password.
3. Return to the opening screen and enter `login`.
4. Enter the registered username and password.
5. Browse the menu, choose items, specify quantities, and complete the order.
6. Administrative users can access menu-management and order-history options.

## Running the Tests

Run all automated tests from the repository root.

### macOS or Linux

```bash
./gradlew test
```

### Windows

```powershell
gradlew.bat test
```

The generated HTML report is available at:

```text
app/build/reports/tests/test/index.html
```

The test suite covers core behaviour in the following areas:

- Application startup
- Credential loading and login
- Administrative operations
- Restaurant ordering workflows

## Building the Project

Create the compiled application and run all verification tasks:

```bash
./gradlew build
```

On Windows, use:

```powershell
gradlew.bat build
```

Build outputs are generated under `app/build/`.

To remove generated build files:

```bash
./gradlew clean
```

## Data and File-Path Notes

The current implementation reads and writes files using paths relative to the `app` project directory, such as:

```text
src/main/java/lab01/richard/group04/a1/registration.txt
src/main/java/lab01/richard/group04/a1/orders.txt
```

Run the application with the provided Gradle task to preserve the expected working-directory behaviour. Back up these files before resetting local application data.

## Security Notice

This is an educational project. User passwords are currently stored as plain text in a local file. Do not use real passwords or deploy the application as a production authentication system.

A production-ready version should:

- Hash passwords with a secure password-hashing algorithm
- Store data in a managed database
- Validate and sanitise all input
- Apply role-based access control explicitly
- Avoid committing user and order data to version control
- Handle file and authentication errors without exposing sensitive information

## Known Limitations

- The application is available only through a command-line interface.
- Registration and order data are stored locally rather than in a database.
- Data-file paths are coupled to the current source-tree layout.
- Menu and account operations have limited input validation.
- The repository contains compiled `.class` files and build output that would normally be excluded from version control.
- The application is intended for coursework and demonstration purposes.

## Suggested Improvements

- Replace text-file persistence with a relational database
- Hash and salt passwords securely
- Add explicit customer and administrator roles
- Improve validation and error handling
- Separate user-interface, business-logic, and persistence layers
- Add order totals, prices, receipts, and order status tracking
- Expand unit and integration test coverage
- Add a graphical, web, or mobile interface
- Exclude generated files through a comprehensive `.gitignore`

## Contributing

1. Create a new branch from the main development branch.
2. Make focused changes and add or update relevant tests.
3. Run `./gradlew test` before committing.
4. Commit with a clear, descriptive message.
5. Open a pull request describing the change and its purpose.

## Academic Context

This repository was created for the **Lab01-Richard-Group04-A1** group assignment. If you reuse the project in an academic setting, follow your institution's academic-integrity and attribution requirements.

## License

No project-specific license file was identified in the supplied archive. Unless a license is added by the project owners, the source code should be treated as all rights reserved.
