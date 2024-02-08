# System Architecture Summary

## Overview
Proof of concept that illustrates a system composed of 6 containers.

### Components:
- **Front-End**: Developed with Angular, it operates on port 4200 and interacts with the server through secured API calls protected with username and password to send requests and receive responses.
- **Server**: A Java-based application server running on port 8082, which handles requests from the front-end, performs CRUD operations and publishes messages to the message broker.
- **Back-End**: A Java-based application running on port 8081, it consumes messages from the message broker and interacts with the database.
- **PostgreSQL**: The relational database system where records are stored, accessible over port 5432.
- **HiveMQ**: An MQTT message broker used for message queuing, running on port 1883.
- **NGINX**: A load balancer used for distributing incoming client requests among a group of servers.

### Save Workflow:
1. The front-end sends a request to the server to store a new record.
2. A response is sent back to the front-end upon successful completion of the operation.
3. The server publishes a message to HiveMQ.
4. The back-end consumes the message from HiveMQ and saves the data in the PostgreSQL database.

### Display Workflow:
1. The front-end sends a request to the server to find all records.
2. The server interacts with the PostgreSQL database to obtain all messages.
3. A response is sent back to the front-end with the complete list of objects.

### Docker Services:
- `software-system-frontend`: Container for the Angular front-end, mapping to the specified host port.
- `software_system_server`: Container for the Java application server, configured with necessary environment settings.
- `software_system_backend`: Container for the Java back-end service, similar to the server setup.
- `system-db`: PostgreSQL database service with volume mappings for data persistence.
- `hivemq`: HiveMQ service for message queuing and processing.
- `nginx`: NGINX load balancer that sends requests to servers that can efficiently handle them to maximize speed and performance.

Each service in the Docker Compose file is orchestrated to start in the correct order, ensuring that dependencies are properly resolved, e.g., the database is ready before the back-end starts.
