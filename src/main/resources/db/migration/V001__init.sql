CREATE TABLE IF NOT EXISTS category
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(255)
);
ALTER TABLE category
    owner to postgres;

CREATE TABLE IF NOT EXISTS product
(
    id          BIGSERIAL PRIMARY KEY,
    title       VARCHAR(255),
    count       int,
    price       decimal,
    category_id BIGINT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category (id) on delete cascade
);
ALTER TABLE product
    owner to postgres;

