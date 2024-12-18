# AI-Powered Customer Sentiment Tracker

The **AI-Powered Customer Sentiment Tracker** is a Spring Boot-based REST API that helps businesses analyze and manage customer feedback. This application uses a pre-trained AI model (via an external API) to determine the sentiment of feedback (Positive, Neutral, or Negative) and stores the data in a MySQL database for further analysis.

---

## Features

- Add new customer feedback and analyze its sentiment.
- Retrieve all feedback stored in the database.
- Filter feedback based on sentiment (Positive, Neutral, or Negative).
- Securely integrates with an external AI-powered sentiment analysis API.

---

## Tech Stack

- **Backend Framework:** Spring Boot
- **Database:** MySQL
- **ORM:** Spring Data JPA
- **AI Integration:** Pre-trained AI model (via external API)
- **HTTP Client:** RestTemplate
- **Dependency Management:** Maven

---

## Prerequisites

Ensure the following software/tools are installed on your system before proceeding:

- **Java:** JDK 17 or later
- **MySQL:** MySQL Server for database operations
- **Maven:** For building and running the application
- **API Key:** Obtain an API key from a third-party sentiment analysis provider (e.g., [RapidAPI](https://rapidapi.com/)).

---

## Setup Instructions

### Step 1: Clone the Repository

1. Open your terminal and run the following commands:
   ```bash
   git clone https://github.com/your-username/ai-customer-sentiment-tracker.git
   cd ai-customer-sentiment-tracker
