INSERT INTO tasks(username, current_status, start_time)
VALUES ('maria',
        1,
        TIMESTAMP '2004-10-19 10:23:54');


INSERT INTO tasks(username, current_status, start_time, end_time)
VALUES ('marcos',
        2,
        '2004-10-19 10:23:54',
        '2004-10-19 10:23:58');


INSERT INTO tasks(username, current_status, start_time, end_time, error_msg)
VALUES ('jose',
        3,
        '2004-10-19 10:23:54',
        '2004-10-19 10:23:58',
        'IllegalArgumentException while parsing CNV');


INSERT INTO tasks(username, current_status)
VALUES ('ramon',
        0);


INSERT INTO tasks(username, current_status)
VALUES ('sara',
        0);