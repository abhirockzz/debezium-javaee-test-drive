Test drive [**Debezium**](http://debezium.io), quickly...

### Build consumer application

- `git clone https://github.com/abhirockzz/debezium-javaee-test-drive.git`
- `mvn clean install` - this will produce a WAR in `target` directory

### Bootstrap using `docker-compose up --build`

This will start Docker containers - **Debezium Zoookeeper**, **Debezium Kafka**, **Debezium MySQL** (example), **Debezium Kafka Connect**, (a Java EE based) **Kafka Consumer** and [**Yahoo Kafka Manager**](https://hub.docker.com/r/sheepkiller/kafka-manager/)

Wait for all the containers to start before proceeding....

### Create `Debezium MySQL Kafka Connect` connector 

Please substitute your Docker host IP which you can get using `docker-machine ip`. This is the same step as per [Debezium tutorial](http://debezium.io/docs/tutorial/). The only difference is that MySQL (`demysql`) and Kafka (`dekaf`) host names have been changed (as per Docker container names in `docker-compose.yml`). You should see a `201 Created` response

`curl -i -X POST -H "Accept:application/json" -H "Content-Type:application/json" <DOCKER_HOST_IP>:8083/connectors/ -d '{ "name": "inventory-connector", "config": { "connector.class": "io.debezium.connector.mysql.MySqlConnector", "tasks.max": "1", "database.hostname": "demysql", "database.port": "3306", "database.user": "debezium", "database.password": "dbz", "database.server.id": "184054", "database.server.name": "dbserver1", "database.whitelist": "inventory", "database.history.kafka.bootstrap.servers": "dekaf:9092", "database.history.kafka.topic": "dbhistory.inventory" } }'`

### See it in action..

#### Connect to the MySQL Docker container

You can do so using another Docker container (`docker run -it --rm --name mysqlterm --link demysql mysql:5.7 sh -c 'exec mysql -h"$MYSQL_PORT_3306_TCP_ADDR" -P"$MYSQL_PORT_3306_TCP_PORT" -uroot -p"$MYSQL_ENV_MYSQL_ROOT_PASSWORD"'`) as mentioned in the [Debezium tutorial](http://debezium.io/docs/tutorial/) or an external client (I used one)

![](https://abhirockzz.files.wordpress.com/2017/06/mysql-1.jpg)

Once you have connected to MySQL, you can play around with the data

- **Update** a record: `UPDATE customers SET first_name='Anne Marie' WHERE id=1004;`
- **Create** a new record: `INSERT INTO inventory.customers (first_name, last_name, email) VALUES ('abhi', 'rockzz', 'abhirockzz@gmail.com')`
- **Delete** an existing record: `DELETE FROM inventory.customers WHERE email='abhirockzz@gmail.com';`

The consumer will receive the events, parse them and log it - see the highlighted logs in the screen shot below

![](https://abhirockzz.files.wordpress.com/2017/06/results.jpg)

### Configure Yahoo Kafka Manager

**Note**: This is optional

Browse to `http://<DOCKER_HOST_IP>:9000`, choose **Add Cluster** from the **Cluster** menu (ignore Kafka version for now)

![](https://abhirockzz.files.wordpress.com/2017/06/ykm-1.jpg)

You should see the topics created by the Debezium MySQL Kafka Connector

![](https://abhirockzz.files.wordpress.com/2017/06/ykm-2.jpg)

Check the (Java EE) consumer in Yahoo Kafka Manager (using the **Consumers** menu)

![](https://abhirockzz.files.wordpress.com/2017/06/consumer-11.jpg)

### Once you're done...

`docker-compose down -v`
