# 🎓 Student Central

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![CSV](https://img.shields.io/badge/CSV-Data-green?style=for-the-badge)
![Console](https://img.shields.io/badge/Console-Application-blue?style=for-the-badge)

**A comprehensive Java-based Student Management System for educational institutions**

---

*Efficiently manage student records with powerful filtering, analysis, and data manipulation capabilities*

</div>

## 📋 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [Getting Started](#-getting-started)
- [Installation](#-installation)
- [Usage](#-usage)
- [Project Structure](#-project-structure)
- [Data Format](#-data-format)
- [Examples](#-examples)
- [Contributing](#-contributing)
- [License](#-license)

## 🌟 Overview

Student Central is a robust, console-based student management system built in Java. It provides educational institutions with a simple yet powerful tool to manage student records, perform academic analytics, and maintain comprehensive student databases through an intuitive command-line interface.

### Key Highlights

- 📊 **Data-Driven**: CSV-based storage for easy data import/export
- 🔍 **Advanced Filtering**: Filter students by course, year level, or enrollment status
- 📈 **Academic Analytics**: Graduation eligibility analysis and CWA tracking
- ✏️ **Real-time Editing**: Live student record modifications
- 🔎 **Quick Search**: Instant student lookup by ID
- 💾 **Persistent Storage**: Automatic data persistence across sessions

## ✨ Features

### Core Functionality
- ➕ **Add New Students** - Register new students with complete academic profiles
- ✏️ **Edit Student Records** - Modify any student information field
- 👥 **View All Students** - Display comprehensive student listings
- 🔍 **Advanced Search** - Find students by ID with detailed information
- 📊 **Student Analytics** - Academic performance and graduation analysis

### Filtering & Analytics
- 🎯 **Course-based Filtering** - View students by specific courses
- 📅 **Year Level Filtering** - Group students by academic year
- 📋 **Status Filtering** - Separate full-time (FT) and part-time (PT) students
- 🎓 **Graduation Analysis** - Identify students eligible for graduation (400+ credits)
- 🏆 **Performance Tracking** - Find students with highest CWA (Cumulative Weighted Average)

### Data Management
- 💾 **CSV Integration** - Seamless CSV file operations
- 🔄 **Real-time Updates** - Immediate data persistence
- 📝 **Data Validation** - Input validation and error handling
- 🛡️ **Error Recovery** - Robust exception handling

## 🚀 Getting Started

### Prerequisites

- **Java Development Kit (JDK) 8 or higher**
- **Terminal/Command Prompt access**
- **Text editor or IDE** (VS Code, IntelliJ IDEA, Eclipse)

### Quick Start

1. **Clone the repository**
   ```bash
   git clone https://github.com/D3PI-CODE/student-central.git
   cd student-central
   ```

2. **Compile the application**
   ```bash
   javac -cp src src/*.java -d bin
   ```

3. **Run the application**
   ```bash
   java -cp bin Main
   ```

## 🛠️ Installation

### Manual Setup

1. **Ensure Java is installed**
   ```bash
   java -version
   javac -version
   ```

2. **Create the data file** (if not exists)
   ```bash
   touch Data.csv
   echo "StudentID, FirstName, FamilyName, CourseEnrolled, YearLevel, CWA, Status, CreditsEarned" > Data.csv
   ```

3. **Compile all Java files**
   ```bash
   javac -cp src src/*.java -d bin
   ```

4. **Launch the application**
   ```bash
   java -cp bin Main
   ```

### Development Setup

If using **VS Code**:
- Install the Java Extension Pack
- Open the project folder
- The application will auto-detect Java files and provide IntelliSense

## 💻 Usage

### Main Menu Navigation

When you start Student Central, you'll see the main menu:

```
===========================
Welcome to Student Central
===========================
Your options are:

 1) Add new student
 2) Edit student
 3) View all students
 4) Filter students
 5) Analysis
 6) Search student by ID
 0) Exit
```

### Adding a New Student

1. Select option `1`
2. Enter student details:
   - **Student ID** (must start with 'S')
   - **First Name**
   - **Family Name**
   - **Course Enrolled**
   - **Year Level** (1-4)
   - **CWA** (0.0-100.0)
   - **Status** (FT/PT)
   - **Credits Earned**

### Editing Student Records

1. Select option `2`
2. Enter the student ID to edit
3. Choose which field to modify:
   - First Name
   - Family Name
   - Course Enrolled
   - Year Level
   - CWA
   - Status
   - Credits Earned

### Filtering Students

Select option `4` and choose from:
- **By Course**: View students in specific programs
- **By Year Level**: Group students by academic year
- **By Status**: Filter by enrollment type (FT/PT)

### Academic Analysis

Select option `5` for:
- **Credit Analysis**: Find students eligible for graduation (400+ credits)
- **CWA Analysis**: Identify top-performing students

## 📁 Project Structure

```
student-central/
├── src/
│   ├── Main.java          # Application entry point
│   ├── Menu.java          # User interface and menu handling
│   ├── student.java       # Student data model
│   └── handler.java       # File I/O operations
├── bin/                   # Compiled Java classes (auto-generated)
├── Data.csv              # Student data storage
├── .gitignore            # Git ignore rules
├── .vscode/              # VS Code configuration
│   └── settings.json
└── README.md             # Project documentation
```

### Class Overview

| Class | Purpose | Key Methods |
|-------|---------|-------------|
| `Main` | Application entry point | `main()` |
| `Menu` | User interface management | `displayMenu()`, `getUserChoice()`, `selection()` |
| `student` | Student data model | Getters, setters, constructor |
| `handler` | File operations | `read()`, `append()`, `edit()` |

## 📊 Data Format

### CSV Structure

The `Data.csv` file follows this format:

```csv
StudentID, FirstName, FamilyName, CourseEnrolled, YearLevel, CWA, Status, CreditsEarned
S001,John,Doe,Computer Science,3,85.5,FT,300
S002,Jane,Smith,Mathematics,2,92.0,FT,200
S003,Bob,Johnson,Engineering,4,78.3,PT,450
```

### Field Descriptions

| Field | Type | Description | Validation |
|-------|------|-------------|------------|
| StudentID | String | Unique identifier | Must start with 'S' |
| FirstName | String | Student's first name | Required |
| FamilyName | String | Student's last name | Required |
| CourseEnrolled | String | Academic program | Required |
| YearLevel | Integer | Academic year (1-4) | 1-4 range |
| CWA | Double | Cumulative Weighted Average | 0.0-100.0 |
| Status | String | Enrollment status | FT or PT |
| CreditsEarned | Integer | Total credits completed | Non-negative |

## 🎯 Examples

### Sample Student Records

```java
// Adding a Computer Science student
StudentID: S001
First Name: Alice
Family Name: Johnson
Course: Computer Science
Year Level: 3
CWA: 88.5
Status: FT
Credits Earned: 280

// Adding a Part-time Engineering student
StudentID: S002
First Name: Bob
Family Name: Smith
Course: Engineering
Year Level: 4
CWA: 91.2
Status: PT
Credits Earned: 420
```

### Analysis Results

**Graduation Eligibility (400+ credits):**
```
Students eligible for graduation:
ID: S002 || Name: Bob Smith || Credits Earned: 420
ID: S005 || Name: Sarah Wilson || Credits Earned: 450
```

**Highest CWA Analysis:**
```
The highest CWA is: 95.8
Students with the highest CWA:
| ID: S003 || Name: Emma Davis || CWA: 95.8
```

## 🤝 Contributing

We welcome contributions to Student Central! Here's how you can help:

### Development Guidelines

1. **Fork the repository**
2. **Create a feature branch**
   ```bash
   git checkout -b feature/amazing-feature
   ```
3. **Make your changes**
4. **Test thoroughly**
5. **Commit with clear messages**
   ```bash
   git commit -m "Add amazing feature"
   ```
6. **Push to your branch**
   ```bash
   git push origin feature/amazing-feature
   ```
7. **Open a Pull Request**

### Code Standards

- Follow Java naming conventions
- Add comments for complex logic
- Ensure proper exception handling
- Test all new features
- Maintain backward compatibility

### Areas for Contribution

- 🔐 **Authentication System** - User login and permissions
- 🌐 **Web Interface** - GUI version of the application
- 📊 **Advanced Analytics** - More statistical features
- 📤 **Data Export** - Additional export formats
- 🔄 **Database Integration** - MySQL/PostgreSQL support
- 📱 **Mobile Compatibility** - Android/iOS versions

## 📄 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

<div align="center">

**Built with ❤️ by the Student Central Team**

[Report Bug](https://github.com/D3PI-CODE/student-central/issues) · [Request Feature](https://github.com/D3PI-CODE/student-central/issues) · [Documentation](https://github.com/D3PI-CODE/student-central/wiki)

</div>

