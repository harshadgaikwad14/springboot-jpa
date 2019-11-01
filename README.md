# springboot-jpa

As you can see, we have the expected user table. 
Apart from that, we also have a new table called user_aud. 
The audit tables contain all the fields from the original table.

However, two new fields are also added. First is the REVTYPE field. 
This contains “0” for adding, “1” for updating, “2” for deleting. 
The other field is the REV field.

There is another table that gets generated. 
It is called REVINFO. It contains two fields REV and REVTSTMP. 
REV field in the user_aud is basically a foreign key to REV field in REVINFO table. 
The REVINFO tables keeps track of every transaction.