 **Start the KAFKA server:**
 
 1. start zookeeper:
 
 $ cd ~/kafka/kafka_2.12-2.4.0
 $ bin/zookeeper-server-start.sh config/zookeeper.properties

  2. start kafka:
 
 $ bin/kafka-server-start.sh config/server.properties
    
 **List topics:**  
 
 $ bin/kafka-topics.sh --list --bootstrap-server localhost:9092  