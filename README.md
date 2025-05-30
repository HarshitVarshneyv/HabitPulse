# 🧠 HabitPulse - Daily Habit Tracking System

**HabitPulse** is a Spring Boot-based backend project that allows users to build, log, and analyze daily habits. It features RESTful APIs to help users maintain consistency through streak tracking, daily logging, and performance summaries.

---

## 🚀 Features

* Register users
* Create daily habits
* Log completion of habits
* Track current streaks
* Summarize habit performance (% completed, missed days, etc.)

---

## 📦 Tech Stack

* Java 17+
* Spring Boot 3
* Spring Data JPA
* PostgreSQL / H2 (for testing)

---

## 📚 API Endpoints

| Method | Endpoint                   | Description                                  |
| ------ | -------------------------- | -------------------------------------------- |
| POST   | `/api/users`               | Register a new user                          |
| POST   | `/api/habits?userId={id}`  | Create a new habit for a user                |
| POST   | `/api/habits/{id}/log`     | Log a habit for today                        |
| GET    | `/api/habits/{id}/streak`  | Get current streak for a habit               |
| GET    | `/api/users/{id}/habits`   | List all habits of a user                    |
| GET    | `/api/habits/{id}/summary` | View summary (completed, missed, percentage) |

---

## 📁 Project Structure

```
com.habitpulse
├── controller       // REST Controllers
├── service          // Business logic interfaces & impls
├── model            // Entity classes (User, Habit, HabitLog)
├── repository       // Spring JPA Repositories
├── dto              // Summary DTO
├── exception        // Custom exceptions (optional)
└── HabitPulseApplication.java
```

---

## 🛠 Setup Instructions

1. Clone the repo:

```bash
git clone https://github.com/your-username/habitpulse-backend.git
cd habitpulse-backend
```

2. Configure DB in `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/habitpulse
spring.datasource.username=yourUsername
spring.datasource.password=yourPassword
```

3. Run the app:

```bash
./mvnw spring-boot:run
```

---

## 🔮 Future Enhancements

* Daily email reminders using Spring Scheduler
* Filter habits by active/inactive
* Longest streak tracking
* User dashboard with full habit analytics

---

## 🙌 Contributing

Pull requests are welcome! For major changes, open an issue first to discuss what you would like to change.

---
---

> Inspired by real-life productivity apps like Habitica, Streaks, and Done.

Contact : harshitvarshneyv2@gmail.com
