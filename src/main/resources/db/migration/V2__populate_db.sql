
INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY) VALUES
('Dmitro Itsko', '2004-05-12', 'Junior', 900),
('Oksana Ivanova', '1985-02-15', 'Senior', 7000),
('Mykola Shevchenko', '1982-11-03', 'Middle', 3000),
('Svitlana Tkachenko', '1992-03-22', 'Trainee', 800),
('Dmytro Kovalenko', '1988-07-18', 'Senior', 5500),
('Olena Sokolova', '1995-01-10', 'Junior', 1200),
('Andriy Bondarenko', '1991-09-30', 'Middle', 2500),
('Natalia Hrytsenko', '1986-04-05', 'Trainee', 600),
('Viktor Moroz', '1923-06-12', 'Senior', 8500),
('Anastasia Koval', '1993-12-25', 'Junior', 1000);

INSERT INTO client (NAME) VALUES
('Veronika Antonenko'),
('Rostislav Redko'),
('Polina Stepanenko'),
('Yana Polushko'),
('Volodimir Poroshenko');


INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE) VALUES
(1, '2023-01-01', '2024-01-01'),
(2, '2022-06-01', '2023-06-01'),
(3, '2021-05-01', '2023-05-01'),
(4, '2022-02-01', '2023-04-01'),
(5, '2023-03-01', '2023-10-01'),
(1, '2023-08-01', '2024-01-01'),
(2, '2021-12-01', '2022-08-01'),
(3, '2020-01-01', '2021-01-01'),
(4, '2022-10-01', '2023-10-01'),
(5, '2023-07-01', '2024-02-01'),
(5, '2023-03-01', '2024-02-01');

INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES
(1, 1), (1, 2), (1, 3),
(2, 1), (2, 2),
(3, 4), (3, 5), (3, 6),
(4, 3), (4, 7),
(5, 8), (5, 9),
(6, 1), (6, 4),
(7, 5), (7, 6), (7, 8),
(8, 2), (8, 9),
(9, 3), (9, 10),
(10, 2), (10, 6);