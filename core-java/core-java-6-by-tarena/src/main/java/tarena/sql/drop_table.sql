CREATE OR REPLACE PROCEDURE drop_all_tables AS
	sql_str varchar2(2000);
	table_name varchar2(32);
	flag varchar2(32);
	CURSOR cur_tablename IS
		SELECT table_name FROM user_tables;
BEGIN
	sql_str := '';
	OPEN cur_tablename;
	DBMS_OUTPUT.PUT_LINE('drop all tables start!');
	LOOP
		FETCH cur_tablename INTO table_name;
		EXIT WHEN cur_tablename%NOTFOUND;
		flag := SUBSTR(table_name, 1, 2);
		IF (flag<>'S_') THEN
			sql_str := 'drop table ' || table_name || ' cascade constraints';
			EXECUTE IMMEDIATE sql_str;
			DBMS_OUTPUT.PUT_LINE(table_name || ' droped ok!');
		END IF;
	END LOOP;
	CLOSE cur_tablename;
	DBMS_OUTPUT.PUT_LINE('drop all tables OK!');
END;
