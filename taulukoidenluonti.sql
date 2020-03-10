create table topic
(
    id               serial       not null
        constraint topic_pkey
            primary key,
    additionalsource varchar(255),
    complete         boolean      not null,
    completiondate   date,
    creationdate     date,
    description      varchar(255),
    set_alarm        boolean,
    alarm            timestamp,
    title            varchar(255) not null
);

alter table topic
    owner to postgres;