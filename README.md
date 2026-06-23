#  Food Rescue & Waste Management System

##  Overview

The **Food Rescue & Waste Management System** is a Java-based desktop application that helps reduce food wastage by connecting food donors with charitable organizations. The system enables food donation, collection, distribution, waste tracking, and notification management through a centralized platform.

---

##  Features

###  Donor Module

* Donor Registration & Login
* Add Food Donations
* View Donation History
* Track Food Status

###  Organization Module

* Organization Registration & Login
* View Available Food Donations
* Collect Food Donations
* Manage Distribution Records

###  Admin Module

* View Registered Donors
* View Registered Organizations
* View Food Records
* View Waste Reports
* View Notifications
* System Analytics Dashboard

###  Waste Management

* Automatic Expiry Detection
* Expired Food Tracking
* Waste Record Generation
* Waste Analytics

###  Notification System

* Food Expiry Notifications
* Read/Unread Notification Status
* User Alert Management

---

##  Tech Stack

* **Java**
* **Java Swing**
* **JDBC**
* **MySQL**
* **Eclipse IDE**

---

##  Database Tables

| Table Name   | Purpose                     |
| ------------ | --------------------------- |
| donor        | Stores donor information    |
| organization | Stores organization details |
| food         | Food donation records       |
| distribution | Food distribution records   |
| food_waste   | Expired/Wasted food records |
| notification | User notifications          |
| admin        | Administrator details       |

---

##  System Workflow

1. Donor registers and logs in.
2. Donor adds food donation details.
3. Organizations view available food.
4. Organizations collect food.
5. Food gets distributed.
6. System automatically checks expired food.
7. Expired food is moved to waste records.
8. Notifications are generated.
9. Admin monitors overall activity.

---

##  Project Structure

```text
src/
├── dao/
├── database/
├── model/
├── service/
└── ui/
```

---





##  Future Enhancements

* Email Notifications
* SMS Alerts
* Mobile Application
* Location-Based Food Matching
* Real-Time Analytics Dashboard
* Food Quality Verification

---

##  Author

**Rutuja Pardeshi**
Second Year Computer Engineering
Cummins College of Engineering for Women, Pune

---

##  License

This project is developed for educational and academic purposes.
