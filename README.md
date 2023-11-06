# Improving-Integration-between-Bahmni-ERM-and-Odoo
Improving Integration between Bahmni ERM and Odoo usingMessaging-Oriented Middleware (MOM)

Title: Improving Integration between Bahmni ERM and Odoo using
Messaging-Oriented Middleware (MOM)

Background:

 This project focuses on enhancing the integration between Bahmni ERM
(Electronic Medical Record) and Odoo (an open-source ERP and CRM
platform). The current integration relies on an atom feed-based Change
Data Capture (CDC) approach, which has encountered significant
challenges. To overcome these issues, the project aims to implement a
more robust and efficient integration using Messaging-Oriented
Middleware (MOM) technology.

Aim:

 Design and implement robust integration between Bahmni EMR and Odoo
Scope: ● Conduct a thorough assessment of the current atom-feed-based
CDC integration.
● Select an appropriate Messaging-Oriented Middleware (MOM)
solution based on project requirements.
● Develop a migration strategy and data migration plan.
● Implement the new MOM-based integration and configure topics
and queues.
● Create data producer and consumer modules for Bahmni ERM and
Odoo.
● Ensure real-time data synchronization, error handling, and security
measures.
Required
resources:

PC
Internet

Deliverables: 

Features & Components

Data Producer (Bahmni ERM): Create a data producer module within
Bahmni ERM to capture patient health records, appointments, and relevant
data changes. Configure the producer to publish data events to the MOM
platform whenever data changes occur.

Data Consumer (Odoo): Develop a data consumer module within Odoo to
subscribe to MOM topics and consume data events. Implement data
mapping and transformation logic to process incoming data and update
corresponding records in Odoo.

Real-time Data Synchronization: Ensure that data changes made in
Bahmni ERM are efficiently synchronized with Odoo in near real-time,
overcoming the challenges of the previous implementation.

Error Handling and Retry Mechanism: Implement robust error handling
and retry mechanisms to address any data synchronization failures
gracefully.

Data Security: Apply appropriate security measures to protect patient
health records and financial data during data exchange, including
encryption and access controls.