CREATE TABLE offer
(
    id SERIAL NOT NULL PRIMARY KEY,
    minimum_ticket DECIMAL(10, 2) NOT NULL,
    maximum_ticket DECIMAL(10, 2) NOT NULL,
    monthly_interest_rate DECIMAL(6, 2) NOT NULL,
    minimum_number_of_payments INTEGER NOT NULL,
    maximum_number_of_payments INTEGER NOT NULL,
    days_to_first_payment INTEGER NOT NULL,
    date_activated TIMESTAMP NOT NULL,
    date_deactivated TIMESTAMP,
    active BOOLEAN NOT NULL DEFAULT TRUE
);

