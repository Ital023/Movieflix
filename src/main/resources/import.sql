INSERT INTO tb_user (name, email, password) VALUES ('Bob', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Ana', 'ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_VISITOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_MEMBER');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);


INSERT INTO tb_review (text, user_id) VALUES ('Meh, filme OK', 1);
INSERT INTO tb_review (text, user_id) VALUES ('Gostei e recomendo!', 1);
INSERT INTO tb_review (text, user_id) VALUES ('Que Filme!!!', 1);

INSERT INTO tb_review (text, user_id) VALUES ('Qaaaaa gostei!!!', 2);
INSERT INTO tb_review (text, user_id) VALUES ('testeee!!!', 2);