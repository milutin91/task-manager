CREATE TABLE `employees` (
  `employee_id` int PRIMARY KEY auto_increment not null,
  `full_name` varchar(255) not null,
  `email` varchar(255) not null,
  `phone_number` varchar(255) not null,
  `date_of_birth` date not null,
  `monthly_salary` double not null,
  `employee_team_id` int not null
);

CREATE TABLE `tasks` (
  `task_id` int PRIMARY KEY auto_increment not null,
  `title` varchar(255) not null,
  `description` varchar(255) not null,
  `due_date` datetime not null,
  `assignee` int not null
);

CREATE TABLE `teams` (
  `team_id` int PRIMARY KEY auto_increment not null,
  `team_name` varchar(255) not null
);

ALTER TABLE `tasks` ADD FOREIGN KEY (`assignee`) REFERENCES `employees` (`employee_id`);

ALTER TABLE `employees` ADD FOREIGN KEY (`employee_team_id`) REFERENCES `teams` (`team_id`);