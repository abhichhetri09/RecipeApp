CREATE TABLE IF NOT EXISTS recipes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    ingredients TEXT,
    instructions TEXT,
    category VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS users (
  id INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(255) NOT NULL,
  `enabled` BOOLEAN NOT NULL DEFAULT TRUE,
  PRIMARY KEY (id),
  UNIQUE INDEX username_UNIQUE (username ASC)
);
CREATE TABLE IF NOT EXISTS `likes` (
  `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
  `user_id` BIGINT NOT NULL,
  `recipe_id` BIGINT NOT NULL,
  FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  FOREIGN KEY (`recipe_id`) REFERENCES `recipes` (`id`),
  UNIQUE (`user_id`, `recipe_id`) -- Ensures a user can only like a recipe once
);

CREATE TABLE IF NOT EXISTS `comments` (
  `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
  `text` TEXT NOT NULL,
  `posted_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `user_id` BIGINT NOT NULL,
  `recipe_id` BIGINT NOT NULL,
  FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  FOREIGN KEY (`recipe_id`) REFERENCES `recipes` (`id`)
);