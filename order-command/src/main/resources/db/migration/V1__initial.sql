CREATE TABLE ORDERS (
    id UUID PRIMARY KEY,
    customer_id UUID NOT NULL,
    type TEXT NOT NULL,
    status TEXT NOT NULL,
    version NUMERIC NOT NULL
);