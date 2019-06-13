ALTER DATABASE d13hkt361jb0pk SET timezone TO 'America/Argentina/Buenos_Aires';
INSERT INTO roles(name) VALUES('ROLE_USER')  ON CONFLICT (name) DO NOTHING;
INSERT INTO roles(name) VALUES('ROLE_ADMIN') ON CONFLICT (name) DO NOTHING;
