CREATE TABLE USERS (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    role VARCHAR(50) NOT NULL,
    currency VARCHAR(255) NOT NULL,
    country VARCHAR(255),
    address VARCHAR (255),
    CONSTRAINT UC_EMAIL UNIQUE (email)
);

CREATE TABLE INDIVIDUALS (
    id BIGINT NOT NULL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    FOREIGN KEY (id) REFERENCES USERS(id)
);

CREATE TABLE ORGANIZATIONS (
    id BIGINT NOT NULL PRIMARY KEY,
    organization_name VARCHAR(255) NOT NULL,
    FOREIGN KEY (id) REFERENCES USERS(id)
);

CREATE TABLE BRANCHES (
    id BIGINT NOT NULL PRIMARY KEY,
    branch_name VARCHAR(255) NOT NULL,
    organization_id BIGINT NOT NULL,
    FOREIGN KEY (id) REFERENCES USERS(id),
    FOREIGN KEY (organization_id) REFERENCES ORGANIZATIONS(id)
);