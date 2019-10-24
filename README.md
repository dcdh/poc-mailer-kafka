# POC

> Simple poc to demonstrate an issue when using kafka and email sender when running test

## how to

1. start containers by running *run_containers.sh* scripts.
/!\ warning: it will kill and remove all running containers.

2. run `mvn clean test`

> At the end the test will hang.
>
> To make it stopping as expected you'll have to remove *quarkus-mailer* dependency however it is not possible in a real application using both kafka and mailer
>
