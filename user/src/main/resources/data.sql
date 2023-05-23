
-- password: test
insert into tb_user (id, email, name, password, phone_number, status, created_at, modified_at)
values (null, 'test@test.com', 'test', '$2a$10$mhqOqjqu5373On8uXaUMA.TC7IiF0ifcbKkpc9xzcG31O9UObTfv2', '010-1234-5678', 'A', now(), now())
;