CREATE TABLE biome (
    id INT AUTO_INCREMENT PRIMARY KEY,
    creation_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modification_time TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    technical_name VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    color VARCHAR(50) NOT NULL
);

INSERT INTO biome (technical_name, name, color) VALUES ('ocean', 'Océan', '#03224C');
INSERT INTO biome (technical_name, name, color) VALUES ('plain', 'Plaine', '#57D53B');
INSERT INTO biome (technical_name, name, color) VALUES ('forest', 'Fôret', '#095228');
INSERT INTO biome (technical_name, name, color) VALUES ('desert', 'Désert', '#E0CDA9');