CREATE TABLE biome (
    id INT AUTO_INCREMENT PRIMARY KEY,
    creation_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modification_time TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    technical_name VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    ordre INT NULL,
    color VARCHAR(50) NOT NULL
);

INSERT INTO biome (technical_name, name, color, ordre) VALUES ('ocean', 'Océan', '#03224C', 100);
INSERT INTO biome (technical_name, name, color, ordre) VALUES ('plain', 'Plaine', '#57D53B', 200);
INSERT INTO biome (technical_name, name, color, ordre) VALUES ('forest', 'Fôret', '#095228', 300);
INSERT INTO biome (technical_name, name, color, ordre) VALUES ('desert', 'Désert', '#E0CDA9', 400);