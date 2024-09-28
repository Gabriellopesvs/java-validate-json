# Java JSON Validation Project

[![Build Status](https://travis-ci.org/your-username/java-validate-json.svg?branch=master)](https://travis-ci.org/your-username/java-validate-json "Travis CI")
[![codecov](https://codecov.io/gh/your-username/java-validate-json/branch/master/graph/badge.svg)](https://codecov.io/gh/your-username/java-validate-json)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.your-username/validate-json.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.your-username%22%20AND%20a:%22validate-json%22)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

## Overview:

This project is a **Java** automation framework designed to validate the structure and content of JSON files. The goal is to ensure that JSON data in a flow or process, such as a hiring process, is correct and within the specified schema.

## Problem Statement:
- Automated validation of JSON files in complex processes, such as hiring workflows.
- Ensuring that the provided JSON data follows the expected schema and meets system requirements.

## Solution:
This project provides a set of tools to automatically validate JSON files, allowing integration into automated tests and ensuring that processed data is correct and well-formed.

## Features:

- **JSON Structure Validation**: Verifies if the JSON structure is as expected.
- **Field Validation**: Ensures that mandatory fields are present and the data is in the correct format.
- **Automated Process Testing**: Includes a flow for automated tests in a hiring process.

## Methods:

  `boolean validateJsonStructure(String json)`: Validates the structure of a JSON file and returns true if it's correct.
  
  `boolean validateJsonField(String json, String field)`: Checks if a specific field is present in the JSON.
  
  `void runHiringProcessTest()`: Runs automated tests to validate the hiring process based on JSON.

## How It Works:

### Test Example:

```java
@Test
public void testHiringProcessJsonValidation() {
    String hiringProcessJson = "{...}"; // Example JSON for the hiring process
    boolean isStructureValid = ComponentAwaiter.validateJsonStructure(hiringProcessJson);
    
    assertTrue(isStructureValid);
    
    boolean isFieldPresent = ComponentAwaiter.validateJsonField(hiringProcessJson, "applicantName");
    assertTrue(isFieldPresent);
}
```

# What's New?

This project now supports the following technologies:
- Java 11+
- JSON Library for validating JSON structures.

# How to Use This Project:

To use this project, simply add the Maven dependency or clone the GitHub repository.

### Maven:

```xml
<dependency>
    <groupId>com.your-username</groupId>
    <artifactId>java-validate-json</artifactId>
    <version>1.0.0</version>
</dependency>
```
### Gradle:

```xml
implementation 'com.your-username:java-validate-json:1.0.0'
```

# Configuration:

You can adjust the JSON validation rules and other parameters in the config.properties file.

# JSON Example:

Here is an example of how JSON is validated in the hiring workflow.

### JSON Example:

Here is an example of how the JSON validation is done in the hiring workflow.

```java
{
  "applicantName": "John Doe",
  "position": "Developer",
  "status": "In Progress",
  "age": 25,
  "experience": true,
  "desired_salary": 50000
}
```

You can validate the structure and fields as follows:

 - Validating Candidates' Age: The system checks if candidates are over a certain age to proceed to the next step of the hiring process.
- Checking Company Eligibility: The system validates whether the candidates meet the company's requirements, such as minimum age and salary expectations.

### Example Code Snippet:

```java
JSONArray applicants = response.getJSONArray("applicants");
for (Object applicant : applicants) {
    if (applicant instanceof JSONObject) {
        int age = ((JSONObject) applicant).getInt("age");
        boolean experience = ((JSONObject) applicant).getBoolean("experience");
        if (age > 18 && experience) {
            System.out.println("The candidate is eligible.");
        }
    }
}
```

This process ensures that the JSON data is validated according to the business logic, filtering candidates based on age, experience, and company requirements.
