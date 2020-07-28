DROP TABLE IF EXISTS tasks;


CREATE TABLE tasks(id int8 NOT NULL,
                           current_status int4 NOT NULL,
                                               end_time TIMESTAMP,
                                                        error_msg VARCHAR (255),
                                                                  start_time TIMESTAMP,
                                                                             username VARCHAR(255) NOT NULL,
                                                                                                   primary key (id));