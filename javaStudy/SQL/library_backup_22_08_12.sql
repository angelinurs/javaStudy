-- design library scheme
drop database library;
create database library;

use library;

-- books table
drop table `library`.`books`;
create table `library`.`books` (
	book_idx bigint auto_increment,
    book_name varchar( 100 ) not null,
    isbn varchar( 50 ) not null,
    borrowed bool default false not null,
    place varchar( 50 ) not null,
    constraint primary key( book_idx )
);

-- members table
drop table `library`.`members`;
create table `library`.`members` (
	m_idx bigint auto_increment,
    m_name varchar( 100 ) not null,
    m_contact varchar( 100 ) not null,
    m_jumin varchar( 10 ) not null,
    m_birth varchar( 10 ) not null,
    m_address varchar( 256 ) not null,
    m_activate bool default true,
    constraint members_t_pk primary key( m_idx, m_name )
);

-- book_status table
drop table `library`.`book_status`;
create table `library`.`book_status` (
	bs_idx bigint auto_increment,
    book_idx bigint not null,
    borrowed_idx bigint,
    borrowed_name varchar( 100 ) not null,
    borrow_from_date date,
    borrow_to_date date,

	constraint primary key( bs_idx ),
    
    constraint FOREIGN KEY ( borrowed_idx, borrowed_name )
      REFERENCES `library`.`members`( m_idx, m_name ),
    
    constraint members_t_fk foreign key( book_idx ) 
		references `library`.`books`( book_idx )
);
