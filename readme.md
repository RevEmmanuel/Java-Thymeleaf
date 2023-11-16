# This project is a toy project for training and quality assurance purposes

# Task 1

- Read the file setup.md to setup project
- use postgreql for database
- Add the following new functionality:
  - Update vet table with field country, license_expire_date
  - Update vet, owner table with field password
  - Add new table taxes (fields: id, country, percentage)
  - Add new table vet_service (fields: id, vet_id, service_name, service_price)
  - Add new table vet_orders (fields: id, pet_id, vet_id, vet_service_id, payment_method, amount, tax, total, status ("new", "completed"))
  - Update the navigation for owners to: Home, Veternarian, logout, My pets
  - Update the navigation for owners to: Home, Owner, logout, Orders, My Services
  - Add Login page for owners
  - Add Login page for vets
  - Add pagination to all table pages
  - Create a page called animal stats where we integrate with API https://api-ninjas.com/api/animals
    And we display all information about animal that we type into a form.
  - On veterinarian page, add new button that link to the services page for that specific vet
  - on service page show all the services for veterinarian in table format with service name, price
  - Owner can click buy now on that service and we go to checkout page with a box stating the service name, amount, tax amount (based on vet country), total and a pay with cash button.
  - Once owner clicks pay with cash, it create order and go to new status. Integrate with stripe api to handle credit cards https://stripe.com/docs/api .
  - Vet can see a page called orders where its a table of orders. Click a button on the row call completed to complete the order. Paginate the orders.
