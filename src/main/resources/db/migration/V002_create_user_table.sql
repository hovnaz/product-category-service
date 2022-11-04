CREATE TABLE user_model
(
    id        BIGSERIAL PRIMARY KEY,
    name      VARCHAR(255) NOT NULL,
    surname   VARCHAR(255) NOT NULL,
    email     VARCHAR(255) NOT NULL UNIQUE,
    phone     VARCHAR(255) NOT NULL,
    role      VARCHAR(255) NOT NULL DEFAULT 'USER',
    password  VARCHAR(255),
    create_at TIMESTAMP    NOT NULL
);
ALTER TABLE user_model
    owner to postgres;
