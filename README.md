# Project Planner Dashboard (PPD)

A lightweight web application to manage projects, file detailed reports, and streamline collaboration. PPD is built with **Java** (Spring Boot), **Thymeleaf**, and **Tailwind CSS**, offering a clean, responsive interface for small teams or individual developers to track project progress and store associated documentation (e.g., Google Docs).

---

## Table of Contents

1. [Features](#features)  
2. [Tech Stack](#tech-stack)  
3. [Getting Started](#getting-started)  
4. [Usage](#usage)  
5. [Screenshots](#screenshots)  

---

## Features

- **Project Management**  
  - Create, list, and view projects.  
  - Assign tags (comma-separated) and people (comma-separated) to each project.  

- **Report Filing**  
  - Submit detailed reports tied to an existing project.  
  - Optionally attach a Google Docs link (or any URL).  
  - Browse all submitted reports and click through to open associated Google Docs.

- **Responsive, Intuitive UI**  
  - Built with **Tailwind CSS** for a modern look.  
  - Sidebar navigation that can be collapsed/expanded.  
  - Equally distributed table columns to improve readability.

- **Lightweight & Extensible**  
  - Easy to clone, run, and extend.  
  - Thymeleaf templates make adding new views or modifying layouts straightforward.

---

## Tech Stack

- **Backend**:  
  - Java 17+ (Spring Boot 3.x)  
  - Spring MVC, Spring Web  
  - Thymeleaf (server-side templating)  

- **Frontend**:  
  - Tailwind CSS (utility-first CSS framework)  

- **Build & Dependency Management**:  
  - Maven  



## Getting Started

### Prerequisites

- **Java 17 (+)** installed and `JAVA_HOME` configured.  
- **Maven 3.6 (+)** installed and available on your `PATH`.  
- Internet access (to pull dependencies and for any Google Docs links used).

### 1. Clone the Repository

```bash
git clone https://github.com/MNTadros/PPD.git
cd PPD
```

### 2. Build the Project

Use Maven to build and package:

```bash
mvn clean install
```

This will compile the code, run any tests, and package the application into an executable JAR file.

### 3. Run the Application

You can run the Spring Boot application via Maven:

```bash
mvn spring-boot:run
```

By default, the application starts on **port 8080**. You should see Spring Boot logs indicating:

```
Started DashboardApplication in X.XXX seconds (JVM running for Y.YYY)
```

### 4. Open in Browser

Navigate to:  

```
http://localhost:8080/
```

- **Home**: Overview/dashboard with quick links and metrics.  
- **Projects**: Create and view existing projects.  
- **Reports**: Submit new reports and browse previously filed reports.  
- **Settings**: (Placeholder—extendable for future preferences).

---

## Usage

### 1. Create a Project

1. Click **Projects** in the sidebar.  
2. Fill in the **Project Name**, **Description**, (optional) **Tags**, and (optional) **People** fields.  
3. Click **Add Project**.  
4. The project appears in the table below, with columns evenly split across the full width.

> **Note**: Tags and People accept comma-separated values (e.g., `frontend,backend` or `alice,bob`).

### 2. File a Report

1. Click **Reports** in the sidebar.  
2. Click **+ New Report** (top-right).  
3. Fill in:  
   - **Report Title**  
   - **Report Content** (supports multi-line text)  
   - (Optional) **Google Doc Link** (any valid URL)  
   - **Associated Project** (select from a drop-down of existing projects)  
4. Click **Submit Report**.  
5. You are redirected to the **Reports** list. Each report shows its Title, Content (preview), Associated Project, and a clickable Google Doc link if provided.


### 3. Settings (Placeholder)

- The **Settings** page exists as a placeholder and will be extended to include user preferences, theming options, or other configuration in future versions.

---

## Screenshots

![Home Overview](https://github.com/MNTadros/PPD/blob/main/src/main/resources/static/homepage.JPG) 
*Overview Dashboard (with sidebar, quick links, and metrics)*

![Projects Page](https://github.com/MNTadros/PPD/blob/main/src/main/resources/static/projectpage.JPG)
*Projects Page (create & list projects; evenly distributed table columns)*

![Reports Page](https://github.com/MNTadros/PPD/blob/main/src/main/resources/static/reportpage.JPG) 
*Reports Page (list & file new reports; choose existing project)*

---
