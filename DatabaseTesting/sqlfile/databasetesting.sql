

#create a database
create database demo;

# using that database to add tables in it
use demo;

# create a table
create table credentials(scenario varchar(20), username varchar(20), password varchar(20));

# adding values in the table
insert into credentials values('zerobalancedcard','zerobbc','1234ee');
insert into credentials values('outstbalancedcard','osbbc','12344ee');
insert into credentials values('rewardscard','rcbbc','1222234ee');
insert into credentials values('shoppingcard','scbbc','123444ee');
insert into credentials values('basiccard','bsbbc','123234ee');


# selecting one credentials for our test cases
select * from credentials where scenario='zerobalancedcard';







